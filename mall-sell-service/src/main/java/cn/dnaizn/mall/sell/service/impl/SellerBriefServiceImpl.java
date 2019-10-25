package cn.dnaizn.mall.sell.service.impl;
import java.util.List;

import cn.dnaizn.mall.mapper.SellerBriefMapper;
import cn.dnaizn.mall.pojo.SellerBrief;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import cn.dnaizn.mall.service.SellerBriefService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SellerBriefServiceImpl implements SellerBriefService {

	@Autowired
	SellerBriefMapper sellerBriefMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<SellerBrief> findAll() {
		return sellerBriefMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<SellerBrief> page=   (Page<SellerBrief>) sellerBriefMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(SellerBrief sellerBrief) {
		sellerBriefMapper.insert(sellerBrief);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(SellerBrief sellerBrief){
		sellerBriefMapper.updateByPrimaryKey(sellerBrief);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public SellerBrief findOne(String id){
		return sellerBriefMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(String[] ids) {
		for(String id:ids){
			sellerBriefMapper.deleteByPrimaryKey(id);
		}		
	}
	
}
