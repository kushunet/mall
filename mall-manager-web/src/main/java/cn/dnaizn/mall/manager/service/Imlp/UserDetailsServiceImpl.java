package cn.dnaizn.mall.manager.service.Imlp;

import cn.dnaizn.mall.pojo.Admin;
import cn.dnaizn.mall.service.AdminService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 认证类
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Reference
    AdminService adminService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> grantAuths = new ArrayList<>();
        grantAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        Admin admin = adminService.findOne(s);
        if (admin!=null){
                return new User(s,admin.getPassword(),grantAuths);
        }else {
            return null;
        }

    }
}
