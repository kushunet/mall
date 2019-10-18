package cn.dnaizn.mall.service;
import java.util.List;

import cn.dnaizn.mall.pojo.SellerExamine;
import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SellerExamineService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<SellerExamine> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(SellerExamine sellerExamine);
	
	
	/**
	 * 修改
	 */
	void update(SellerExamine sellerExamine);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	SellerExamine findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void delete(Integer[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	PageResult findPage(SellerExamine sellerExamine, int pageNum, int pageSize);
	
}
