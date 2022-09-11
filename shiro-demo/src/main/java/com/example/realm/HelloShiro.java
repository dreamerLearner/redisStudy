package com.example.realm;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.serviceImpl.UserServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dreamer
 * @creater 2022/9/3 0003 23:24
 */
@Service
public class HelloShiro extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * @description:登录认证
     * @param:
     * @return:
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println(userService.getClass().getName());
        //获取登录名
        String loginName = (String) authenticationToken.getPrincipal();
//        UserService userService = new UserServiceImpl();
        System.out.println(loginName);
        String password = userService.selectPwdByName(loginName);
        if (password == null) {
            throw new UnknownAccountException("账户不存在");
        }
        return new SimpleAuthenticationInfo(loginName, password, getName());
    }
}
