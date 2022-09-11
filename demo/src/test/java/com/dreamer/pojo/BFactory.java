package com.dreamer.pojo;

import com.dreamer.Factory;

/**
 * @author dreamer
 * @creater 2022/8/16 0016 22:07
 */
public class BFactory implements Factory {
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
