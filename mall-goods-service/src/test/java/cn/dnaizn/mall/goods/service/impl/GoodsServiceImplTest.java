package cn.dnaizn.mall.goods.service.impl;

import cn.dnaizn.mall.VO.GoodsDescVO;
import cn.dnaizn.mall.VO.GoodsVO;
import cn.dnaizn.mall.mapper.GoodsDescMapper;
import cn.dnaizn.mall.mapper.GoodsMapper;
import cn.dnaizn.mall.pojo.GoodsDesc;
import cn.dnaizn.mall.pojo.GoodsDescExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceImplTest {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsDescMapper goodsDescMapper;
    @Test
    public void findAllList() {
        goodsMapper.selectByExample(null);
    }

    @Test
    public void findOne() {
        GoodsVO goodsVO = new GoodsVO();
        BeanUtils.copyProperties(goodsMapper.selectByPrimaryKey(1),goodsVO);
        List<GoodsDesc> goodsDescList;
        GoodsDescExample example = new GoodsDescExample();
        GoodsDescExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsIdEqualTo(goodsVO.getId());
        goodsDescList = goodsDescMapper.selectByExample(example);
        List<GoodsDescVO> list = new ArrayList<>();
        for (GoodsDesc item : goodsDescList){
            GoodsDescVO goodsDescVO = new GoodsDescVO();
            BeanUtils.copyProperties(item,goodsDescVO);
            list.add(goodsDescVO);
        }
        goodsVO.setList(list);
    }
}