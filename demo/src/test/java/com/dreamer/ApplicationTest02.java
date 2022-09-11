package com.dreamer;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.dreamer.mapper.ManagerMapper;
import com.dreamer.pojo.AFactory;
import com.dreamer.pojo.Manager;
import com.dreamer.service.ManagerService.ManagerService;
import com.dreamer.service.ManagerService.ManagerServiceImpl;
import com.dreamer.utils.MD5;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest02 {
    @Test
    public void testInsert() {
        Consumer consumer = new Consumer("APazzi");
    }
}
