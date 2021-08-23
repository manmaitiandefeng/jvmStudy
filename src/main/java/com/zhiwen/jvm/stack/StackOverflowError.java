package com.zhiwen.jvm.stack;

/**
 * 栈溢出
 * @author zhiwen
 * jvm 配置每个线程的栈大小 Xss,理论-Xss设置越小count值越小，说明一个线程栈里能分配的栈帧就越少，但是对JVM整体来说能开启的线程数会更多
 *
 */
public class StackOverflowError {

    static int count = 0;

    static void redo(){
        count++;
        redo();
    }

    public static void main(String[] args) {
        try {
            redo();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("执行次数:"+count);
        }
    }


}
