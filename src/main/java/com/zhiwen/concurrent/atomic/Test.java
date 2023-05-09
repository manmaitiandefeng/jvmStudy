package com.zhiwen.concurrent.atomic;


import java.util.concurrent.atomic.AtomicBoolean;

public class Test {


    private static AtomicBoolean executorWorkStatus = new AtomicBoolean(true);

    public static void main(String[] args) {
        boolean b = executorWorkStatus.compareAndSet(false, true);
        System.out.println(executorWorkStatus);
        System.out.println(b);
    }
}
