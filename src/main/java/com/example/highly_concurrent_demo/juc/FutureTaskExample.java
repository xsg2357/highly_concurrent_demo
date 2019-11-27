package com.example.highly_concurrent_demo.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class FutureTaskExample {

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            log.error("do something call main FutureTask...");
            Thread.sleep(5000);
            return "Done";
        });
        new Thread(futureTask).start();
        log.error("do something call main main method...");
        try {
            Thread.sleep(3000);
            String result = futureTask.get();
            log.error("do something result = {}",result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
//        09:48:21.439 [main] ERROR com.example.highly_concurrent_demo.juc.FutureTaskExample - do something call main main method...
//        09:48:21.439 [Thread-0] ERROR com.example.highly_concurrent_demo.juc.FutureTaskExample - do something call main FutureTask...
//        09:48:26.452 [main] ERROR com.example.highly_concurrent_demo.juc.FutureTaskExample - do something result = Done
    }

}
