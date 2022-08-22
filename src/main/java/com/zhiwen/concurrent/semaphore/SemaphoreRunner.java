package com.zhiwen.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * <p>SemaphoreRunner</p>
 * @author zhiwen
 * @since 2022/8/19 2:40 下午
 */
public class SemaphoreRunner {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        for (int i=0;i<5;i++){
            semaphore.acquire();
            new Thread(new Task(semaphore,"zhiwen+"+i)).start();
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

                System.out.println(Thread.currentThread().getName()+":aquire() at time:"+System.currentTimeMillis());
                Thread.sleep(2000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName()+":aquire() at time:"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

            }

        }
    }

}
