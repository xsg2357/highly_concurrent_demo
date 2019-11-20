package com.example.highly_concurrent_demo.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample2 {


    //synchronized修饰一个类
    public  void  test1(){
        synchronized (SynchronizedExample2.class){
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {} ",i);
            }
        }
    }
    public  void  test1(int j){
        synchronized (SynchronizedExample2.class){
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {} - {}  ",i,j);
            }
        }
    }

    //synchronized修饰静态方法
    public static synchronized  void  test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} - {} ",i,j);
        }
    }

    public static  synchronized  void  test2(){
        for (int i = 0; i < 10; i++) {

            log.info("test2 - {} ",i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 synchronizedExample1 = new SynchronizedExample2();
        SynchronizedExample2 synchronizedExample2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //lamda （对象名::方法名） == >无参数是调用synchronizedExample1的方法
        executorService.execute(synchronizedExample1::test1);
        executorService.execute(synchronizedExample2::test1);

        //lamda （SynchronizedExample2::方法名） == >无参数是调用synchronizedExample1的调用静态方法方法
        //        executorService.execute(synchronizedExample1::test2);
//        executorService.execute(synchronizedExample2::test2);
        executorService.execute(SynchronizedExample2::test2);

        executorService.execute(() -> synchronizedExample1.test1(1));
        executorService.execute(() -> SynchronizedExample2.test2(1));

        executorService.execute(() -> synchronizedExample2.test1(1));
//        executorService.execute(() -> synchronizedExample2.test2(1));
    }
}
