package cn.dnaizn.mall.service;

import entity.PageResult;
import cn.dnaizn.mall.pojo.SellerCat;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SellerCatService {

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
	
	
	/**
	 * 增加
	*/
	void add(SellerCat sellerCat);
	
	
	/**
	 * 修改
	 */
	void update(SellerCat sellerCat);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	SellerCat findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	PageResult findPage(SellerCat sellerCat, int pageNum, int pageSize);

	/**
	 *
	 * @param parentId
	 * @return
	 */
	List<SellerCat> findByParentId(Long parentId);
}
