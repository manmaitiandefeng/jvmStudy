package com.zhiwen.jvm.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * 数组在未开启指针压缩 会有两段填充
 */
public class ArrayJolTest {

    static int[] arr = {};

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());
    }
}
