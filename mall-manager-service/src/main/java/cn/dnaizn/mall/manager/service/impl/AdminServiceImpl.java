package cn.dnaizn.mall.manager.service.impl;


import cn.dnaizn.mall.service.AdminService;
import com.alibaba.dubbo.config.annotation.Service;
import entity.PageResult;
import cn.dnaizn.mall.mapper.AdminMapper;
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

    /**
     * 查询全部
     */
    @Override
    public List<Admin> findAll() {
        return adminMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Admin> page = (Page<Admin>) adminMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

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

    /**
     * 批量删除
     */
    @Override
    public void delete(String[] ids) {
        for (String id : ids) {
            adminMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public PageResult findPage(Admin admin, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();

        if (admin != null) {
            if (admin.getAdminId() != null && admin.getAdminId().length() > 0) {
                criteria.andAdminIdLike("%" + admin.getAdminId() + "%");
            }
            if (admin.getPassword() != null && admin.getPassword().length() > 0) {
                criteria.andPasswordLike("%" + admin.getPassword() + "%");
            }

        }

        Page<Admin> page = (Page<Admin>) adminMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

}
