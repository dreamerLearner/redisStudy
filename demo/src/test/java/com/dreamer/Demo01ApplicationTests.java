package com.dreamer;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.codec.Morse;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamer.mapper.ManagerMapper;
import com.dreamer.pojo.Manager;
import com.dreamer.pojo.User;
import com.dreamer.service.ManagerService.ManagerService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.Wrapper;
import java.util.*;
import java.util.List;

@Slf4j
@SpringBootTest
class Demo01ApplicationTests extends ServiceImpl<ManagerMapper, Manager> {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ManagerService managerService;

    @Autowired
    private ManagerMapper managerMapper;

    @Test
    void contextLoads() throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        User user = new User("张三", 22);
//        String s = mapper.writeValueAsString(user);
//        stringRedisTemplate.opsForValue().set("user:2", s);
//
//        String rs = stringRedisTemplate.opsForValue().get("user:2");
//        User user1 = mapper.readValue(rs, User.class);
//        System.out.println(user1);
    }

    @Test
    void test() {
        System.out.println(6^3);
        System.out.println(~6);


    }

    @Test
    public void testSelectById() {
//        Manager manager = new Manager();
//        manager.setAccount("8646544");
//        manager.setPassword("123456");
//        manager.setName("大兵");
//        UpdateWrapper<Manager> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.eq("id","5");
//        managerMapper.update(manager,updateWrapper);
//        KeyPair pair = SecureUtil.generateKeyPair("RSA");
//        RSA rsa = new RSA();
//
//        String s = rsa.getPrivateKeyBase64();
//        log.debug("私钥为{}",s);
//        byte[] encrypt = rsa.encrypt(StrUtil.bytes("陈博林回家吃饭了", CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
//
//        log.debug("加密后{}",encrypt);
//
//        byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);
//        String str = StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);
//        log.debug("解密后{}",str);

    }


}
