package cn.dnaizn.mall.service;


import cn.dnaizn.mall.pojo.Admin;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface AdminService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<Admin> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	PageResult findPage(int pageNum, int pageSize);
	
	
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
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void delete(String[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	PageResult findPage(Admin admin, int pageNum, int pageSize);
	
}
