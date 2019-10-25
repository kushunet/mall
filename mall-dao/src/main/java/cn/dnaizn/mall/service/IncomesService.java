package cn.dnaizn.mall.service;

import cn.dnaizn.mall.pojo.Incomes;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface IncomesService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<Incomes> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(Incomes incomes);
	
	
	/**
	 * 修改
	 */
	void update(Incomes incomes);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Incomes findOne(Integer id);
	
	
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
	PageResult findPage(Incomes incomes, int pageNum, int pageSize);
	
}
