package cn.dnaizn.mall.sell.service.impl;

import cn.dnaizn.mall.mapper.DiscountMapper;
import cn.dnaizn.mall.mapper.UserCouponsMapper;
import cn.dnaizn.mall.pojo.Discount;
import cn.dnaizn.mall.pojo.DiscountExample;
import cn.dnaizn.mall.pojo.UserCouponsExample;
import cn.dnaizn.mall.service.DiscountService;
import cn.dnaizn.mall.utils.KeyUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    DiscountMapper discountMapper;

    @Autowired
    UserCouponsMapper userCouponsMapper;
    /**
     * 查询全部
     */
    @Override
    public List<Discount> findAll(String sellerId) {
        DiscountExample example = new DiscountExample();
        DiscountExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        return discountMapper.selectByExample(example);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Discount> page = (Page<Discount>) discountMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(Discount discount) {
        discount.setUuid(KeyUtil.genUniqueKey());
        discountMapper.insert(discount);
    }


    /**
     * 修改
     */
    @Override
    public void update(Discount discount) {
        discountMapper.updateByPrimaryKeySelective(discount);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public Discount findOne(Integer id) {
        return discountMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            Discount discount = discountMapper.selectByPrimaryKey(id);
            UserCouponsExample example = new UserCouponsExample();
            UserCouponsExample.Criteria criteria = example.createCriteria();
            criteria.andDiscountUuidEqualTo(discount.getUuid());
            userCouponsMapper.deleteByExample(example);
            discountMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void rDelete(Integer[] ids) {
        for (Integer id : ids) {
            Discount discount = discountMapper.selectByPrimaryKey(id);
            discount.setIsDelete((int) (System.currentTimeMillis() / 1000));
            discountMapper.updateByPrimaryKeySelective(discount);
        }
    }

    @Override
    public PageResult findPage(Discount discount, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        DiscountExample example = new DiscountExample();
        DiscountExample.Criteria criteria = example.createCriteria();

        if (discount != null) {
            if (discount.getUuid() != null && discount.getUuid().length() > 0) {
                criteria.andUuidLike("%" + discount.getUuid() + "%");
            }
            if (discount.getSellerId() != null && discount.getSellerId().length() > 0) {
                criteria.andSellerIdLike("%" + discount.getSellerId() + "%");
            }
            if (discount.getTitle() != null && discount.getTitle().length() > 0) {
                criteria.andTitleLike("%" + discount.getTitle() + "%");
            }

        }

        Page<Discount> page = (Page<Discount>) discountMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

}
