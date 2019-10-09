package cn.dnaizn.mall.service;

import entity.PageResult;
import cn.dnaizn.mall.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {
    List<Brand> findAll();

    /**
     * 品牌分页
     * @param pageNum 当前页码
     * @param pageSize  每页记录数
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 增加
     * @param brand
     */
    void add(Brand brand);

    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    Brand findOne(Long id);

    /**
     * 修改数据
     * @param brand
     */
    void update(Brand brand);

    /**
     * 数据删除
     * @param ids
     */
    void delete(Long[] ids);
    /**
     * 品牌分页
     * @param pageNum 当前页码
     * @param pageSize  每页记录数
     * @return
     */
    PageResult findPage(Brand brand, int pageNum, int pageSize);

    /**
     * 返回下拉列表数据
     * @return
     */
    List<Map> selectOptionList();
}
