package cn.dnaizn.mall.service;
import java.util.List;

import cn.dnaizn.mall.pojo.TransfersList;
import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface TransfersListService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<TransfersList> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(TransfersList transfersList);
	
	
	/**
	 * 修改
	 */
	void update(TransfersList transfersList);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	TransfersList findOne(Integer id);
	
	
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
	PageResult findPage(TransfersList transfersList, int pageNum, int pageSize);
	
}
