package com.example.highly_concurrent_demo.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolExample4 {

    public static void main(String[] args) {
        ScheduledExecutorService executorService  = Executors.newScheduledThreadPool(5);
//        for (int i = 0; i < 10 ; i++) {
//            int finalI = i;
//            executorService.execute(() -> log.error("thread {} ", finalI));
//        }
//        executorService.schedule(() -> log.error("thread schedule"),3, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(() -> log.error("thread scheduleAtFixedRate"),1,3, TimeUnit.SECONDS);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.error("timer schedule");
            }
        },new Date(),5000);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                log.error("timer schedule");
            }
        },new Date(),5000);
        executorService.shutdown();
    }

//16:17:14.472 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample4 - thread 0
//            16:17:14.472 [pool-1-thread-5] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample4 - thread 3
//            16:17:14.487 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample4 - thread 5
//            16:17:14.488 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample4 - thread 6
//            16:17:14.472 [pool-1-thread-2] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample4 - thread 1
//            16:17:14.488 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample4 - thread 7
//            16:17:14.472 [pool-1-thread-3] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample4 - thread 4
//            16:17:14.472 [pool-1-thread-4] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample4 - thread 2
//            16:17:14.488 [pool-1-thread-2] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample4 - thread 9
//            16:17:14.488 [pool-1-thread-5] ERROR com.example.highly_concurrent_demo.threadpool.ThreadPoolExample4 - thread 8
}
