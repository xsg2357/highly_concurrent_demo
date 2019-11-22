package com.example.highly_concurrent_demo.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierExample2 {

    //高速线程5个线程 同步等待
    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final  int threadNum = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(()->{
                try {

                    race(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    private static void race(int  threadNum) throws Exception {
        Thread.sleep(1000);
        log.error("{} is ready ",threadNum);

        try {

            barrier.await(2000,TimeUnit.MILLISECONDS); //线程ok了
//        }catch (BrokenBarrierException | TimeoutException e){
        }catch (Exception e){
            log.error("exception:",e);
        }
        log.error("{} continue ",threadNum);
    }


}
