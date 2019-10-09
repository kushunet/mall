package cn.dnaizn.mall.goods.service.impl;

import cn.dnaizn.mall.DTO.GoodsDTO;
import cn.dnaizn.mall.VO.GoodsDescVO;
import cn.dnaizn.mall.VO.GoodsVO;
import cn.dnaizn.mall.exception.MallException;
import cn.dnaizn.mall.mapper.GoodsDescMapper;
import cn.dnaizn.mall.mapper.GoodsMapper;
import cn.dnaizn.mall.pojo.Goods;
import cn.dnaizn.mall.pojo.GoodsDesc;
import cn.dnaizn.mall.pojo.GoodsDescExample;
import cn.dnaizn.mall.pojo.GoodsExample;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import cn.dnaizn.mall.service.GoodsService;

import entity.PageResult;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsDescMapper goodsDescMapper;

    /**
     * 查询全部
     */
    @Override
    public List<Goods> findAll() {
        return goodsMapper.selectByExample(null);
    }

    @Override
    public List<GoodsVO> findAllList(String sellerId) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        List<Goods> goodsList = goodsMapper.selectByExample(example);
        List<GoodsVO> list = new ArrayList<>();
        for (Goods item : goodsList) {
            list.add(findOne(item.getId()));
        }
        return list;
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Goods> page = (Page<Goods>) goodsMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(GoodsDTO goodsDTO) {
        goodsDTO.getGoods().setCTime(System.currentTimeMillis() / 1000);
        goodsDTO.getGoods().setIsMarketable(0);
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andTopCategoryEqualTo(goodsDTO.getGoods().getTopCategory());
        criteria.andSecondCategoryEqualTo(goodsDTO.getGoods().getSecondCategory());
        goodsDTO.getGoods().setSortOrder(goodsMapper.countByExample(example) + 1);
        goodsDTO.getGoods().setIsDelete(0);
        goodsDTO.getGoods().setBrandId(0);
        goodsDTO.getGoods().setIsEnableSpec(goodsDTO.getGoodsDescList().size());
        goodsDTO.getGoods().setSmallPic(JSON.parseArray(goodsDTO.getGoods().getImages()).getString(0));
        goodsMapper.insert(goodsDTO.getGoods());
        for (GoodsDesc item : goodsDTO.getGoodsDescList()) {
            item.setGoodsId(goodsDTO.getGoods().getId());
            item.setcTime(Long.parseLong(String.valueOf(System.currentTimeMillis()).substring(0, 10)));
            item.setIntroduction(goodsDTO.getGoods().getTitle() + item.getTitle());
            goodsDescMapper.insert(item);
        }
    }

    @Override
    public List<GoodsVO> findList(Integer topCategory, Integer secondCategory, String sellerId) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andTopCategoryEqualTo(topCategory);
        criteria.andSecondCategoryEqualTo(secondCategory);
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andIsDeleteEqualTo(0);
        example.setOrderByClause("sort_order");
        List<Goods> goodsList = goodsMapper.selectByExample(example);
        List<GoodsVO> list = new ArrayList<>();
        for (Goods item : goodsList) {
            list.add(findOne(item.getId()));
        }
        return list;
    }

    /**
     * 修改
     */
    @Override
    public void update(GoodsDTO goodsDTO) {
        GoodsDescExample example = new GoodsDescExample();
        GoodsDescExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsIdEqualTo(goodsDTO.getGoods().getId());
        goodsMapper.updateByPrimaryKeySelective(goodsDTO.getGoods());
        goodsDescMapper.deleteByExample(example);
        for (GoodsDesc item:goodsDTO.getGoodsDescList()){
            item.setGoodsId(goodsDTO.getGoods().getId());
            item.setcTime(Long.parseLong(String.valueOf(System.currentTimeMillis()).substring(0, 10)));
            item.setIntroduction(goodsDTO.getGoods().getTitle() + item.getTitle());
            goodsDescMapper.insert(item);
        }
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public GoodsVO findOne(Integer id) {
        GoodsVO goodsVO = new GoodsVO();
        BeanUtils.copyProperties(goodsMapper.selectByPrimaryKey(id), goodsVO);
        List<GoodsDesc> goodsDescList;
        GoodsDescExample example = new GoodsDescExample();
        GoodsDescExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsIdEqualTo(goodsVO.getId());
        goodsDescList = goodsDescMapper.selectByExample(example);
        List<GoodsDescVO> list = new ArrayList<>();
        for (GoodsDesc item : goodsDescList) {
            GoodsDescVO goodsDescVO = new GoodsDescVO();
            BeanUtils.copyProperties(item, goodsDescVO);
            list.add(goodsDescVO);
        }
        goodsVO.setList(list);
        return goodsVO;
    }

    /**
     * 根据ID获取实体
     * @param sellerId
     * @return
     */
    @Override
    public List<GoodsVO> findRDelete(String sellerId) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeleteNotEqualTo(0);
        criteria.andSellerIdEqualTo(sellerId);
        List<Goods> goodsList = goodsMapper.selectByExample(example);
        List<GoodsVO> list = new ArrayList<>();
        for (Goods item : goodsList) {
            list.add(findOne(item.getId()));
        }
        return list;
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            Goods goods = goodsMapper.selectByPrimaryKey(id);
            goodsMapper.deleteByPrimaryKey(id);
            GoodsDescExample example = new GoodsDescExample();
            GoodsDescExample.Criteria criteria = example.createCriteria();
            criteria.andGoodsIdEqualTo(goods.getId());
            goodsDescMapper.deleteByExample(example);
        }
    }

    @Override
    public void rDelete(Integer[] ids) {
        for (Integer id : ids) {
            Goods goods = goodsMapper.selectByPrimaryKey(id);
            goods.setIsDelete(Integer.parseInt(String.valueOf(System.currentTimeMillis()).substring(0, 10)));
            goodsMapper.updateByPrimaryKey(goods);
        }
    }

    @Override
    public PageResult findPage(Goods goods, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();

        if (goods != null) {
            if (goods.getSellerId() != null && goods.getSellerId().length() > 0) {
                criteria.andSellerIdLike("%" + goods.getSellerId() + "%");
            }
            if (goods.getTitle() != null && goods.getTitle().length() > 0) {
                criteria.andTitleLike("%" + goods.getTitle() + "%");
            }
            if (goods.getDescription() != null && goods.getDescription().length() > 0) {
                criteria.andDescriptionLike("%" + goods.getDescription() + "%");
            }
            if (goods.getSmallPic() != null && goods.getSmallPic().length() > 0) {
                criteria.andSmallPicLike("%" + goods.getSmallPic() + "%");
            }
            if (goods.getImages() != null && goods.getImages().length() > 0) {
                criteria.andImagesLike("%" + goods.getImages() + "%");
            }

        }

        Page<Goods> page = (Page<Goods>) goodsMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void updateMarketable(Integer[] ids, Integer type, String sellerId) {
        for (Integer id : ids) {
            Goods goods = goodsMapper.selectByPrimaryKey(id);
            if (!goods.getSellerId().equals(sellerId)) {
                throw new MallException(1, "该商品不属于该用户");
            }
            if (type == 0) {
                goods.setIsMarketable(0);
            } else {
                goods.setIsMarketable(Integer.parseInt(String.valueOf(System.currentTimeMillis()).substring(0, 10)));
            }
            goodsMapper.updateByPrimaryKey(goods);
        }
    }


    @Override
    public void updateStock(Integer id, Integer stock, Integer maxStock, String sellerId) {
        GoodsDesc goodsDesc = goodsDescMapper.selectByPrimaryKey(id);
        Goods goods = goodsMapper.selectByPrimaryKey(goodsDesc.getGoodsId());
        if (!goods.getSellerId().equals(sellerId)) {
            throw new MallException(1, "该商品不属于该用户");
        }
        goodsDesc.setStock(stock);
        goodsDesc.setMaxStock(maxStock);
        goodsDescMapper.updateByPrimaryKey(goodsDesc);
    }

    @Override
    public void updatePrice(Integer id, BigDecimal price, BigDecimal packagefee, String sellerId) {
        GoodsDesc goodsDesc = goodsDescMapper.selectByPrimaryKey(id);
        Goods goods = goodsMapper.selectByPrimaryKey(goodsDesc.getGoodsId());
        if (!goods.getSellerId().equals(sellerId)) {
            throw new MallException(1, "该商品不属于该用户");
        }
        goodsDesc.setPrice(price);
        goodsDesc.setPackagefee(packagefee);
        goodsDescMapper.updateByPrimaryKey(goodsDesc);
    }

    @Override
    public void updateTitle(Integer id, String title, String sellerId) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        if (!goods.getSellerId().equals(sellerId)) {
            throw new MallException(1, "该商品不属于该用户");
        }
        GoodsDescExample example = new GoodsDescExample();
        GoodsDescExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsIdEqualTo(goods.getId());
        List<GoodsDesc> goodsDescList = goodsDescMapper.selectByExample(example);
        goods.setTitle(title);
        goodsMapper.updateByPrimaryKey(goods);
        for (GoodsDesc item:goodsDescList){
            item.setIntroduction(goods.getTitle()+item.getTitle());
            goodsDescMapper.updateByPrimaryKey(item);
        }
    }

    @Override
    public void upSortOrder(Integer[] ids) {
        int i = 1;
        for (Integer id : ids) {
            Goods goods = goodsMapper.selectByPrimaryKey(id);
            goods.setSortOrder(i++);
            goodsMapper.updateByPrimaryKey(goods);
        }
    }

    @Override
    public void updateFilly(Integer[] ids, String sellerId) {
        for (Integer id : ids) {
            GoodsDesc goodsDesc = goodsDescMapper.selectByPrimaryKey(id);
            Goods goods = goodsMapper.selectByPrimaryKey(goodsDesc.getGoodsId());
            if (!goods.getSellerId().equals(sellerId)) {
                throw new MallException(1, "该规格不属于该用户");
            }
            goodsDesc.setStock(goodsDesc.getMaxStock());
            goodsDescMapper.updateByPrimaryKey(goodsDesc);
        }
    }

    @Override
    public void updateEmpty(Integer[] ids, String sellerId) {
        for (Integer id : ids) {
            GoodsDesc goodsDesc = goodsDescMapper.selectByPrimaryKey(id);
            Goods goods = goodsMapper.selectByPrimaryKey(goodsDesc.getGoodsId());
            if (!goods.getSellerId().equals(sellerId)) {
                throw new MallException(1, "该规格不属于该用户");
            }
            goodsDesc.setStock(0);
            goodsDescMapper.updateByPrimaryKey(goodsDesc);
        }
    }

    @Override
    public void updateCategory(Integer[] ids, Integer topCategory, Integer secondCategory,String sellerId) {
        for (Integer id : ids){
            Goods goods = goodsMapper.selectByPrimaryKey(id);
            if (!goods.getSellerId().equals(sellerId)) {
                throw new MallException(1, "该商品不属于该用户");
            }
            goods.setIsDelete(0);
            goods.setTopCategory(topCategory);
            goods.setSecondCategory(secondCategory);
            goodsMapper.updateByPrimaryKey(goods);
        }
    }
}
