package cn.dnaizn.mall.activity.service.impl;

import cn.dnaizn.mall.exception.MallException;
import cn.dnaizn.mall.mapper.FullReductionMapper;
import cn.dnaizn.mall.pojo.FullReduction;
import cn.dnaizn.mall.pojo.FullReductionExample;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import cn.dnaizn.mall.service.FullReductionService;

import entity.PageResult;

import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class FullReductionServiceImpl implements FullReductionService {

	@Autowired
	private FullReductionMapper fullReductionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<FullReduction> findAll(String seller) {
		FullReductionExample example = new FullReductionExample();
		FullReductionExample.Criteria criteria = example.createCriteria();
		criteria.andSellerIdEqualTo(seller);
		return fullReductionMapper.selectByExample(example);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<FullReduction> page=   (Page<FullReduction>) fullReductionMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(FullReduction fullReduction) {
		FullReductionExample example = new FullReductionExample();
		FullReductionExample.Criteria criteria = example.createCriteria();
		criteria.andSellerIdEqualTo(fullReduction.getSellerId());
		if (fullReductionMapper.countByExample(example)>0){
			throw new MallException(1,"该商家已经存在满减！！");
		}
		fullReductionMapper.insert(fullReduction);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(FullReduction fullReduction){
		fullReductionMapper.updateByPrimaryKey(fullReduction);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public FullReduction findOne(Integer id){
		return fullReductionMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			fullReductionMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(FullReduction fullReduction, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		FullReductionExample example=new FullReductionExample();
		FullReductionExample.Criteria criteria = example.createCriteria();
		
		if(fullReduction!=null){			
						if(fullReduction.getSellerId()!=null && fullReduction.getSellerId().length()>0){
				criteria.andSellerIdLike("%"+fullReduction.getSellerId()+"%");
			}
	
		}
		
		Page<FullReduction> page= (Page<FullReduction>)fullReductionMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
