package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dreamer
 * @creater 2022/9/3 0003 21:49
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    String selectPwdByName(@Param("name") String name);


}
