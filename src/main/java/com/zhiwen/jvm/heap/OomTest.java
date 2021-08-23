package com.zhiwen.jvm.heap;

import com.zhiwen.jvm.User;

import java.util.ArrayList;
import java.util.List;

/**
 * oom测试
 * @author zhiwen
 */
public class OomTest {



    public static void main(String[] args) throws InterruptedException {
        List<User> list = new ArrayList<>();
        while (true) {
//            Thread.sleep(10);
            list.add(new User());
        }
    }
}
