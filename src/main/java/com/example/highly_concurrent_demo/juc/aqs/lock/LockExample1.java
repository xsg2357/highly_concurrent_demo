package com.example.highly_concurrent_demo.juc.aqs.lock;

import com.example.highly_concurrent_demo.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * volatile synchronized 修饰
 */
@Slf4j
@ThreadSafe
public class LockExample1 {

    //请求总数
    public static  int  clientTotal = 5000;

    //同时并发执行的线程数
    public static  int  threadTotal = 200;

    //count:4955
    public static volatile  int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i <clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
//                        e.printStackTrace();
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",count);

    }

    public  synchronized static  void  add(){
        count ++;
        //        count.getAndIncrement();
    }

}
