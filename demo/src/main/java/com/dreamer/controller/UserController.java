package com.dreamer.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dreamer.dto.LoginFormDTO;
import com.dreamer.dto.Result;
import com.dreamer.dto.UserDTO;
import com.dreamer.pojo.User;
import com.dreamer.service.UserService;
import com.dreamer.utils.RegexUtils;
import com.dreamer.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.dreamer.utils.RedisConstants.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private Result result = Result.getInstance();

    @GetMapping("/sendCode")
    public Result sendCode(@RequestParam("phone") String phone, HttpSession session){
        if(RegexUtils.isPhoneInvalid(phone)){
            return Result.getInstance().fail("手机号格式有误");
        }
        String code = RandomUtil.randomNumbers(6);
//        session.setAttribute("code",code);
        // code存储到redis中
        stringRedisTemplate.opsForValue().set(LOGIN_CODE_KEY+phone,code,LOGIN_CODE_TTL, TimeUnit.MINUTES);

        log.debug("发送验证码成功，验证码:{}",code);
        result.addData("code",code);
        return result.ok();
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginFormDTO loginForm,HttpSession session){
        //验证手机号
        String phone = loginForm.getPhone();
        log.debug("登录信息为{}",loginForm);
        if(RegexUtils.isPhoneInvalid(phone)){
            return Result.getInstance().fail("手机号格式有误");
        }
        //验证验证码
//        Object realCode = session.getAttribute("code");
        //从redis中获取code
        String code = loginForm.getCode();
        String realCode = stringRedisTemplate.opsForValue().get(LOGIN_CODE_KEY+phone);

//        log.debug("验证码为{}",code);
//        log.debug("缓存验证码为{}",realCode);
        if(null == realCode || !code.equals(realCode)){
            return Result.getInstance().fail("验证码错误");
        }
        //判断用户是否存在
        User user = userService.query().eq("phone", phone).one();
        if(user == null){
            user = new User("user_"+RandomUtil.randomString(10),Long.valueOf(phone),"123456");
            userService.save(user);

        }
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        Map<String, Object> userMap = BeanUtil.beanToMap(userDTO,new HashMap<>(),
                CopyOptions.create().setFieldValueEditor((fieldName,fieldVal)->fieldVal.toString()));
//        userMap.put("id",String.valueOf(userMap.get("id")));
        // 生成token令牌
        String token = UUID.randomUUID().toString(true);
        log.debug("令牌为{}",token);
        // 存储信息user（hash）
        stringRedisTemplate.opsForHash().putAll(LOGIN_USER_KEY+token,userMap);
        stringRedisTemplate.expire(LOGIN_USER_KEY+token,LOGIN_USER_TTL,TimeUnit.MINUTES);

        // 返回token

        log.debug("userDTO为{}",userDTO.getName());
//        session.setAttribute("user", userDTO);
        result.addData("token",token);
        return result.ok();
    }
    @PostMapping("/getUsers/{index}/{size}")
    public Result getUsers(@PathVariable int index,@PathVariable int size){
        Page<User> page = new Page<User>(index, size);
        Page<User> userList = userService.page(page);
        result.addData("userList",userList.getRecords());
        result.addData("total",userList.getTotal());
        return result.ok();
    }
    @GetMapping("/getUsers")
    public List<User> getUsers(){
        List<User> users = userService.getUsers();
        return users;
    }

}
