package cn.dnaizn.mall.order.service.impl;

import cn.dnaizn.mall.mapper.StatementsListMapper;
import cn.dnaizn.mall.mapper.StatementsMapper;
import cn.dnaizn.mall.mapper.TransfersListMapper;
import cn.dnaizn.mall.pojo.*;
import cn.dnaizn.mall.service.BillService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class BillServiceImpl implements BillService {

    @Autowired
    TransfersListMapper transfersListMapper;

    @Autowired
    StatementsMapper statementsMapper;
    @Autowired
    StatementsListMapper statementsListMapper;
    @Override
    public PageResult findPageTransfersList(String sellerId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TransfersListExample example = new TransfersListExample();
        TransfersListExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        example.setOrderByClause("c_time desc");
        Page<TransfersList> page = (Page<TransfersList>) transfersListMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult findPageStatements(String sellerId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        StatementsExample example = new StatementsExample();
        StatementsExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        example.setOrderByClause("c_time desc");
        Page<Statements> page = (Page<Statements>) statementsMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult findPageStatementsList(Integer id,String sellerId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        StatementsListExample example = new StatementsListExample();
        StatementsListExample.Criteria criteria = example.createCriteria();
        criteria.andStatementsIdEqualTo(id);
        example.setOrderByClause("c_time desc");
        Page<StatementsList> page = (Page<StatementsList>) statementsListMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
