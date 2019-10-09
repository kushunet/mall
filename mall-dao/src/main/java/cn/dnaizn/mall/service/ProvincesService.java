package cn.dnaizn.mall.service;

import cn.dnaizn.mall.pojo.Provinces;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ProvincesService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<Provinces> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(Provinces provinces);
	
	
	/**
	 * 修改
	 */
	void update(Provinces provinces);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Provinces findOne(Integer id);
	
	
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
	PageResult findPage(Provinces provinces, int pageNum, int pageSize);
	
}
