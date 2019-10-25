package cn.dnaizn.mall.order.service.impl;

import java.util.List;

import cn.dnaizn.mall.mapper.OrderItemMapper;
import cn.dnaizn.mall.pojo.OrderItem;
import cn.dnaizn.mall.pojo.OrderItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.dnaizn.mall.service.OrderItemService;

import entity.PageResult;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemMapper orderItemMapper;

    /**
     * 查询全部
     */
    @Override
    public List<OrderItem> findAll() {
        return orderItemMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<OrderItem> page = (Page<OrderItem>) orderItemMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(OrderItem orderItem) {
        orderItemMapper.insert(orderItem);
    }


    /**
     * 修改
     */
    @Override
    public void update(OrderItem orderItem) {
        orderItemMapper.updateByPrimaryKey(orderItem);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public OrderItem findOne(Integer id) {
        return orderItemMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            orderItemMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public PageResult findPage(OrderItem orderItem, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        OrderItemExample example = new OrderItemExample();
        OrderItemExample.Criteria criteria = example.createCriteria();

        if (orderItem != null) {
            if (orderItem.getOrderId() != null && orderItem.getOrderId().length() > 0) {
                criteria.andOrderIdLike("%" + orderItem.getOrderId() + "%");
            }
            if (orderItem.getSellerId() != null && orderItem.getSellerId().length() > 0) {
                criteria.andSellerIdLike("%" + orderItem.getSellerId() + "%");
            }
            if (orderItem.getTitle() != null && orderItem.getTitle().length() > 0) {
                criteria.andTitleLike("%" + orderItem.getTitle() + "%");
            }
            if (orderItem.getPicPath() != null && orderItem.getPicPath().length() > 0) {
                criteria.andPicPathLike("%" + orderItem.getPicPath() + "%");
            }

        }

        Page<OrderItem> page = (Page<OrderItem>) orderItemMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

}
