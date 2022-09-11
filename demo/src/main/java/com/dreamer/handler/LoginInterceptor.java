package com.dreamer.handler;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.useragent.UserAgentUtil;
import com.dreamer.dto.UserDTO;
import com.dreamer.pojo.User;
import com.dreamer.utils.RedisConstants;
import com.dreamer.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.dreamer.utils.RedisConstants.*;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    private StringRedisTemplate stringRedisTemplate;

    public LoginInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        log.debug("此处为拦截器");
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())){
            System.out.println("OPTIONS请求，放行");
            return true;
        }
        String token = request.getHeader("Authorization");
        log.debug("token为：{}",token);
        if (StrUtil.isBlank(token)){
            response.setStatus(401);
            return false;
        }
        Map<Object, Object> userMap = stringRedisTemplate.opsForHash().entries(LOGIN_USER_KEY + token);
        log.debug("userMap为{}",userMap);
        if (userMap.isEmpty()){
            response.setStatus(401);
            return false;
        }
        //从redis中获取user
//        Object user = stringRedisTemplate.opsForHash().get(LOGIN_USER_KEY + token, "userMap");
        //  将userMap转为UserDTO
        UserDTO userDTO = BeanUtil.fillBeanWithMap(userMap, new UserDTO(), false);

        log.debug("user值为{}",userMap);
        //保存信息到TheadLocal
        UserHolder.saveUser(userDTO);
        //刷新缓存时间
        stringRedisTemplate.expire(LOGIN_CODE_KEY+token,LOGIN_CODE_TTL, TimeUnit.MINUTES);
        //放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
