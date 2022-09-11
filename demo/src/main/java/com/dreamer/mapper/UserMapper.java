package com.dreamer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dreamer.dto.LoginFormDTO;
import com.dreamer.dto.Result;
import com.dreamer.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.List;


@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    Result sendCode(String phone, HttpSession session);
    Result login(LoginFormDTO loginForm, HttpSession session);
    List<User> getUsers();
}
