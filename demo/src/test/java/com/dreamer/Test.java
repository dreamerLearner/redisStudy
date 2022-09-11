package com.dreamer;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * @author dreamer
 * @creater 2022/8/2 0002 14:12
 */
@Component
@Slf4j
public class Test{
    @org.junit.Test
    public void contextLoads() {

        HashMap<String, Object> map = new HashMap<>();

        //获取日历对象
        Calendar instance = Calendar.getInstance();
        //默认30S过期
        instance.add(Calendar.SECOND,30);

        String token = JWT.create()
                .withHeader(map)     //header,可以不写
                .withClaim("userId", 21)    //payload
                .withClaim("username", "Garry")   //payload
                .withExpiresAt(instance.getTime())    //设置过期时间
                .sign(Algorithm.HMAC256("!ISN!@#￥%"));   //签名

        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("!ISN!@#￥%")).build();
        DecodedJWT verify = verifier.verify(token);
        int userId = verify.getClaim("userId").asInt();
        String username = verify.getClaim("username").asString();
        log.info("userId:{},username:{}",userId,username);

        System.out.println(token);
    }





}
