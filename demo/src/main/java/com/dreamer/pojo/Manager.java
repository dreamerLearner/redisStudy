package com.dreamer.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.security.provider.MD5;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("manager")
public class Manager extends Model<Manager> {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String account;
    private String password;

    public Manager(String name, String account, String password) {
        this.name = name;
        this.account = account;
        this.password = password;
    }
}
