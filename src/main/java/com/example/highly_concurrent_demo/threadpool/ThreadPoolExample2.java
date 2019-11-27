package com.example.highly_concurrent_demo.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadPoolExample2 {

    public static void main(String[] args) {
        ExecutorService executorService  = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10 ; i++) {
            int finalI = i;
            executorService.execute(() -> log.error("thread {} ", finalI));
        }
        executorService.shutdown();
//        16:16:17.263 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample2 - thread 0
//        16:16:17.263 [pool-1-thread-2] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample2 - thread 1
//        16:16:17.281 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample2 - thread 3
//        16:16:17.281 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample2 - thread 4
//        16:16:17.282 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample2 - thread 5
//        16:16:17.282 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample2 - thread 6
//        16:16:17.263 [pool-1-thread-3] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample2 - thread 2
//        16:16:17.282 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample2 - thread 7
//        16:16:17.282 [pool-1-thread-2] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample2 - thread 8
//        16:16:17.282 [pool-1-thread-3] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample2 - thread 9
    }


}
