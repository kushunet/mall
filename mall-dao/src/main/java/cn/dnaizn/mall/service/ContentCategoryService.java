package cn.dnaizn.mall.service;

import cn.dnaizn.mall.pojo.Content;
import entity.PageResult;
import cn.dnaizn.mall.pojo.ContentCategory;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ContentCategoryService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<ContentCategory> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(ContentCategory contentCategory);
	
	
	/**
	 * 修改
	 */
	void update(ContentCategory contentCategory);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	ContentCategory findOne(Long id);
	
	
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
	PageResult findPage(ContentCategory contentCategory, int pageNum, int pageSize);

}
