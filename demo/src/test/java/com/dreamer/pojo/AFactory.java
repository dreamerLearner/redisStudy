package com.dreamer.pojo;

import com.dreamer.Factory;

import java.util.List;

/**
 * @author dreamer
 * @creater 2022/8/16 0016 22:04
 */
public class AFactory implements Factory {
    private Pazzi pazzi;
    @Override
    public Pazzi createUser(String name) {
        if("APazzi".equals(name)){
            pazzi = new APazzi();
        }else if("BPazzi".equals(name)){
            pazzi = new BPazzi();
        }
        return pazzi;
    }
}
