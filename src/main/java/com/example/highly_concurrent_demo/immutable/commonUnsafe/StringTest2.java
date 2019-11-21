package com.example.highly_concurrent_demo.immutable.commonUnsafe;

import com.example.highly_concurrent_demo.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//stringBuffer 计算比StringBuilder计算速度慢 局部使用时推荐使用StringBuilder
@Slf4j
@ThreadSafe
public class StringTest2 {

    //请求总数
    public static  int  clientTotal = 5000;

    //同时并发执行的线程数
    public static  int  threadTotal = 200;

    private static  StringBuffer  stringBuffer = new StringBuffer();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i <clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
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
        log.info("size:{}",stringBuffer.length());

    }

    private  static  void  update(){
        stringBuffer.append("1");
    }
}
