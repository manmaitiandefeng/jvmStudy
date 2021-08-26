package com.zhiwen.jvm.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * 普通对象
 * @author zhiwen
 */
public class CountObjectSize {

//    static int d = 40;
    int a = 10;
    int b = 20;
    int c = 30;
    int d = 40;


    public static void main(String[] args) {
        CountObjectSize objectSize = new CountObjectSize();
        System.out.println(ClassLayout.parseInstance(new CountObjectSize()).toPrintable());
    }
}
