package com.dreamer.service.ManagerService;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dreamer.pojo.Manager;

import java.util.List;

public interface ManagerService extends IService<Manager> {
    List<Manager> getAllManagers();

}
