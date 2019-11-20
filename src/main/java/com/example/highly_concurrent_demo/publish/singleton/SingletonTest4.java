package com.example.highly_concurrent_demo.publish.singleton;

import com.example.highly_concurrent_demo.annoations.NotThreadSafe;

/**
 * 懒汉模式
 * 第一次使用对象时创建实例
 *  性能开销
 */
@NotThreadSafe
public class SingletonTest4 {

    private SingletonTest4() {
        //私有构造对象
    }

    // 单例对象
    private static SingletonTest4 instance = null;

    //分布对象内存空间 1 mem = alloc
    //初始化对象 2  instance = mem
    //设置instance指向的分布内存 3 ctorInstance

    //会发生的情况
    //JVM和cpu发生了指令重排 1 3 2

    //静态工厂方法
    public static synchronized SingletonTest4 getInstance() {

        if (instance == null){//双重监测机制
            synchronized (SingletonTest4.class){//同步锁
                if (instance == null){
                    instance = new SingletonTest4();
                }
            }
        }

        return instance;
    }

}
