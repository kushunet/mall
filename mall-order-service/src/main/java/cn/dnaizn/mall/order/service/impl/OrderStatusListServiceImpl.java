package cn.dnaizn.mall.order.service.impl;

import java.util.List;

import cn.dnaizn.mall.mapper.OrderStatusListMapper;
import cn.dnaizn.mall.pojo.OrderStatusList;
import cn.dnaizn.mall.pojo.OrderStatusListExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.dnaizn.mall.service.OrderStatusListService;

import entity.PageResult;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
public class OrderStatusListServiceImpl implements OrderStatusListService {

    @Autowired
    OrderStatusListMapper orderStatusListMapper;

    /**
     * 查询全部
     */
    @Override
    public List<OrderStatusList> findAll() {
        return orderStatusListMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<OrderStatusList> page = (Page<OrderStatusList>) orderStatusListMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(OrderStatusList orderStatusList) {
        orderStatusListMapper.insert(orderStatusList);
    }


    /**
     * 修改
     */
    @Override
    public void update(OrderStatusList orderStatusList) {
        orderStatusListMapper.updateByPrimaryKey(orderStatusList);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public OrderStatusList findOne(Integer id) {
        return orderStatusListMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            orderStatusListMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public PageResult findPage(OrderStatusList orderStatusList, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        OrderStatusListExample example = new OrderStatusListExample();
        OrderStatusListExample.Criteria criteria = example.createCriteria();

        if (orderStatusList != null) {
            if (orderStatusList.getOrderId() != null && orderStatusList.getOrderId().length() > 0) {
                criteria.andOrderIdLike("%" + orderStatusList.getOrderId() + "%");
            }

        }

        Page<OrderStatusList> page = (Page<OrderStatusList>) orderStatusListMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

}
