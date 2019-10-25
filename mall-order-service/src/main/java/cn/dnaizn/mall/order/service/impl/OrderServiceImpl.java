package cn.dnaizn.mall.order.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.dnaizn.mall.DTO.OrderDTO;
import cn.dnaizn.mall.VO.*;
import cn.dnaizn.mall.exception.MallException;
import cn.dnaizn.mall.mapper.OrderItemMapper;
import cn.dnaizn.mall.mapper.OrderMainMapper;
import cn.dnaizn.mall.mapper.OrdersAdjustmentMapper;
import cn.dnaizn.mall.pojo.*;
import cn.dnaizn.mall.utils.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.dnaizn.mall.service.OrderService;

import entity.PageResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMainMapper orderMainMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Autowired
    OrdersAdjustmentMapper ordersAdjustmentMapper;

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
    public void genDeliver(String orderId) {
        String timestamp = System.currentTimeMillis() / 1000 + "";
        String nonce_str = KeyUtil.getRandomString(32);
        String url = "openApi/deliver/gen";
        Map<String, String> map = new HashMap<>();
        map.put("oid", orderId);
        map.put("timestamp", timestamp);
        map.put("nonce_str", nonce_str);
        Object o = JSONObject.toJSONString(SignUtil.create(map));
        JSONObject jsonObject = JSON.parseObject(o.toString());
        JSONObject jsonObject1 = HttpUtil.jsonPost(url, jsonObject);
        if (jsonObject1.getString("code").equals("0")) {
            throw new MallException(1, jsonObject1.getString("msg"));
        }
    }
}
