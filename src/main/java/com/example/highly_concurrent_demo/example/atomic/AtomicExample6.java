package com.example.highly_concurrent_demo.example.atomic;

import com.example.highly_concurrent_demo.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicIntegerFieldUpdater的介绍
 */
@Slf4j
@ThreadSafe
public class AtomicExample6 {

    //请求总数
    private static  int  clientTotal = 5000;

    //同时并发执行的线程数
    private static  int  threadTotal = 200;


    private  static AtomicBoolean isHappened =  new AtomicBoolean(false);


    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i <clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
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
        log.info("count:{}",isHappened.get());

    }

    private  static  void  test(){
        if (isHappened.compareAndSet(false,true)){
            log.info("execute");
        }
    }

}
