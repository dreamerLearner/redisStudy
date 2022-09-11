package com.example;

import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//@SpringBootTest
class ShiroDemoApplicationTests {
    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
        String s = "a,b,cd";
        System.out.println(Arrays.asList(s.split(",")));
    }


}
