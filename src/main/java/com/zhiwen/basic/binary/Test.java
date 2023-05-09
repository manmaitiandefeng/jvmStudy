package com.zhiwen.basic.binary;


import org.apache.commons.codec.binary.Hex;

public class Test {


    public static void main(String[] args) {
        /*int a = 15;
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toOctalString(a));

        System.out.printf("八进制输出%o\n",a);
        System.out.printf("十六进制输出%x\n",a);

        int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY   = (1 << COUNT_BITS) - 1;


        System.out.println("RUNNING" +   Integer.toBinaryString((-1 << COUNT_BITS)));
        System.out.println("RUNNING" +   (-1 << COUNT_BITS));
        System.out.println("STOP" +   Integer.toBinaryString((1 << COUNT_BITS)));
        System.out.println("test" +   Integer.toBinaryString((1 << 3)));
        System.out.println("TIDYING" +   (2 << COUNT_BITS));
        System.out.println("TERMINATED" +   (3 << COUNT_BITS));*/
        System.out.println("负数" +   Integer.toBinaryString(-4));
        System.out.println("负数" +   Integer.toBinaryString(-4>>2));


        System.out.println();



    }


}
