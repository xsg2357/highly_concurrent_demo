package com.example.highly_concurrent_demo.juc.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample2 {

    private static final int  threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore  semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final  int threadNum = i;
            executorService.execute(()->{
                try {
                    semaphore.acquire(3); //获取多个许可
                    test(threadNum);
                    semaphore.release(3); //释放多个许可
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    log.error("parse:{}",e.getMessage());
                }
            });
        }
        log.error("finish");
        executorService.shutdown();
//        10:06:31.780 [main] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - finish
//        10:06:31.780 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 0
//        10:06:32.791 [pool-1-thread-2] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 1
//        10:06:33.791 [pool-1-thread-3] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 2
//        10:06:34.792 [pool-1-thread-4] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 3
//        10:06:35.792 [pool-1-thread-5] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 4
//        10:06:36.793 [pool-1-thread-6] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 5
//        10:06:37.793 [pool-1-thread-7] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 6
//        10:06:38.793 [pool-1-thread-8] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 7
//        10:06:39.794 [pool-1-thread-9] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 8
//        10:06:40.795 [pool-1-thread-10] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 9
//        10:06:41.795 [pool-1-thread-11] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 10
//        10:06:42.796 [pool-1-thread-12] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 11
//        10:06:43.797 [pool-1-thread-13] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 12
//        10:06:44.797 [pool-1-thread-14] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 13
//        10:06:45.797 [pool-1-thread-15] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 14
//        10:06:46.798 [pool-1-thread-16] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 15
//        10:06:47.799 [pool-1-thread-17] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 16
//        10:06:48.799 [pool-1-thread-18] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 17
//        10:06:49.799 [pool-1-thread-19] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 18
//        10:06:50.800 [pool-1-thread-20] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample2 - 19
    }


    private static void test(int  threadNum) throws InterruptedException {
//        Thread.sleep(100);
        log.error("{}",threadNum);
        Thread.sleep(1000);
    }
}
