package cn.dnaizn.mall.service;


import cn.dnaizn.mall.pojo.Admin;
import cn.dnaizn.mall.pojo.SellerCat;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface AdminService {

	
	
	/**
	 * 增加
	*/
	void add(Admin admin);
	
	
	/**
	 * 修改
	 */
	void update(Admin admin);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Admin findOne(String id);

	List<SellerCat> findByParentId(Long parentId);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	PageResult findPage(SellerCat sellerCat, int pageNum, int pageSize);
	/**
	 * 批量删除
	 * @param ids
	 */
	void delete(Long[] ids);
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	SellerCat findOne(Long id);
	/**
	 * 修改
	 */
	void update(SellerCat sellerCat);

	void add(SellerCat sellerCat);

	/**
	 * 返回全部列表
	 * @return
	 */
	List<SellerCat> findAll();


	/**
	 * 返回分页列表
	 * @return
	 */
	PageResult findPage(int pageNum, int pageSize);
}
