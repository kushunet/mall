package cn.dnaizn.mall.service;

import cn.dnaizn.mall.VO.GoodsCatListVO;
import cn.dnaizn.mall.VO.GoodsCatVO;
import cn.dnaizn.mall.pojo.Goods;
import cn.dnaizn.mall.pojo.GoodsCat;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface GoodsCatService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<GoodsCatListVO> findAll(String sellerId);
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(GoodsCat goodsCat);
	
	
	/**
	 * 修改
	 */
	void update(GoodsCat goodsCat);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	GoodsCat findOne(Integer id);
	
	
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
	PageResult findPage(GoodsCat goodsCat, int pageNum, int pageSize);
	/**
	 * 根据上级id查询下级id
	 * @param sellerId
	 * @return
	 */
	List<GoodsCatVO> findBySellerIdNumber(String sellerId,Integer type);

	/**
	 * 根据上级id查询下级id
	 * @param parentId
	 * @return
	 */
	List<GoodsCatVO> findByParentIdNumber(Integer parentId,String sellerId,Integer type);

	/**
	 * 排序
	 * @param ids
	 */
	void upSortOrder(Integer[] ids);

	/**
	 * 根据类型查询商品数量
	 * @param id
	 * @param type
	 * @return
	 */
	Integer number(Integer id,Integer type);

	/**
	 * 根据用户查询商品数量
	 * @param sellerId
	 * @param type
	 * @return
	 */
	Integer number(String sellerId,Integer type);
	/**
	 *根据商品列表查询商品数量
	 */
	Integer number(List<Goods> list, Integer type);
}
