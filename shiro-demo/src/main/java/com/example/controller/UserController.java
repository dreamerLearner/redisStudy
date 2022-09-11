package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dreamer
 * @creater 2022/9/3 0003 22:29
 */
@RestController
@RequestMapping("user/api")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/selectAllByName/{name}")
    public String selectAllByName(@PathVariable("name") String name){
        String password = userService.selectPwdByName(name);
        return password;
    }
}
