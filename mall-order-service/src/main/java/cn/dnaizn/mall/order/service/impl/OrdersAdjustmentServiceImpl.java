package cn.dnaizn.mall.order.service.impl;

import java.util.List;

import cn.dnaizn.mall.mapper.OrdersAdjustmentMapper;
import cn.dnaizn.mall.pojo.OrdersAdjustment;
import cn.dnaizn.mall.pojo.OrdersAdjustmentExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.dnaizn.mall.service.OrdersAdjustmentService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class OrdersAdjustmentServiceImpl implements OrdersAdjustmentService {

	@Autowired
	OrdersAdjustmentMapper ordersAdjustmentMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<OrdersAdjustment> findAll() {
		return ordersAdjustmentMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<OrdersAdjustment> page=   (Page<OrdersAdjustment>) ordersAdjustmentMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(OrdersAdjustment ordersAdjustment) {
		ordersAdjustmentMapper.insert(ordersAdjustment);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(OrdersAdjustment ordersAdjustment){
		ordersAdjustmentMapper.updateByPrimaryKey(ordersAdjustment);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public OrdersAdjustment findOne(Integer id){
		return ordersAdjustmentMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			ordersAdjustmentMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(OrdersAdjustment ordersAdjustment, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		OrdersAdjustmentExample example=new OrdersAdjustmentExample();
		OrdersAdjustmentExample.Criteria criteria = example.createCriteria();
		
		if(ordersAdjustment!=null){			
						if(ordersAdjustment.getOrderId()!=null && ordersAdjustment.getOrderId().length()>0){
				criteria.andOrderIdLike("%"+ordersAdjustment.getOrderId()+"%");
			}
			if(ordersAdjustment.getTitle()!=null && ordersAdjustment.getTitle().length()>0){
				criteria.andTitleLike("%"+ordersAdjustment.getTitle()+"%");
			}
			if(ordersAdjustment.getDiscountId()!=null && ordersAdjustment.getDiscountId().length()>0){
				criteria.andDiscountIdLike("%"+ordersAdjustment.getDiscountId()+"%");
			}
	
		}
		
		Page<OrdersAdjustment> page= (Page<OrdersAdjustment>)ordersAdjustmentMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
