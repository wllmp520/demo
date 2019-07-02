package com.example.demo.service.impl;

import com.example.demo.exception.BusinessException;
import com.example.demo.model.AyUser;
import com.example.demo.model.AyUserRoleRel;
import com.example.demo.service.AyRoleService;
import com.example.demo.service.AyUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @program: demo
 * @description: 自定义用户服务类
 * @author: wllmp520
 * @create: 2019-06-25 16:45
 */
@Service
public class CustomUserServiceImpl implements UserDetailsService {
    @Autowired
    private AyUserService ayUserService;
    @Autowired
    private AyRoleService ayRoleService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        List<AyUser> name1 = ayUserService.findByName(name);
        if(name1 ==null || name1 .size()<1){
            throw  new BusinessException("用户不存在");
        }
        List<AyUserRoleRel> ayUserRoleRelList = ayRoleService.findByUserId(name1.get(0).getId());
        //security中的对象
        List<GrantedAuthority> authorities=new ArrayList<>();
        if(ayUserRoleRelList !=null || ayUserRoleRelList .size()>0){
            for (AyUserRoleRel ayUserRoleRel : ayUserRoleRelList) {
                String role=ayRoleService.find(ayUserRoleRel.getRoleId()).getName();
                authorities.add(new SimpleGrantedAuthority(role));
            }

        }
        return  new User(name1.get(0).getName(),name1.get(0).getPassword(),authorities);
    }
}