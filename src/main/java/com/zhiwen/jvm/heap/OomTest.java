package com.zhiwen.jvm.heap;

import com.zhiwen.jvm.User;

import java.util.ArrayList;
import java.util.List;

/**
 * oom测试
 * @author zhiwen
 */
public class OomTest {

    private static void aaa(){
        User user = new User();
        ClassLoader classLoader = user.getClass().getClassLoader();
        System.out.println(classLoader.getParent());
    }


    public static void main(String[] args) throws InterruptedException {
        List<User> list = new ArrayList<>();
        while (true) {
            Thread.sleep(10);
            list.add(new User());
        }
    }
}
