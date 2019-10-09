package cn.dnaizn.mall.manager.controller;


import cn.dnaizn.mall.DTO.GoodsDTO;
import cn.dnaizn.mall.VO.GoodsVO;
import cn.dnaizn.mall.service.GoodsService;
import cn.dnaizn.mall.pojo.Goods;
import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Reference
	GoodsService goodsService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Goods> findAll(){
		return goodsService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return goodsService.findPage(page, rows);
	}
	

	
	/**
	 * 修改
	 * @param goodsDTO
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody GoodsDTO goodsDTO){
		try {
			goodsService.update(goodsDTO);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public GoodsVO findOne(Integer id){
		return goodsService.findOne(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			goodsService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	/**
	 * 查询+分页
	 * @param goods
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Goods goods, int page, int rows  ){
		return goodsService.findPage(goods, page, rows);		
	}
//    /**
//     * 更新状态
//     * @param ids
//     * @param status
//     */
//    @RequestMapping("/updateStatus")
//    public Result updateStatus(Long[] ids, String status){
//        try {
//            goodsService.updateStatus(ids, status);
//            return new Result(true, "成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Result(false, "失败");
//        }
//    }

}
