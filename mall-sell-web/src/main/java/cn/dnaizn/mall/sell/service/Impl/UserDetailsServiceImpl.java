package cn.dnaizn.mall.sell.service.Impl;


import cn.dnaizn.mall.pojo.Seller;
import cn.dnaizn.mall.sell.Jwt.JwtUser;
import cn.dnaizn.mall.service.SellerService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 认证类
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Reference
    SellerService sellerService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Seller seller = sellerService.findOne(s);
        if (seller == null) {
            seller = sellerService.findMobile(s);
        }
        if (seller == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return new JwtUser(seller);
    }
}
