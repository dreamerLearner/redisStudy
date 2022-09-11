package com.example.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dreamer
 * @creater 2022/9/3 0003 21:40
 */

public interface UserService extends IService<User> {
    /**
     * @description:获取用户信息
     **/
    String selectPwdByName(@Param("name") String name);

}
