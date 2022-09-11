package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dreamer
 * @creater 2022/9/3 0003 21:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private long id;
    private String name;
    private long phone;
    private String password;

    public User(String name, long phone, String password) {
        this.name = name;
        this.phone = phone;
        this.password = password;
    }
}
