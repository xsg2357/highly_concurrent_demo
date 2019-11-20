package com.example.highly_concurrent_demo.publish.singleton;

import com.example.highly_concurrent_demo.annoations.NotThreadSafe;

/**
 * 懒汉模式
 * 第一次使用对象时创建实例
 */
@NotThreadSafe
public class SingletonTest1 {

    private SingletonTest1() {
        //私有构造对象
    }

    // 单例对象
    private static  SingletonTest1 instance = null;

    //静态工厂方法
    public static SingletonTest1 getInstance() {

        if (instance == null){
            instance = new SingletonTest1();
        }

        return instance;
    }

}
