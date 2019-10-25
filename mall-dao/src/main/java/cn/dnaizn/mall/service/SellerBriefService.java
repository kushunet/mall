package cn.dnaizn.mall.service;


import cn.dnaizn.mall.pojo.SellerBrief;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SellerBriefService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<SellerBrief> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(SellerBrief sellerBrief);
	
	
	/**
	 * 修改
	 */
	void update(SellerBrief sellerBrief);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	SellerBrief findOne(String id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void delete(String[] ids);

//	/**
//	 * 分页
//	 * @param pageNum 当前页 码
//	 * @param pageSize 每页记录数
//	 * @return
//	 */
//	PageResult findPage(SellerBrief sellerBrief, int pageNum, int pageSize);
	
}
