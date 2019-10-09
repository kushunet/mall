package cn.dnaizn.mall.service;

import cn.dnaizn.mall.DTO.GoodsDTO;
import cn.dnaizn.mall.VO.GoodsVO;
import cn.dnaizn.mall.pojo.Goods;
import entity.PageResult;

import java.math.BigDecimal;
import java.util.List;

/**
 * 服务层接口
 *
 * @author Administrator
 */
public interface GoodsService {

    /**
     * 返回全部列表
     *
     * @return
     */
    List<Goods> findAll();


    /**
     * 返回分页列表
     *
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);


    /**
     * 增加
     */
    void add(GoodsDTO goodsDTO);


    /**
     * 修改
     */
    void update(GoodsDTO goodsDTO);


    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    GoodsVO findOne(Integer id);


    /**
     * 批量删除
     *
     * @param ids
     */
    void delete(Integer[] ids);

    /**
     * 分页
     *
     * @param pageNum  当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    PageResult findPage(Goods goods, int pageNum, int pageSize);

    /**
     * 查询全部商品列表
     * @return
     */
    List<GoodsVO> findAllList(String sellerId);

    /**
     * 根据id查询列表
     * @param topCategory
     * @param secondCategory
     * @return
     */
    List<GoodsVO> findList(Integer topCategory,Integer secondCategory,String sellerId);

    /**
     * 查询删除列表
     * @param sellerId
     * @return
     */
    List<GoodsVO> findRDelete(String sellerId);
    /**
     * 修改上下架
     * @param ids
     * @param type
     */
    void updateMarketable(Integer[] ids,Integer type,String sellerId);

    /**
     * 软删除
     * @param ids
     */
    void rDelete(Integer[] ids);



    /**
     * 修改库存
     * @param id
     * @param stock
     * @param sellerId
     */
    void updateStock(Integer id, Integer stock, Integer maxStock, String sellerId);

    /**
     * 修改价格
     * @param id
     * @param price
     * @param packagefee
     * @param sellerId
     */
    void updatePrice(Integer id, BigDecimal price, BigDecimal packagefee, String sellerId);

    /**
     * 修改标题
     * @param id
     * @param title
     * @param sellerId
     */
    void updateTitle(Integer id, String title, String sellerId);
    /**
     * 修改顺序
     * @param ids
     */
    void upSortOrder(Integer[] ids);

    /**
     * 置满
     * @param ids
     */
    void updateFilly(Integer[] ids,String sellerId);

    /**
     * 清空
     * @param ids
     * @param sellerId
     */
    void updateEmpty(Integer[] ids,String sellerId);
    /**
     * 修改分类
     * @param ids
     */
    void updateCategory(Integer[] ids,Integer topCategory,Integer secondCategory,String sellerId);
}
