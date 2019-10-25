package cn.dnaizn.mall.service;
import java.util.List;

import cn.dnaizn.mall.pojo.Discount;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface DiscountService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<Discount> findAll(String sellerId);
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(Discount discount);
	
	
	/**
	 * 修改
	 */
	void update(Discount discount);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Discount findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void delete(Integer[] ids);

	/**
	 * 批量软删除
	 * @param ids
	 */
	void rDelete(Integer[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	PageResult findPage(Discount discount, int pageNum, int pageSize);
	
}
