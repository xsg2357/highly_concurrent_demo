package com.example.highly_concurrent_demo.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadPoolExample1 {

    public static void main(String[] args) {
        ExecutorService executorService  = Executors.newCachedThreadPool();
        for (int i = 0; i < 10 ; i++) {
            int finalI = i;
            executorService.execute(() -> log.error("thread {} ", finalI));
        }
        executorService.shutdown();
//        16:15:40.711 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample1 - thread 0
//        16:15:40.711 [pool-1-thread-8] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample1 - thread 7
//        16:15:40.711 [pool-1-thread-3] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample1 - thread 2
//        16:15:40.711 [pool-1-thread-7] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample1 - thread 6
//        16:15:40.711 [pool-1-thread-9] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample1 - thread 8
//        16:15:40.711 [pool-1-thread-4] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample1 - thread 3
//        16:15:40.711 [pool-1-thread-10] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample1 - thread 9
//        16:15:40.711 [pool-1-thread-5] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample1 - thread 4
//        16:15:40.711 [pool-1-thread-6] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample1 - thread 5
//        16:15:40.711 [pool-1-thread-2] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample1 - thread 1

    }


}
