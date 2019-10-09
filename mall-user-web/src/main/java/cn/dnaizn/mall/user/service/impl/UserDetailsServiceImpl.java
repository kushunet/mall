package cn.dnaizn.mall.user.service.impl;

import cn.dnaizn.mall.pojo.User;
import cn.dnaizn.mall.service.UserService;
import cn.dnaizn.mall.user.Jwt.JwtUser;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Reference
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = userService.findUsername(s);
//        return new JwtUser(user);
        return new JwtUser();
    }
}
