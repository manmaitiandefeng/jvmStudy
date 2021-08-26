package com.zhiwen.jvm.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * 空对象
 * 
 * @author zhiwen
 */
public class CountEmptyObjectSize {

    public static void main(String[] args) {

        CountEmptyObjectSize obj = new CountEmptyObjectSize();

        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}
