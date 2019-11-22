package com.example.highly_concurrent_demo.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample1 {

    private static final int  threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore  semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final  int threadNum = i;
            executorService.execute(()->{
                try {
                    semaphore.acquire(); //获取一个许可
                    test(threadNum);
                    semaphore.release(); //释放一个许可
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    log.error("parse:{}",e.getMessage());
                }
            });
        }
        log.error("finish");
        executorService.shutdown();
//        10:04:05.796 [pool-1-thread-2] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 1
//        10:04:05.796 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 0
//        10:04:05.796 [main] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - finish
//        10:04:05.796 [pool-1-thread-3] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 2
//        10:04:06.808 [pool-1-thread-4] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 3
//        10:04:06.808 [pool-1-thread-7] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 6
//        10:04:06.808 [pool-1-thread-6] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 5
//        10:04:07.808 [pool-1-thread-5] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 4
//        10:04:07.808 [pool-1-thread-8] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 7
//        10:04:07.809 [pool-1-thread-9] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 8
//        10:04:08.809 [pool-1-thread-11] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 10
//        10:04:08.809 [pool-1-thread-10] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 9
//        10:04:08.810 [pool-1-thread-12] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 11
//        10:04:09.809 [pool-1-thread-14] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 13
//        10:04:09.809 [pool-1-thread-13] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 12
//        10:04:09.810 [pool-1-thread-15] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 14
//        10:04:10.809 [pool-1-thread-16] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 15
//        10:04:10.810 [pool-1-thread-19] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 18
//        10:04:10.810 [pool-1-thread-18] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 17
//        10:04:11.810 [pool-1-thread-17] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 16
//        10:04:11.811 [pool-1-thread-20] ERROR com.example.highly_concurrent_demo.aqs.SemaphoreExample1 - 19
    }


    private static void test(int  threadNum) throws InterruptedException {
//        Thread.sleep(100);
        log.error("{}",threadNum);
        Thread.sleep(1000);
    }
}
