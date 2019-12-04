package cn.dnaizn.mall.sell.controller;

import cn.dnaizn.mall.VO.ResultVO;
import cn.dnaizn.mall.pojo.OrderMain;
import cn.dnaizn.mall.pojo.Printer;
import cn.dnaizn.mall.service.OrderService;
import cn.dnaizn.mall.service.SellerService;
import cn.dnaizn.mall.util.ResultVOUtil;
import cn.dnaizn.mall.utils.HttpUtil;
import cn.dnaizn.mall.utils.SignUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GT62VR
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Reference
    OrderService orderService;

    @Reference
    SellerService sellerService;

    /**
     * 配送订单操作
     * send	    发起配送
     * query	查询配送订单
     * cancel	取消配送
     * fee	    获取配送费用
     *
     * @param map
     * @return
     */
    @RequestMapping("/deliver")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO deliver(@RequestBody Map<String, Object> map) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (orderService.findOneOrderMain(map.get("order_id").toString()).getSellerId().equals(sellerId)) {
            return ResultVOUtil.success(
                    orderService.deliver(map.get("order_id").toString(), map.get("type").toString()));
        } else {
            return ResultVOUtil.error(1, "该订单不属于该用户！");
        }
    }

    /**
     * 配送订单生成
     * 生成订单的同时会 接受订单
     *
     * @param orderId
     * @return
     */
    @RequestMapping("/gen")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO gen(String orderId) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (orderService.findOneOrderMain(orderId).getSellerId().equals(sellerId)) {
            printing(orderId);
            return ResultVOUtil.success(orderService.gen(orderId));
        } else {
            return ResultVOUtil.error(1, "该订单不属于该用户！");
        }
    }

    /**
     * 更新配送信息
     *
     * @param map
     * @return
     */
    @RequestMapping("/userInfoEdit")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO userInfoEdit(@RequestBody Map<String, Object> map) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (orderService.findOneOrderMain(map.get("order_id").toString()).getSellerId().equals(sellerId)) {
            return getResultVO(map, HttpUtil.ORDER_URL + "openApi/deliver/user_info_edit");
        } else {
            return ResultVOUtil.error(1, "该订单不属于该用户！");
        }
    }

    /**
     * 查看配送订单信息
     *
     * @param map
     * @return
     */
    @RequestMapping("/info")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO info(@RequestBody Map<String, Object> map) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (orderService.findOneOrderMain(map.get("order_id").toString()).getSellerId().equals(sellerId)) {
            return getResultVO(map, HttpUtil.ORDER_URL + "openApi/deliver/info");
        } else {
            return ResultVOUtil.error(1, "该订单不属于该用户！");
        }
    }

    /**
     * 商家同意退单
     *
     * @param map
     * @return
     */
    @RequestMapping("/agree")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO agree(@RequestBody Map<String, Object> map) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        OrderMain orderMain = orderService.findOneOrderMain(map.get("order_id").toString());
        if (orderMain.getSellerId().equals(sellerId)) {
            map.put("refund_fee", orderMain.getPayment());
            map.put("seller_id", orderMain.getSellerId());
            Object o = JSONObject.toJSONString(SignUtil.create(map));
            JSONObject jsonObject = JSON.parseObject(o.toString());
            Object o1 = HttpUtil.jsonPost(HttpUtil.ORDER_URL + "openApi/order/refund/agree", jsonObject);
            System.out.println(o1);
            JSONObject jsonObject1 = JSON.parseObject(o1.toString());
            if (jsonObject1.getString("code").equals("0")) {
                orderService.deliver(map.get("order_id").toString(), "cancel");
            }
            return ResultVOUtil.success(jsonObject1);
        } else {
            return ResultVOUtil.error(1, "该订单不属于该用户！");
        }
    }

    /**
     * 商家拒绝退单
     *
     * @param map
     * @return
     */
    @RequestMapping("/agreeNo")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO agreeNo(@RequestBody Map<String, Object> map) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        OrderMain orderMain = orderService.findOneOrderMain(map.get("order_id").toString());
        if (orderMain.getSellerId().equals(sellerId)) {
            map.put("seller_id", orderMain.getSellerId());
            return getResultVO(map, HttpUtil.ORDER_URL + "openApi/order/refund/agree_no");
        } else {
            return ResultVOUtil.error(1, "该订单不属于该用户！");
        }
    }

    /**
     * 商家提现
     *
     * @param map
     * @return
     */
    @RequestMapping("/transfers")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO transfers(@RequestBody Map<String, Object> map) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean checkSmsCode = sellerService.checkSmsCode(sellerService.findOne(sellerId).getMobile(),
                map.get("code").toString(), 2);
        if (!checkSmsCode) {
            return ResultVOUtil.error(1, "验证码错误！");
        }
        map.remove("code");
        map.put("seller_id", sellerId);
        return getResultVO(map, HttpUtil.ORDER_URL + "openApi/merchant/transfers");
    }

    /**
     * 商家拒绝接单
     *
     * @param map
     * @return
     */
    @RequestMapping("/rejectOrder")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO rejectOrder(@RequestBody Map<String, Object> map) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (orderService.findOneOrderMain(map.get("order_id").toString()).getSellerId().equals(sellerId)) {
            return getResultVO(map, HttpUtil.ORDER_URL + "openApi/order/reject_order");
        } else {
            return ResultVOUtil.error(1, "该订单不属于该用户！");
        }
    }
    @RequestMapping("/isOpenid")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO isOpenid() {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            return ResultVOUtil.success(sellerService.isOpenid(sellerId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1,e.getMessage());
        }
    }
    /**
     * 商家获取openid
     *
     * @return
     */
    @RequestMapping("/bindWxQrCode")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO bindWxQrCode() {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> map = new HashMap<>();
        map.put("seller_id", sellerId);
        return getResultVO(map, HttpUtil.ORDER_URL + "openApi/merchant/bindWxQrCode");
    }

    @RequestMapping("/addPos")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO addPos(@RequestBody Map<String, Object> map) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Object o = JSONObject.toJSONString(SignUtil.create(map));
        JSONObject jsonObject = JSON.parseObject(o.toString());
        JSONObject object = HttpUtil.jsonPost(HttpUtil.PRIN_URL + "pos/add", jsonObject);
        Printer printer = new Printer();
        printer.setSellerId(sellerId);
        printer.setIsEnable(0);
        printer.setPrinterId(object.getString("pos_id"));
        try {
            sellerService.addPrinter(printer);
            return ResultVOUtil.success(object);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, "添加不成功");
        }
    }

    @RequestMapping("/updatePos")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO updatePos(@RequestBody Map<String, Object> map) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Object o = JSONObject.toJSONString(SignUtil.create(map));
        JSONObject jsonObject = JSON.parseObject(o.toString());
        JSONObject object = HttpUtil.jsonPost(HttpUtil.PRIN_URL + "pos/update", jsonObject);
        Printer printer = new Printer();
        printer.setSellerId(sellerId);
        if (map.get("stats").equals("2")){
            printer.setIsEnable(Integer.parseInt(String.valueOf(System.currentTimeMillis()).substring(0, 10)));
        }
        printer.setPrinterId(map.get("pos_id").toString());
        try {
            sellerService.updatePrinter(printer);
            return ResultVOUtil.success(object);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, "修改不成功");
        }
    }
    @RequestMapping("/deletePos")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO deletePos(String posId) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Printer printer = sellerService.findPrinter(posId);
        if (!printer.getSellerId().equals(sellerId)){
            return ResultVOUtil.error(1, "该打印机不属于该商户！！");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("pos_id",posId);
        Object o = JSONObject.toJSONString(SignUtil.create(map));
        JSONObject jsonObject = JSON.parseObject(o.toString());
        JSONObject object = HttpUtil.jsonPost(HttpUtil.PRIN_URL + "pos/delete", jsonObject);
        try {
            sellerService.deletePos(printer.getId());
            return ResultVOUtil.success(object);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, "修改不成功");
        }
    }
    @RequestMapping("/findPrinter")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO findPrinter() {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Printer> printerList = sellerService.findPrinterList(sellerId);
        System.out.println(printerList);
        if (printerList.size() < 1){
            return ResultVOUtil.success();
        }
        List<String> pos_ids = new ArrayList<>();
        for (Printer item : printerList) {
            pos_ids.add(item.getPrinterId());
        }
        System.out.println(JSONArray.toJSONString(pos_ids));
        Map<String, Object> map = new HashMap<>();
        map.put("pos_id", JSON.parseArray(JSONArray.toJSONString(pos_ids)));
        return getResultVO(map, HttpUtil.PRIN_URL + "pos/pos");
    }

    @RequestMapping("/printing")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO printing(String orderId) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        OrderMain orderMain = orderService.findOneOrderMain(orderId);
        if (orderMain.getSellerId().equals(sellerId)) {
            try {
                orderService.create(orderMain.getOrderId(),sellerId);
                return ResultVOUtil.success(orderService.printing(orderMain.getOrderId()));
            } catch (Exception e) {
                e.printStackTrace();
                return ResultVOUtil.error(1, e.getMessage());
            }
        } else {
            return ResultVOUtil.error(1, "该订单不属于该用户！");
        }
    }

    @RequestMapping("/posStatus")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO posStatus(@RequestBody Map<String, Object> map) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!sellerService.findPrinter(map.get("pos_id").toString()).getSellerId().equals(sellerId)){
            return ResultVOUtil.error(1,"该打印机不属于该商家！！");
        }
        Object o = JSONObject.toJSONString(SignUtil.create(map));
        JSONObject jsonObject = JSON.parseObject(o.toString());
        return  ResultVOUtil.success(HttpUtil.jsonPost(HttpUtil.PRIN_URL + "pos/status", jsonObject));
    }

    private ResultVO getResultVO(@RequestBody Map<String, Object> map, String s) {
        Object o = JSONObject.toJSONString(SignUtil.create(map));
        JSONObject jsonObject = JSON.parseObject(o.toString());
        return ResultVOUtil.success(JSON.parseObject(HttpUtil.jsonPost(s, jsonObject).toString()));
    }
}
