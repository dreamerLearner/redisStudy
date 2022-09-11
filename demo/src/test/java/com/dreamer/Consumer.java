package com.dreamer;

import com.dreamer.pojo.AFactory;

/**
 * @author dreamer
 * @creater 2022/8/16 0016 22:34
 */
public class Consumer {
    private Factory factory = new AFactory();
    public Consumer(String name){
        factory.createUser(name);
    }
}
