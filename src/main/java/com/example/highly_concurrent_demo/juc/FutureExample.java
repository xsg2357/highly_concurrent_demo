package com.example.highly_concurrent_demo.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureExample {

    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            log.error("do something call main MyCallable...");
            Thread.sleep(5000);
            return "Done";
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        log.error("do something call main main method...");
        try {
            Thread.sleep(2000);
            String result = future.get();
            log.error("do something result = {}",result);
//            09:42:24.550 [main] ERROR com.example.highly_concurrent_demo.juc.FutureExample - do something call main main method...
//            09:42:24.550 [pool-1-thread-1] ERROR com.example.highly_concurrent_demo.juc.FutureExample - do something call main MyCallable...
//            09:42:29.562 [main] ERROR com.example.highly_concurrent_demo.juc.FutureExample - do something result = Done
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

}
