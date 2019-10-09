package cn.dnaizn.mall.goods.service.impl;


import cn.dnaizn.mall.mapper.GoodsDescMapper;
import cn.dnaizn.mall.pojo.GoodsDesc;
import cn.dnaizn.mall.pojo.GoodsDescExample;
import cn.dnaizn.mall.service.GoodsDescService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
public class GoodsDescServiceImpl implements GoodsDescService {

    @Autowired
    GoodsDescMapper goodsDescMapper;

    /**
     * 查询全部
     */
    @Override
    public List<GoodsDesc> findAll() {
        return goodsDescMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<GoodsDesc> page = (Page<GoodsDesc>) goodsDescMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(GoodsDesc goodsDesc) {
        goodsDescMapper.insert(goodsDesc);
    }


    /**
     * 修改
     */
    @Override
    public void update(GoodsDesc goodsDesc) {
        goodsDescMapper.updateByPrimaryKey(goodsDesc);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public GoodsDesc findOne(Integer id) {
        return goodsDescMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            goodsDescMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public PageResult findPage(GoodsDesc goodsDesc, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        GoodsDescExample example = new GoodsDescExample();
        GoodsDescExample.Criteria criteria = example.createCriteria();

        if (goodsDesc != null) {
            if (goodsDesc.getTitle() != null && goodsDesc.getTitle().length() > 0) {
                criteria.andTitleLike("%" + goodsDesc.getTitle() + "%");
            }
            if (goodsDesc.getIntroduction() != null && goodsDesc.getIntroduction().length() > 0) {
                criteria.andIntroductionLike("%" + goodsDesc.getIntroduction() + "%");
            }

        }

        Page<GoodsDesc> page = (Page<GoodsDesc>) goodsDescMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

}
