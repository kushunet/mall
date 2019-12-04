package cn.dnaizn.mall.manager.service.impl;


import cn.dnaizn.mall.mapper.*;
import cn.dnaizn.mall.mq.ActiveMQUtil;
import cn.dnaizn.mall.pojo.SellerCat;
import cn.dnaizn.mall.pojo.SellerCatExample;
import cn.dnaizn.mall.service.AdminService;
import cn.dnaizn.mall.util.RedisUtil;
import com.alibaba.dubbo.config.annotation.Service;
import entity.PageResult;
import cn.dnaizn.mall.pojo.Admin;
import cn.dnaizn.mall.pojo.AdminExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    SellerMapper sellerMapper;

    @Autowired
    SellerBriefMapper sellerBriefMapper;

    @Autowired
    SellerCatMapper sellerCatMapper;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    ActiveMQUtil activeMQUtil;

    @Autowired
    SellerExamineMapper sellerExamineMapper;


    /**
     * 增加
     */
    @Override
    public void add(Admin admin) {
        adminMapper.insert(admin);
    }


    /**
     * 修改
     */
    @Override
    public void update(Admin admin) {
        adminMapper.updateByPrimaryKey(admin);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public Admin findOne(String id) {
        return adminMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<SellerCat> findByParentId(Long parentId) {
        SellerCatExample example=new SellerCatExample();
        SellerCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        example.setOrderByClause("sort_order");
        return sellerCatMapper.selectByExample(example);
    }

    @Override
    public PageResult findPage(SellerCat sellerCat, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        SellerCatExample example = new SellerCatExample();
        SellerCatExample.Criteria criteria = example.createCriteria();

        if (sellerCat != null) {
            if (sellerCat.getName() != null && sellerCat.getName().length() > 0) {
                criteria.andNameLike("%" + sellerCat.getName() + "%");
            }
            if (sellerCat.getPic() != null && sellerCat.getPic().length() > 0) {
                criteria.andPicLike("%" + sellerCat.getPic() + "%");
            }

        }

        Page<SellerCat> page = (Page<SellerCat>) sellerCatMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            List<SellerCat> sellerCatList = findByParentId(id);
            for(SellerCat item:sellerCatList){
                List<SellerCat> sellerCats = findByParentId(item.getId());
                for (SellerCat i:sellerCats){
                    sellerCatMapper.deleteByPrimaryKey(i.getId());
                }
                sellerCatMapper.deleteByPrimaryKey(item.getId());
            }
            sellerCatMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public SellerCat findOne(Long id) {
        return sellerCatMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(SellerCat sellerCat) {
        sellerCatMapper.updateByPrimaryKey(sellerCat);
    }

    @Override
    public void add(SellerCat sellerCat) {
        SellerCatExample example = new SellerCatExample();
        SellerCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(sellerCat.getParentId());
        sellerCat.setSortOrder(sellerCatMapper.countByExample(example));
        sellerCatMapper.insert(sellerCat);
    }

    @Override
    public List<SellerCat> findAll() {
        return sellerCatMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<SellerCat> page = (Page<SellerCat>) sellerCatMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
