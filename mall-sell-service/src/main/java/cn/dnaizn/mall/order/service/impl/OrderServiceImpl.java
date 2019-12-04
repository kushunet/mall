package cn.dnaizn.mall.order.service.impl;

import cn.dnaizn.mall.DTO.GoodsPrintDto;
import cn.dnaizn.mall.DTO.OrderDTO;
import cn.dnaizn.mall.VO.OrderItemVO;
import cn.dnaizn.mall.VO.OrderMainVO;
import cn.dnaizn.mall.VO.OrderVO;
import cn.dnaizn.mall.VO.OrdersAdjustmentVO;
import cn.dnaizn.mall.exception.MallException;
import cn.dnaizn.mall.mapper.*;
import cn.dnaizn.mall.pojo.*;
import cn.dnaizn.mall.service.OrderService;
import cn.dnaizn.mall.util.RedisUtil;
import cn.dnaizn.mall.utils.HttpUtil;
import cn.dnaizn.mall.utils.ListUtils;
import cn.dnaizn.mall.utils.MyPageHelper;
import cn.dnaizn.mall.utils.SignUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMainMapper orderMainMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Autowired
    OrdersAdjustmentMapper ordersAdjustmentMapper;

    @Autowired
    OrderStatusListMapper orderStatusListMapper;

    @Autowired
    SellerBriefMapper sellerBriefMapper;

    @Autowired
    PrinterMapper printerMapper;

    @Autowired
    RedisUtil redisUtil;
    /**
     * 查询全部
     */
    @Override
    public PageResult findAll(OrderDTO orderDTO, int pageNum, int pageSize) {
        OrderMainExample example = new OrderMainExample();
        OrderMainExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(orderDTO.getSellerId());
        if (orderDTO.getStartTime() != null && orderDTO.getStartTime() != 0
                && orderDTO.getEndTime() != null && orderDTO.getEndTime() != 0) {
            criteria.andCTimestampBetween(orderDTO.getStartTime(), orderDTO.getEndTime());
        }
        if (orderDTO.getState() != null) {
            criteria.andStatusIn(orderDTO.getState());
        }
        if (orderDTO.getAfterSale() != null) {
            criteria.andAfterSaleIn(orderDTO.getAfterSale());
        }
        criteria.andPaymentTimeIsNotNull();
        if (orderDTO.getOrder() != null) {
            if (orderDTO.getOrder() == 1) {
                example.setOrderByClause("day_sn desc");
            } else if (orderDTO.getOrder() == 2) {
                example.setOrderByClause("c_timestamp desc");
            }
        }
        return getPageResult(pageNum, pageSize, example);
    }

    @Override
    public PageResult findNoSettlementPage(String sellerId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        OrderMainExample example = new OrderMainExample();
        OrderMainExample.Criteria criteria = example.createCriteria();
        criteria.andCTimestampLessThanOrEqualTo(
                Integer.parseInt((getTodayZeroPointTimestamps().toString().substring(0,10))));
        System.out.println(System.currentTimeMillis());
        System.out.println(getTodayZeroPointTimestamps());
        criteria.andEndTimeIsNull();
        criteria.andPaymentTimeIsNotNull();
        criteria.andSellerIdEqualTo(sellerId);
        example.setOrderByClause("payment_time desc");
        Page<OrderMain> page = (Page<OrderMain>) orderMainMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
    private Long getTodayZeroPointTimestamps(){
        Long currentTimestamps=System.currentTimeMillis();
        Long oneDayTimestamps= Long.valueOf(60*60*24*1000);
        return currentTimestamps-(currentTimestamps+60*60*8*1000)%oneDayTimestamps;
    }
    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<OrderMain> page = (Page<OrderMain>) orderMainMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(OrderMain order) {
        orderMainMapper.insert(order);
    }


    /**
     * 修改
     */
    @Override
    public void update(OrderMain order) {
        orderMainMapper.updateByPrimaryKey(order);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public OrderVO findOne(String id) {
        OrderVO orderVO = new OrderVO();
        OrderMainVO orderMainVO = new OrderMainVO();
        BeanUtils.copyProperties(orderMainMapper.selectByPrimaryKey(id), orderMainVO);
        orderVO.setOrderMainVO(orderMainVO);
        ListUtils<OrderItemVO> orderItemVOListUtils = BeanUtils.instantiate(ListUtils.class);
        OrderItemExample example = new OrderItemExample();
        OrderItemExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(id);
        List<OrderItem> orderItemList = orderItemMapper.selectByExample(example);
        List<OrderItemVO> orderItemVOList = new ArrayList<>();
        orderItemVOListUtils.copyList(orderItemList, orderItemVOList, OrderItemVO.class);
        ListUtils<OrdersAdjustmentVO> ordersAdjustmentVOListUtils = BeanUtils.instantiate(ListUtils.class);
        OrdersAdjustmentExample example1 = new OrdersAdjustmentExample();
        OrdersAdjustmentExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andOrderIdEqualTo(id);
        List<OrdersAdjustment> ordersAdjustmentList = ordersAdjustmentMapper.selectByExample(example1);
        List<OrdersAdjustmentVO> ordersAdjustmentVOList = new ArrayList<>();
        ordersAdjustmentVOListUtils.copyList(ordersAdjustmentList, ordersAdjustmentVOList, OrdersAdjustmentVO.class);
        orderVO.setOrderMainVO(orderMainVO);
        orderVO.setOrderItemVOList(orderItemVOList);
        orderVO.setOrdersAdjustmentVOList(ordersAdjustmentVOList);
        OrderStatusListExample example2 = new OrderStatusListExample();
        OrderStatusListExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andOrderIdEqualTo(id);
        orderVO.setOrderStatusListList(orderStatusListMapper.selectByExample(example2));
        return orderVO;
    }

    @Override
    public OrderMain findOneOrderMain(String id) {
        return orderMainMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(String[] ids) {
        for (String id : ids) {
            orderMainMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public PageResult findPage(OrderMain orderMain, int pageNum, int pageSize) {
        OrderMainExample example = new OrderMainExample();
        OrderMainExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(orderMain.getSellerId());

        if (orderMain.getOrderId() != null && orderMain.getOrderId().length() > 0) {
            criteria.andOrderIdEqualTo(orderMain.getOrderId());
        }
        if (orderMain.getShippingName() != null && orderMain.getShippingName().length() > 0) {
            criteria.andShippingNameEqualTo(orderMain.getShippingName());
        }
        if (orderMain.getShippingCode() != null && orderMain.getShippingCode().length() > 0) {
            criteria.andShippingCodeEqualTo(orderMain.getShippingCode());
        }
        if (orderMain.getReceiverMobile() != null && orderMain.getReceiverMobile().length() > 0) {
            criteria.andReceiverMobileLike("%" + orderMain.getReceiverMobile() + "%");
        }
        if (orderMain.getDaySn() != null) {
            criteria.andDaySnEqualTo(orderMain.getDaySn());
        }
        criteria.andPaymentTimeIsNotNull();
        criteria.andCTimestampBetween((int) ((System.currentTimeMillis() - 2592000000L) / 1000),
                (int) (System.currentTimeMillis() / 1000));
        example.setOrderByClause("c_timestamp desc");
        return getPageResult(pageNum, pageSize, example);
    }

    private PageResult getPageResult(int pageNum, int pageSize, OrderMainExample example) {
        List<OrderMain> orderMainList = orderMainMapper.selectByExample(example);
        List<OrderVO> orderVOList = new ArrayList<>();
        for (OrderMain item : orderMainList) {
            OrderVO orderVO = findOne(item.getOrderId());
            orderVOList.add(orderVO);
        }
        MyPageHelper<OrderVO> myPageHelper = new MyPageHelper<>(orderVOList, pageNum, pageSize);
        return new PageResult(myPageHelper.getTotal(), myPageHelper.getList());
    }

    @Override
    public Object gen(String orderId) {
        String url = "openApi/deliver/gen";
        Map<String, Object> map = new HashMap<>();
        map.put("oid", orderId);
        Object o = JSONObject.toJSONString(SignUtil.create(map));
        JSONObject jsonObject = JSON.parseObject(o.toString());
        return HttpUtil.jsonPost(HttpUtil.ORDER_URL + url, jsonObject);
    }

    @Override
    public Object deliver(String orderId, String prepare) {
        String url = "openApi/deliver/delivery";
        Map<String, Object> map = new HashMap<>();
        map.put("order_id", orderId);
        map.put("type", prepare);
        Object o = JSONObject.toJSONString(SignUtil.create(map));
        JSONObject jsonObject = JSON.parseObject(o.toString());
        return HttpUtil.jsonPost(HttpUtil.ORDER_URL + url, jsonObject);
    }


    @Override
    public void create(String orderId, String sellerId) {
        String u = "orders/delete";
        Map<String, Object> m = new HashMap<>();
        m.put("third_id", orderId);
        Object o = JSONObject.toJSONString(SignUtil.create(m));
        JSONObject jsonObject = JSON.parseObject(o.toString());
        System.out.println(HttpUtil.jsonPost(HttpUtil.PRIN_URL + u, jsonObject).toJSONString());
        String url = "orders/create";
        OrderVO orderVO = findOne(orderId);
        PrinterExample example = new PrinterExample();
        PrinterExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        List<Printer> printerList = printerMapper.selectByExample(example);
        if(printerList.size()<1){
            throw new  MallException(1,"该商家没有打印机");
        }
        SellerBrief sellerBrief = sellerBriefMapper.selectByPrimaryKey(sellerId);
        Map<String, Object> map = new HashMap<>();
        map.put("title", sellerBrief.getNickName());
        map.put("third_id", orderVO.getOrderMainVO().getOrderId());
        map.put("serial_id", orderVO.getOrderMainVO().getDaySn());
        List<String> stringList = new ArrayList<>();
        for (OrdersAdjustmentVO item : orderVO.getOrdersAdjustmentVOList()) {
            stringList.add(item.getTitle());
        }
        map.put("information_offers", stringList);
        List<GoodsPrintDto> goodsPrintDtoArrayList = new ArrayList<>();
        for (OrderItemVO item : orderVO.getOrderItemVOList()) {
            GoodsPrintDto goodsPrintDto = new GoodsPrintDto();
            goodsPrintDto.setTitle(item.getTitle());
            goodsPrintDto.setNum(item.getNum());
            goodsPrintDto.setPrice(item.getPrice());
            goodsPrintDtoArrayList.add(goodsPrintDto);
        }
        map.put("product", goodsPrintDtoArrayList);
        map.put("total", orderVO.getOrderMainVO().getTotal());
        map.put("address", orderVO.getOrderMainVO().getReceiverAreaName());
        map.put("name", orderVO.getOrderMainVO().getReceiver());
        if (orderVO.getOrderMainVO().getBuyerMessage().isEmpty()){
            orderVO.getOrderMainVO().setBuyerMessage("未填");
        }
        map.put("remarks", orderVO.getOrderMainVO().getBuyerMessage());
        map.put("platform_type", "3");
        map.put("platform_type_ext", "比送达商城");
        map.put("phone", orderVO.getOrderMainVO().getReceiverMobile());
        for (Printer printer : printerList) {
            map.put("pos_id", printer.getPrinterId());
            o = JSONObject.toJSONString(SignUtil.create(map));
            jsonObject = JSON.parseObject(o.toString());
            System.out.println(jsonObject);
            System.out.println(HttpUtil.jsonPost(HttpUtil.PRIN_URL + url, jsonObject).toJSONString());
        }
    }

    @Override
    public Object printing(String orderId) {
        String url = "pos/printing";
        Map<String,Object> map = new HashMap<>();
        map.put("third_id",orderId);
        Object o = JSONObject.toJSONString(SignUtil.create(map));
        JSONObject jsonObject = JSON.parseObject(o.toString());
        return HttpUtil.jsonPost(HttpUtil.PRIN_URL + url, jsonObject);
    }
}
