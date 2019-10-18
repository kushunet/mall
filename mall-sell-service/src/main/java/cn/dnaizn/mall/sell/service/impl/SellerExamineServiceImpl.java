package cn.dnaizn.mall.sell.service.impl;

import cn.dnaizn.mall.mapper.SellerExamineMapper;
import cn.dnaizn.mall.pojo.SellerExamine;
import cn.dnaizn.mall.pojo.SellerExamineExample;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import cn.dnaizn.mall.service.SellerExamineService;

import entity.PageResult;

import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SellerExamineServiceImpl implements SellerExamineService {

	@Autowired
	SellerExamineMapper sellerExamineMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<SellerExamine> findAll() {
		return sellerExamineMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<SellerExamine> page=   (Page<SellerExamine>) sellerExamineMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(SellerExamine sellerExamine) {
		sellerExamineMapper.insert(sellerExamine);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(SellerExamine sellerExamine){
		sellerExamineMapper.updateByPrimaryKey(sellerExamine);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public SellerExamine findOne(Integer id){
		return sellerExamineMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			sellerExamineMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(SellerExamine sellerExamine, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		SellerExamineExample example=new SellerExamineExample();
		SellerExamineExample.Criteria criteria = example.createCriteria();
		
		if(sellerExamine!=null){			
						if(sellerExamine.getSellerId()!=null && sellerExamine.getSellerId().length()>0){
				criteria.andSellerIdLike("%"+sellerExamine.getSellerId()+"%");
			}
			if(sellerExamine.getData()!=null && sellerExamine.getData().length()>0){
				criteria.andDataLike("%"+sellerExamine.getData()+"%");
			}
			if(sellerExamine.getAdminId()!=null && sellerExamine.getAdminId().length()>0){
				criteria.andAdminIdLike("%"+sellerExamine.getAdminId()+"%");
			}
	
		}
		
		Page<SellerExamine> page= (Page<SellerExamine>)sellerExamineMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
