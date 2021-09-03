package com.zhiwen.jvm.gc;

/**
 * @description: gc测试
 * @author zhiwen
 * @date 2021/9/3 14:09
 * @version 1.0
 */
public class GcTest {
    public static void main(String[] args) {
        byte[] allocation1, allocation2/*, allocation3, allocation4, allocation5, allocation6*/;
        allocation1 = new byte[60000*1024];

        //allocation2 = new byte[8000*1024];

      /*allocation3 = new byte[1000*1024];
     allocation4 = new byte[1000*1024];
     allocation5 = new byte[1000*1024];
     allocation6 = new byte[1000*1024];*/
    }
}
