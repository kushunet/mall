package cn.dnaizn.mall.service;


import cn.dnaizn.mall.DTO.SellerFormDTO;
import cn.dnaizn.mall.DTO.SellerRegisterDTO;
import cn.dnaizn.mall.pojo.Seller;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SellerService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<Seller> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(SellerRegisterDTO sellerRegisterDTO);
	
	
	/**
	 * 修改
	 */
	void update(Seller seller);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Seller findOne(String id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void delete(String[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	PageResult findPage(Seller seller, int pageNum, int pageSize);

	void updateStatus(String sellerId, Integer status);

	Seller findMobile(String mobile);

	void SellerRegister(SellerFormDTO sellerFormDTO);

	SellerFormDTO getSellerRegisterById(String sellerId);

	void createSmsCode(String mobile);

	boolean  checkSmsCode(String mobile,String code);
}
