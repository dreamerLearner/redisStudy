package com.dreamer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dreamer.dto.LoginFormDTO;
import com.dreamer.dto.Result;
import com.dreamer.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService extends IService<User> {
    List<User> getUsers();
}
