package com.dreamer.service.ManagerService;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dreamer.mapper.ManagerMapper;
import com.dreamer.pojo.Manager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper,Manager> implements ManagerService {
    @Override
    public List<Manager> getAllManagers() {
        return list();
    }
}
