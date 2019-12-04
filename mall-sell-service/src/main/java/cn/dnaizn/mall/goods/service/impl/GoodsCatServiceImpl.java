package cn.dnaizn.mall.goods.service.impl;

import cn.dnaizn.mall.VO.GoodsCatListVO;
import cn.dnaizn.mall.VO.GoodsCatVO;
import cn.dnaizn.mall.mapper.GoodsCatMapper;
import cn.dnaizn.mall.mapper.GoodsDescMapper;
import cn.dnaizn.mall.mapper.GoodsMapper;
import cn.dnaizn.mall.pojo.*;
import cn.dnaizn.mall.service.GoodsCatService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsCatServiceImpl implements GoodsCatService {

    @Autowired
    GoodsCatMapper goodsCatMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsDescMapper goodsDescMapper;

    /**
     * 查询全部
     */
    @Override
    public List<GoodsCatListVO> findAll(String sellerId) {
        List<GoodsCatListVO> goodsCatListVOList = new ArrayList<>();
        GoodsCatExample example = new GoodsCatExample();
        GoodsCatExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andParentIdEqualTo(0);
        example.setOrderByClause("sort_order");
        List<GoodsCat> goodsCatList = goodsCatMapper.selectByExample(example);
        for (GoodsCat item : goodsCatList) {
            GoodsCatListVO goodsCatListVO = new GoodsCatListVO();
            GoodsCatExample example1 = new GoodsCatExample();
            GoodsCatExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andParentIdEqualTo(item.getId());
            BeanUtils.copyProperties(item, goodsCatListVO);
            example.setOrderByClause("sort_order");
            goodsCatListVO.setGoodsCatVOList(goodsCatMapper.selectByExample(example1));
//            goodsCatListVO.setGoodsCatVOList(findByParentId(item.getId()));
            goodsCatListVOList.add(goodsCatListVO);
        }
        return goodsCatListVOList;
    }

    @Override
    public List<GoodsCatVO> findBySellerIdNumber(String sellerId, Integer type) {
        List<GoodsCatVO> goodsCatVOList = new ArrayList<>();
        GoodsCatExample example = new GoodsCatExample();
        GoodsCatExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andParentIdEqualTo(0);
        example.setOrderByClause("sort_order");
        List<GoodsCat> goodsCatList = goodsCatMapper.selectByExample(example);
        for (GoodsCat item : goodsCatList) {
            GoodsCatVO goodsCatVO = new GoodsCatListVO();
            BeanUtils.copyProperties(item, goodsCatVO);
            if (type == 0) {//根据一级分类查询商品数量
                goodsCatVO.setNumber(number(item.getId(), 0));
            } else if (type == 1) {//根据一级分类查询上架商品数量
                goodsCatVO.setNumber(number(item.getId(), 1));
            } else if (type == 2) {//根据一级分类查询下架商品数量
                goodsCatVO.setNumber(number(item.getId(), 2));
            } else if (type == 3) {//根据一级分类查询即将售空商品数量
                GoodsExample example1 = new GoodsExample();
                GoodsExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andTopCategoryEqualTo(item.getId());
                criteria1.andIsDeleteEqualTo(0);
                List<Goods> goodsList = goodsMapper.selectByExample(example1);
                goodsCatVO.setNumber(number(goodsList, 0));
            } else if (type == 4) {//根据一级分类查询售空商品数量
                GoodsExample example1 = new GoodsExample();
                GoodsExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andTopCategoryEqualTo(item.getId());
                criteria1.andIsDeleteEqualTo(0);
                List<Goods> goodsList = goodsMapper.selectByExample(example1);
                goodsCatVO.setNumber(number(goodsList, 1));
            }
            goodsCatVOList.add(goodsCatVO);
        }
        Integer count = unclassified(0, sellerId, type);
        if (count > 0) {
            GoodsCatVO goodsCatVO = new GoodsCatVO();
            goodsCatVO.setName("未分类");
            goodsCatVO.setParentId(0);
            goodsCatVO.setNumber(count);
            goodsCatVOList.add(goodsCatVO);
        }
        return goodsCatVOList;
    }

    private Integer unclassified(Integer parentId, String sellerId, Integer type) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        if (parentId != 0) {
            criteria.andTopCategoryEqualTo(parentId);
            criteria.andSecondCategoryEqualTo(0);
        }else {
            criteria.andTopCategoryEqualTo(0);
        }
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andIsDeleteEqualTo(0);
        if (type == 1) {
            criteria.andIsMarketableEqualTo(0);
            return goodsMapper.countByExample(example);
        } else if (type == 2) {
            criteria.andIsMarketableNotEqualTo(0);
            return goodsMapper.countByExample(example);
        } else if (type == 3) {
            return number(goodsMapper.selectByExample(example), 0);
        } else if (type == 4) {
            return number(goodsMapper.selectByExample(example), 1);
        }
        return goodsMapper.countByExample(example);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<GoodsCat> page = (Page<GoodsCat>) goodsCatMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(GoodsCat goodsCat) {
        GoodsCatExample example = new GoodsCatExample();
        GoodsCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(goodsCat.getParentId());
        criteria.andSellerIdEqualTo(goodsCat.getSellerId());
        goodsCat.setSortOrder((goodsCatMapper.countByExample(example) + 1));
        goodsCatMapper.insert(goodsCat);
    }


    /**
     * 修改
     */
    @Override
    public void update(GoodsCat goodsCat) {
        goodsCatMapper.updateByPrimaryKeySelective(goodsCat);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public GoodsCat findOne(Integer id) {
        return goodsCatMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            GoodsCat goodsCat = goodsCatMapper.selectByPrimaryKey(id);
            GoodsExample example = new GoodsExample();
            GoodsExample.Criteria criteria = example.createCriteria();
            if (goodsCat.getParentId().equals(0)) {
                criteria.andTopCategoryEqualTo(id);
                List<Goods> goodsList = goodsMapper.selectByExample(example);
                for (Goods item : goodsList) {
                    item.setTopCategory(0);
                    item.setSecondCategory(0);
                    goodsMapper.updateByPrimaryKey(item);
                }
            } else {
                criteria.andSecondCategoryEqualTo(id);
                List<Goods> goodsList = goodsMapper.selectByExample(example);
                for (Goods item : goodsList) {
                    item.setSecondCategory(0);
                    goodsMapper.updateByPrimaryKey(item);
                }
            }
            goodsCatMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public PageResult findPage(GoodsCat goodsCat, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        GoodsCatExample example = new GoodsCatExample();
        GoodsCatExample.Criteria criteria = example.createCriteria();

        if (goodsCat != null) {
            if (goodsCat.getName() != null && goodsCat.getName().length() > 0) {
                criteria.andNameLike("%" + goodsCat.getName() + "%");
            }
            if (goodsCat.getSellerId() != null && goodsCat.getSellerId().length() > 0) {
                criteria.andSellerIdLike("%" + goodsCat.getSellerId() + "%");
            }

        }

        Page<GoodsCat> page = (Page<GoodsCat>) goodsCatMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<GoodsCatVO> findByParentIdNumber(Integer parentId, String sellerId, Integer type) {
        List<GoodsCatVO> goodsCatVOList = new ArrayList<>();
        GoodsCatExample example = new GoodsCatExample();
        GoodsCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        criteria.andSellerIdEqualTo(sellerId);
        example.setOrderByClause("sort_order");
        List<GoodsCat> goodsCatList = goodsCatMapper.selectByExample(example);
        for (GoodsCat item : goodsCatList) {
            GoodsCatVO goodsCatVO = new GoodsCatVO();
            BeanUtils.copyProperties(item, goodsCatVO);
            if (type == 0) {
                goodsCatVO.setNumber(number(item.getId(), 3));
            } else if (type == 1) {
                goodsCatVO.setNumber(number(item.getId(), 4));
            } else if (type == 2) {
                goodsCatVO.setNumber(number(item.getId(), 5));
            } else if (type == 3) {
                GoodsExample example1 = new GoodsExample();
                GoodsExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andSecondCategoryEqualTo(item.getId());
                criteria1.andIsDeleteEqualTo(0);
                List<Goods> goodsList = goodsMapper.selectByExample(example1);
                goodsCatVO.setNumber(number(goodsList, 0));
            } else if (type == 4) {
                GoodsExample example1 = new GoodsExample();
                GoodsExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andSecondCategoryEqualTo(item.getId());
                criteria1.andIsDeleteEqualTo(0);
                List<Goods> goodsList = goodsMapper.selectByExample(example1);
                goodsCatVO.setNumber(number(goodsList, 1));
            }

            goodsCatVOList.add(goodsCatVO);
        }
        Integer count = unclassified(parentId, sellerId, type);
        if (count > 0) {
            GoodsCatVO goodsCatVO = new GoodsCatVO();
            goodsCatVO.setName("默认");
            goodsCatVO.setParentId(parentId);
            goodsCatVO.setNumber(count);
            goodsCatVOList.add(goodsCatVO);
        }

        return goodsCatVOList;
    }

    @Override
    public void upSortOrder(Integer[] ids) {
        int i = 1;
        for (Integer id : ids) {
            GoodsCat goodsCat = goodsCatMapper.selectByPrimaryKey(id);
            goodsCat.setSortOrder(i++);
            goodsCatMapper.updateByPrimaryKey(goodsCat);
        }
    }

    /**
     * @param id
     * @param type
     * @return
     */
    @Override
    public Integer number(Integer id, Integer type) {
        Integer count = 0;
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeleteEqualTo(0);
        if (type == 0) {//根据一级分类查询商品数量
            criteria.andTopCategoryEqualTo(id);
            count = goodsMapper.countByExample(example);
        } else if (type == 1) {//根据一级分类查询上架商品数量
            criteria.andTopCategoryEqualTo(id);
            criteria.andIsMarketableEqualTo(0);
            count = goodsMapper.countByExample(example);
        } else if (type == 2) {//根据一级分类查询下架商品数量
            criteria.andTopCategoryEqualTo(id);
            criteria.andIsMarketableNotEqualTo(0);
            count = goodsMapper.countByExample(example);
        } else if (type == 3) {//根据二级分类查询商品数量
            criteria.andSecondCategoryEqualTo(id);
            count = goodsMapper.countByExample(example);
        } else if (type == 4) {//根据二级分类查询上架商品数量
            criteria.andSecondCategoryEqualTo(id);
            criteria.andIsMarketableEqualTo(0);
            count = goodsMapper.countByExample(example);
        } else if (type == 5) {//根据二级分类查询下架商品数量
            criteria.andSecondCategoryEqualTo(id);
            criteria.andIsMarketableNotEqualTo(0);
            count = goodsMapper.countByExample(example);
        }
        return count;
    }

    @Override
    public Integer number(String sellerId, Integer type) {
        Integer count = 0;
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andIsDeleteEqualTo(0);
        if (type == 0) {//根据商家id查询商品数量
            count = goodsMapper.countByExample(example);
        } else if (type == 1) {//根据商家id查询上架商品数量
            criteria.andIsMarketableEqualTo(0);
            count = goodsMapper.countByExample(example);
        } else if (type == 2) {//根据商家id查询下架商品数量
            criteria.andIsMarketableNotEqualTo(0);
            count = goodsMapper.countByExample(example);
        } else if (type == 3) {//根据商家id查询小于10的数量
            count = number(goodsMapper.selectByExample(example), 0);
        } else if (type == 4) {//根据商家id查询商品为0的数量
            count = number(goodsMapper.selectByExample(example), 1);
        }
        return count;
    }

    @Override
    public Integer number(List<Goods> list, Integer type) {
        Integer count = 0;
        if (type == 0) {//根据商品查询商品小于10的数量
            for (Goods item : list) {
                GoodsDescExample example = new GoodsDescExample();
                GoodsDescExample.Criteria criteria = example.createCriteria();
                criteria.andGoodsIdEqualTo(item.getId());
                criteria.andStockLessThanOrEqualTo(10);
                if (goodsDescMapper.countByExample(example) > 0) {
                    count++;
                }
            }
        } else if (type == 1) {//根据商品查询商品为0的数量
            for (Goods item : list) {
                GoodsDescExample example = new GoodsDescExample();
                GoodsDescExample.Criteria criteria = example.createCriteria();
                criteria.andGoodsIdEqualTo(item.getId());
                criteria.andStockEqualTo(0);
                if (goodsDescMapper.countByExample(example) > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
