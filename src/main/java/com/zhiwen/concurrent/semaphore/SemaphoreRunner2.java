package com.zhiwen.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * <p>SemaphoreRunner</p>
 * @author zhiwen
 * @since 2022/8/19 2:40 下午
 */
public class SemaphoreRunner2 {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        for (int i=0;i<10;i++){
            semaphore.acquire();
            new Thread(new Task("zhiwen+"+i)).start();
            semaphore.release();
        }
    }

    static class Task extends Thread{

        public Task(String tname){
            this.setName(tname);
        }

        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+":aquire() at time:"+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+":aquire() at time:"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
