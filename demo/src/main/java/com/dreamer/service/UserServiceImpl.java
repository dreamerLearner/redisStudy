package com.dreamer.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamer.dto.LoginFormDTO;
import com.dreamer.dto.Result;
import com.dreamer.mapper.UserMapper;
import com.dreamer.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }
}
