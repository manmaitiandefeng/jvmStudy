package com.zhiwen.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>CountDownLatchTest</p>
 * @author zhiwen
 * @since 2022/8/19 5:44 下午
 */
public class CountDownLaunchRunner {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        long now = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);

        executorService.execute(()->{
            try {
                System.out.println("开始看医生");
                Thread.sleep(3000);
                System.out.println("看医生结束，准备离开病房");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {

            }
            try {
                System.out.println("开始在医院药房排队买药....");
                Thread.sleep(5000);
                System.out.println("排队成功，可以开始缴费买药");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {

            }
            if (countDownLatch != null)
                countDownLatch.countDown();
        });

        /*new Thread(new SeeDoctorTask(countDownLatch)).start();
        new Thread(new QueueTask(countDownLatch)).start();*/
        //等待线程池中的2个任务执行完毕，否则一直
        countDownLatch.await();
        System.out.println("over，回家 cost:"+(System.currentTimeMillis()-now));
    }
    
}


/**
 * 看大夫任务
 * @author toutou
 */
class SeeDoctorTask implements Runnable {
    private CountDownLatch countDownLatch;

    public SeeDoctorTask(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("开始看医生");
            Thread.sleep(3000);
            System.out.println("看医生结束，准备离开病房");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (countDownLatch != null)
                countDownLatch.countDown();
        }
    }

}

/**
 * 排队的任务
 */
class QueueTask implements Runnable {

    private CountDownLatch countDownLatch;

    public QueueTask(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            System.out.println("开始在医院药房排队买药....");
            Thread.sleep(5000);
            System.out.println("排队成功，可以开始缴费买药");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (countDownLatch != null)
                countDownLatch.countDown();
        }
    }
}
