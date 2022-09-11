package com.dreamer;

import com.dreamer.pojo.Pazzi;
import com.dreamer.pojo.User;

/**
 * @author dreamer
 * @creater 2022/8/16 0016 21:56
 */
public interface Factory {
    Pazzi createUser(String name);
}
