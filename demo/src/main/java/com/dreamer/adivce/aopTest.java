package com.dreamer.adivce;

import com.dreamer.pojo.User;
import com.dreamer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author dreamer
 * @creater 2022/8/31 0031 11:45
 */
@Aspect
@Component
@Slf4j
public class aopTest {
    @Autowired
    private UserService userService;
    @Pointcut("execution (* com.dreamer.controller.UserController.*(..))")
    public void test(){}

//    @Before("test()")
//    public List<User> beforeAdvice() {
//        System.out.println("beforeAdvice...");
//        List<User> users = userService.getUsers();
//        return users;
//    }
//
//    @After("test()")
//    public void afterAdvice() {
//        System.out.println("afterAdvice...");
//    }
    @Around("test()")
    public Object logAround(ProceedingJoinPoint joinPoint)
            throws Throwable {
        log.info("开始增强");
        Object result = joinPoint.proceed();
        log.info("结束增强");
        return result;
//        if (log.isDebugEnabled()) {
//            log.debug("Enter: {}.{}() with argument[s] = {}",
//                    joinPoint.getSignature().getDeclaringTypeName(),
//                    joinPoint.getSignature().getName(),
//                    Arrays.toString(joinPoint.getArgs()));
//        }
//
//        try {
//            Object result = joinPoint.proceed();
//
//            if (log.isDebugEnabled()) {
//                log.debug("Exit: {}.{}() with result = {}",
//                        joinPoint.getSignature().getDeclaringTypeName(),
//                        joinPoint.getSignature().getName(), result);
//            }
//
//            return result;
//        } catch (IllegalArgumentException e) {
//            log.error("Illegal argument: {} in {}.{}()",
//                    Arrays.toString(joinPoint.getArgs()),
//                    joinPoint.getSignature().getDeclaringTypeName(),
//                    joinPoint.getSignature().getName());
//            throw e;
//        }

    }


}
