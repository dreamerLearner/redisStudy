package com.dreamer.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

//字段拦截
@Component
public class MyPropertiesHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object password = getFieldValByName("password", metaObject);
        if(null == password){
            setFieldValByName("password","888888",metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
