package cn.dnaizn.mall.service;


import cn.dnaizn.mall.pojo.User;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<User> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(User user);
	
	
	/**
	 * 修改
	 */
	void update(User user);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	User findOne(Long id);
	
	
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
	PageResult findPage(User user, int pageNum, int pageSize);
	
}
