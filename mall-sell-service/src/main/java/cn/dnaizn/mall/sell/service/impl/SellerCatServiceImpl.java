package cn.dnaizn.mall.sell.service.impl;



import cn.dnaizn.mall.mapper.SellerCatMapper;
import cn.dnaizn.mall.pojo.SellerCat;
import cn.dnaizn.mall.pojo.SellerCatExample;
import cn.dnaizn.mall.service.SellerCatService;
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
@Transactional
public class SellerCatServiceImpl implements SellerCatService {

    @Autowired
    SellerCatMapper sellerCatMapper;

    /**
     * 查询全部
     */
    @Override
    public List<SellerCat> findAll() {
        return sellerCatMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<SellerCat> page = (Page<SellerCat>) sellerCatMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(SellerCat sellerCat) {
        SellerCatExample example = new SellerCatExample();
        SellerCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(sellerCat.getParentId());
        sellerCat.setSortOrder(sellerCatMapper.countByExample(example));
        sellerCatMapper.insert(sellerCat);
    }


    /**
     * 修改
     */
    @Override
    public void update(SellerCat sellerCat) {
        sellerCatMapper.updateByPrimaryKey(sellerCat);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public SellerCat findOne(Long id) {
        return sellerCatMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
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
    public List<SellerCat> findByParentId(Long parentId) {
        SellerCatExample example=new SellerCatExample();
        SellerCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        return sellerCatMapper.selectByExample(example);
    }
}
