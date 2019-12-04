package cn.dnaizn.mall.sell.controller;

import cn.dnaizn.mall.VO.ResultVO;
import cn.dnaizn.mall.DTO.SellerRegisterDTO;
import cn.dnaizn.mall.enums.ResultEnum;
import cn.dnaizn.mall.pojo.Seller;
import cn.dnaizn.mall.sell.Jwt.JwtTokenUtils;
import cn.dnaizn.mall.service.SellerService;
import cn.dnaizn.mall.util.ResultVOUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Reference
    SellerService sellerService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/register")
    public ResultVO register(SellerRegisterDTO sellerRegisterDTO){
        sellerRegisterDTO.setPassword(bCryptPasswordEncoder.encode(sellerRegisterDTO.getPassword()));
        try {
            sellerService.add(sellerRegisterDTO);
            return ResultVOUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(),ResultEnum.PARAM_ERROR.getMessage());
        }
    }
    @RequestMapping("/refreshToken")
    @RolesAllowed({"SELLER", "VISITORS"})
    public ResultVO refreshToken(){
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Seller seller = sellerService.findOne(sellerId);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (seller.getStatus().equals(1)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));
        }else {
            authorities.add(new SimpleGrantedAuthority("ROLE_VISITORS"));
        }
        String role = "";
        for (GrantedAuthority authority : authorities){
            role = authority.getAuthority();
        }
        Map<String,String> map = new HashMap<>();
        map.put("token",JwtTokenUtils.createToken(seller.getSellerId(),role,true));
        return ResultVOUtil.success(map);
    }
    @RequestMapping("/username")
    public ResultVO username(String username){
        Seller seller = sellerService.findOne(username);
        if (seller==null){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(1,"该用户已存在");
    }
    @RequestMapping("/info")
    @RolesAllowed({"SELLER","VISITORS"})
    public ResultVO info(){
        Map<String,Object> map = new HashMap<>();
        map.put("username",SecurityContextHolder.getContext().getAuthentication().getName());
        map.put("authorities",SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return ResultVOUtil.success(map);
    }

}
