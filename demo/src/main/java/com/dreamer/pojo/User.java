package com.dreamer.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
