package cn.dnaizn.mall.service;
import java.util.List;

import cn.dnaizn.mall.pojo.Address;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface AddressService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<Address> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(Address address);
	
	
	/**
	 * 修改
	 */
	void update(Address address);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Address findOne(Long id);
	
	
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
	PageResult findPage(Address address, int pageNum, int pageSize);
	
}
