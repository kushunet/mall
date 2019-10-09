package cn.dnaizn.mall.sell.service.impl;

import cn.dnaizn.mall.mapper.SellerBriefMapper;
import cn.dnaizn.mall.pojo.SellerBrief;
import cn.dnaizn.mall.pojo.SellerBriefExample;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import cn.dnaizn.mall.service.SellerBriefService;

import entity.PageResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
@Transactional
public class SellerBriefServiceImpl implements SellerBriefService {

    @Autowired
    SellerBriefMapper sellerBriefMapper;

    /**
     * 查询全部
     */
    @Override
    public List<SellerBrief> findAll() {
        return sellerBriefMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<SellerBrief> page = (Page<SellerBrief>) sellerBriefMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(SellerBrief sellerBrief) {
        sellerBriefMapper.insert(sellerBrief);
    }


    /**
     * 修改
     */
    @Override
    public void update(SellerBrief sellerBrief) {
        sellerBriefMapper.updateByPrimaryKey(sellerBrief);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public SellerBrief findOne(String id) {
        return sellerBriefMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(String[] ids) {
        for (String id : ids) {
            sellerBriefMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public PageResult findPage(SellerBrief sellerBrief, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SellerBriefExample example = new SellerBriefExample();
        SellerBriefExample.Criteria criteria = example.createCriteria();

        if (sellerBrief != null) {
            if (sellerBrief.getSellerId() != null && sellerBrief.getSellerId().length() > 0) {
                criteria.andSellerIdLike("%" + sellerBrief.getSellerId() + "%");
            }
            if (sellerBrief.getNickName() != null && sellerBrief.getNickName().length() > 0) {
                criteria.andNickNameLike("%" + sellerBrief.getNickName() + "%");
            }
            if (sellerBrief.getLinkmanMobile() != null && sellerBrief.getLinkmanMobile().length() > 0) {
                criteria.andLinkmanMobileLike("%" + sellerBrief.getLinkmanMobile() + "%");
            }
            if (sellerBrief.getLinkmanName() != null && sellerBrief.getLinkmanName().length() > 0) {
                criteria.andLinkmanNameLike("%" + sellerBrief.getLinkmanName() + "%");
            }
            if (sellerBrief.getAvatar() != null && sellerBrief.getAvatar().length() > 0) {
                criteria.andAvatarLike("%" + sellerBrief.getAvatar() + "%");
            }
            if (sellerBrief.getLocation() != null && sellerBrief.getLocation().length() > 0) {
                criteria.andLocationLike("%" + sellerBrief.getLocation() + "%");
            }
            if (sellerBrief.getAddress() != null && sellerBrief.getAddress().length() > 0) {
                criteria.andAddressLike("%" + sellerBrief.getAddress() + "%");
            }
            if (sellerBrief.getAddressDetail() != null && sellerBrief.getAddressDetail().length() > 0) {
                criteria.andAddressDetailLike("%" + sellerBrief.getAddressDetail() + "%");
            }
            if (sellerBrief.getAlbum() != null && sellerBrief.getAlbum().length() > 0) {
                criteria.andAlbumLike("%" + sellerBrief.getAlbum() + "%");
            }

        }

        Page<SellerBrief> page = (Page<SellerBrief>) sellerBriefMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

}
