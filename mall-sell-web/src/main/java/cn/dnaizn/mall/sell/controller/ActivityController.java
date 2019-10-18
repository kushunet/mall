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

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Reference
    DiscountService discountServices;
    @Reference
    FullReductionService fullReductionService;

    @RequestMapping("/addDiscount")
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
    public ResultVO findAllDiscount() {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResultVOUtil.success(discountServices.findAll(sellerId));

    }

    @RequestMapping("/updateDiscount")
    public ResultVO updateDiscount(@RequestBody Discount discount) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (discount.getSellerId().equals(sellerId)){
            try {
                discountServices.update(discount);
                return ResultVOUtil.success("红包修改成功");
            } catch (Exception e) {
                e.printStackTrace();
                return ResultVOUtil.error(1,"红包修改失败");
            }

        }else {
            return ResultVOUtil.error(1,"该优惠价不属于该商家");
        }
    }

    @RequestMapping("/addFullReduction")
    public ResultVO addFullReduction(@RequestBody FullReduction fullReduction) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        fullReduction.setSellerId(sellerId);
        try {
            fullReductionService.add(fullReduction);
            return ResultVOUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(1, "添加满减失败");
        }
    }

    @RequestMapping("/findAllFullReduction")
    public ResultVO findAllFullReduction() {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResultVOUtil.success(fullReductionService.findAll(sellerId));
    }
    @RequestMapping("/updateFullReduction")
    public ResultVO updateFullReduction(@RequestBody FullReduction fullReduction) {
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (fullReduction.getSellerId().equals(sellerId)){
            try {
                fullReductionService.update(fullReduction);
                return ResultVOUtil.success("满减修改成功");
            } catch (Exception e) {
                e.printStackTrace();
                return ResultVOUtil.error(1,"满减修改失败");
            }

        }else {
            return ResultVOUtil.error(1,"该优惠价不属于该商家");
        }
    }
}
