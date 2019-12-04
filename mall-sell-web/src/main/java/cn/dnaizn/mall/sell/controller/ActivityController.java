package cn.dnaizn.mall.sell.controller;

import cn.dnaizn.mall.VO.ResultVO;
import cn.dnaizn.mall.pojo.Discount;
import cn.dnaizn.mall.pojo.FullReduction;
import cn.dnaizn.mall.service.DiscountService;
import cn.dnaizn.mall.service.FullReductionService;
import cn.dnaizn.mall.util.ResultVOUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * @author GT62VR
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Reference
    DiscountService discountServices;
    @Reference
    FullReductionService fullReductionService;

    @RequestMapping("/addDiscount")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO addDiscount(@RequestBody Discount discount) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        discount.setSellerId(sellerId);
        try {
            discountServices.add(discount);
            return ResultVOUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, "添加红包失败");
        }
    }

    @RequestMapping("/findAllDiscount")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO findAllDiscount() {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResultVOUtil.success(discountServices.findAll(sellerId));

    }

    @RequestMapping("/deleteDiscount")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO deleteDiscount(Integer[] ids) {
            try {
                discountServices.delete(ids);
                return ResultVOUtil.success("红包永久删除成功");
            } catch (Exception e) {
                e.printStackTrace();
                return ResultVOUtil.error(1,"红包永久删除失败");
            }
    }
    @RequestMapping("/rDeleteDiscount")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO rDeleteDiscount(Integer[] ids) {
        try {
            discountServices.rDelete(ids);
            return ResultVOUtil.success("红包删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1,"红包删除失败");
        }
    }
    @RequestMapping("/updateDiscount")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO updateDiscount(@RequestBody Discount discount) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        discount.setSellerId(sellerId);
        try {
            discountServices.update(discount);
            return ResultVOUtil.success("红包修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1,"红包修改失败");
        }
    }


    @RequestMapping("/findAllFullReduction")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO findAllFullReduction() {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResultVOUtil.success(fullReductionService.findAll(sellerId));
    }
    @RequestMapping("/updateFullReduction")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO updateFullReduction(@RequestBody FullReduction fullReduction) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        fullReduction.setSellerId(sellerId);
            try {
                fullReductionService.update(fullReduction);
                return ResultVOUtil.success("满减修改成功");
            } catch (Exception e) {
                e.printStackTrace();
                return ResultVOUtil.error(1,"满减修改失败");
            }
    }
}
