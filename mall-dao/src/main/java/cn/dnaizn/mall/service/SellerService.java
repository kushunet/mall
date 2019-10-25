package cn.dnaizn.mall.service;


import cn.dnaizn.mall.DTO.AddressDTO;
import cn.dnaizn.mall.DTO.DeliverDTO;
import cn.dnaizn.mall.DTO.SellerFormDTO;
import cn.dnaizn.mall.DTO.SellerRegisterDTO;
import cn.dnaizn.mall.pojo.Seller;
import cn.dnaizn.mall.pojo.SellerBrief;
import cn.dnaizn.mall.pojo.SellerExamine;
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
	 * 修改
	 */
	void tUpdate(String sellerId,Integer id);
	/**
	 * 修改
	 */
	void updateSellerBrief(SellerBrief sellerBrief);
	/**
	 * 查询修改
	 */
	List<SellerExamine> findOneUpdate(String sellerId,Integer type);
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Seller findOne(String id);

	/**
	 * 查询配送
	 * @param sellerId
	 * @return
	 */
	DeliverDTO findOneDeliver(String sellerId);
	/**
	 * 查询地址
	 * @param sellerId
	 */
	AddressDTO findAddress(String sellerId);
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

	void addUpdate(SellerExamine sellerExamine);
}
