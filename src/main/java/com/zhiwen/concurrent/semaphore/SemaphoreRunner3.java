package com.zhiwen.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>SemaphoreRunner</p>
 * @author zhiwen
 * @since 2022/8/19 2:40 下午
 */
public class SemaphoreRunner3 {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Semaphore semaphore = new Semaphore(2);
        try {
            for (int i=0;i<5;i++){
                executorService.execute(new Task(semaphore,"zhiwen+"+i));
            }
        } finally {
                executorService.shutdown();
        }

    }

    static class Task extends Thread{
        Semaphore semaphore;

        public Task(Semaphore semaphore,String tname){
            this.semaphore = semaphore;
            this.setName(tname);
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+":aquire() at time:"+System.currentTimeMillis());
                Thread.sleep(2000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName()+":aquire() at time:"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
