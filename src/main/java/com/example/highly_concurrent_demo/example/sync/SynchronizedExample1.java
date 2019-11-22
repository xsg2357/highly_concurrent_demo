package com.example.highly_concurrent_demo.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//synchronized 同一时间只有一个线程调用
@Slf4j
public class SynchronizedExample1 {


    //synchronized修饰代码块 非公平锁 采用cas技术
    public  void  test1(){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {} ",i);
            }
        }
    }
    public  void  test1(int j){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {} ",i);
            }
        }
    }

    //synchronized修饰方法
    public  synchronized  void  test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} ",i);
        }
    }

    public  synchronized  void  test2(){
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} ",i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        SynchronizedExample1 synchronizedExample2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //lamda （对象名::方法名） == >无参数是调用synchronizedExample1的方法
        executorService.execute(synchronizedExample1::test1);
        executorService.execute(synchronizedExample2::test1);

        executorService.execute(synchronizedExample1::test2);
        executorService.execute(synchronizedExample2::test2);

        executorService.execute(() -> synchronizedExample1.test1(1));
        executorService.execute(() -> synchronizedExample1.test2(1));

        executorService.execute(() -> synchronizedExample2.test1(1));
        executorService.execute(() -> synchronizedExample2.test2(1));
    }
}
