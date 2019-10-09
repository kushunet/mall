package cn.dnaizn.mall.sell.controller;

import cn.dnaizn.mall.VO.GoodsCatVO;
import cn.dnaizn.mall.VO.ResultVO;
import cn.dnaizn.mall.enums.ResultEnum;
import cn.dnaizn.mall.pojo.GoodsCat;
import cn.dnaizn.mall.util.ResultVOUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.dnaizn.mall.service.GoodsCatService;

import entity.PageResult;

import javax.annotation.security.RolesAllowed;
import java.util.List;


/**
 * controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/goodsCat")
public class GoodsCatController {

    @Reference
    GoodsCatService goodsCatService;

    /**
     * 返回一级列表
     *
     * @return
     */
    @RequestMapping("/findIdNumber")
    @RolesAllowed({"SELLER"})
    public ResultVO findIdNumber(@RequestParam(value = "type", defaultValue = "0") Integer type) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        List<GoodsCatVO> goodsCatVOList = goodsCatService.findBySellerIdNumber(sellerId,type);
        return ResultVOUtil.success(goodsCatVOList);
    }
    /**
     * 返回二级列表
     *
     * @return
     */
    @RequestMapping("/findByParentIdNumber")
    @RolesAllowed({"SELLER"})
    public ResultVO findParentIdNumber(Integer parentId,@RequestParam(value = "type", defaultValue = "0") Integer type) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        List<GoodsCatVO> goodsCatVOList = goodsCatService.findByParentIdNumber(parentId,sellerId,type);
        return ResultVOUtil.success(goodsCatVOList);
    }
    /**
     * 返回顶级列表
     *
     * @return
     */
    @RequestMapping("/findTobNumber")
    @RolesAllowed({"SELLER"})
    public ResultVO findTobNumber(@RequestParam(value = "type", defaultValue = "0") Integer type) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResultVOUtil.success(goodsCatService.number(sellerId,type));
    }
    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    @RolesAllowed({"SELLER"})
    public ResultVO findAll() {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            return ResultVOUtil.success(goodsCatService.findAll(sellerId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), "查询失败");
        }
    }

    /**
     * 增加
     *
     * @param goodsCat
     * @return
     */
    @RequestMapping("/add")
    @RolesAllowed({"SELLER"})
    public ResultVO add(@RequestBody GoodsCat goodsCat) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        goodsCat.setSellerId(sellerId);
        try {
            goodsCatService.add(goodsCat);
            return ResultVOUtil.success("增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), "增加失败");
        }
    }
    /**
     * 修改顺序
     *
     * @param ids
     * @return
     */
    @RequestMapping("/upSortOrder")
    @RolesAllowed({"SELLER"})
    public ResultVO upSortOrder(Integer[] ids) {
        try {
            goodsCatService.upSortOrder(ids);
			return ResultVOUtil.success("顺序修改成功");
        } catch (Exception e) {
            e.printStackTrace();
			return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), "顺序修改失败");
        }
    }

    /**
     * 修改
     *
     * @param goodsCat
     * @return
     */
    @RequestMapping("/update")
    @RolesAllowed({"SELLER"})
    public ResultVO update(@RequestBody GoodsCat goodsCat) {
        System.out.println(goodsCat);
        try {
            goodsCatService.update(goodsCat);
            return ResultVOUtil.success("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, e.getMessage());
        }
    }

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    @RolesAllowed({"SELLER"})
    public ResultVO findOne(Integer id) {
       return ResultVOUtil.success(goodsCatService.findOne(id));
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RolesAllowed({"SELLER"})
    public ResultVO delete(Integer[] ids) {
        try {
            goodsCatService.delete(ids);
            return ResultVOUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, "删除失败");
        }
    }

    /**
     * 查询+分页
     *
     * @param goodsCat
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    @RolesAllowed({"SELLER"})
    public PageResult search(@RequestBody GoodsCat goodsCat, int page, int rows) {
        return goodsCatService.findPage(goodsCat, page, rows);
    }

}
