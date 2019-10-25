package cn.dnaizn.mall.sell.controller;

import cn.dnaizn.mall.VO.ResultVO;
import cn.dnaizn.mall.service.OrderService;
import cn.dnaizn.mall.util.ResultVOUtil;
import cn.dnaizn.mall.utils.HttpUtil;
import cn.dnaizn.mall.utils.KeyUtil;
import cn.dnaizn.mall.utils.SignUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Reference
    OrderService orderService;

    @RequestMapping("/deliver")
    @RolesAllowed({"SELLER","VISITORS"})
    public ResultVO deliver(@RequestBody Map<String, String> map) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (orderService.findOneOrderMain(map.get("order_id")).getSellerId().equals(sellerId)) {
            return getResultVO(map, "openApi/deliver/delivery");
        } else {
            return ResultVOUtil.error(1, "该订单不属于该用户！");
        }
    }
    @RequestMapping("/gen")
    @RolesAllowed({"SELLER","VISITORS"})
    public ResultVO gen(@RequestBody Map<String, String> map) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (orderService.findOneOrderMain(map.get("order_id")).getSellerId().equals(sellerId)) {
            return getResultVO(map, "openApi/deliver/gen");
        } else {
            return ResultVOUtil.error(1, "该订单不属于该用户！");
        }
    }
    @RequestMapping("/userInfoEdit")
    @RolesAllowed({"SELLER","VISITORS"})
    public ResultVO userInfoEdit(@RequestBody Map<String, String> map) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (orderService.findOneOrderMain(map.get("order_id")).getSellerId().equals(sellerId)) {
            return getResultVO(map, "openApi/deliver/user_info_edit");
        } else {
            return ResultVOUtil.error(1, "该订单不属于该用户！");
        }
    }
    @RequestMapping("/info")
    @RolesAllowed({"SELLER","VISITORS"})
    public ResultVO info(@RequestBody Map<String, String> map) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (orderService.findOneOrderMain(map.get("order_id")).getSellerId().equals(sellerId)) {
            return getResultVO(map, "openApi/deliver/info");
        } else {
            return ResultVOUtil.error(1, "该订单不属于该用户！");
        }
    }
//    @RequestMapping("/Linfo")
//    @RolesAllowed({"SELLER","VISITORS"})
//    public ResultVO Linfo(@RequestBody Map<String, String> map) {
//        try {
//            orderService.genDeliver(map.get("order_id"));
//            return ResultVOUtil.success();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResultVOUtil.error(1,e.getMessage());
//        }
//    }
    private ResultVO getResultVO(@RequestBody Map<String, String> map, String s) {
        String timestamp = System.currentTimeMillis() / 1000 + "";
        String nonce_str = KeyUtil.getRandomString(32);
        map.put("timestamp", timestamp);
        map.put("nonce_str", nonce_str);
        Object o = JSONObject.toJSONString(SignUtil.create(map));
        JSONObject jsonObject = JSON.parseObject(o.toString());
        return ResultVOUtil.success(HttpUtil.jsonPost(s, jsonObject));
    }
}
