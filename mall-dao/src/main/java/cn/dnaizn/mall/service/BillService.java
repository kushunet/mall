package cn.dnaizn.mall.service;

import entity.PageResult;

public interface BillService {


    /**
     * 返回提现分页列表
     * @return
     */
    PageResult findPageTransfersList(String sellerId,int pageNum, int pageSize);

    /**
     * 返回结算分页列表
     * @return
     */
    PageResult findPageStatements(String sellerId,int pageNum, int pageSize);
    /**
     * 返回结算分页列表
     * @return
     */
    PageResult findPageStatementsList(Integer id , String sellerId,int pageNum, int pageSize);
}
