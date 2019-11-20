package com.example.highly_concurrent_demo.publish.singleton;

import com.example.highly_concurrent_demo.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 第一次使用对象时创建实例 类加载时创建
 *  资源浪费
 */
@ThreadSafe
public class SingletonTest2 {

    private SingletonTest2() {
        //私有构造对象
    }

    // 单例对象
    private static SingletonTest2 instance = new SingletonTest2();

    //静态工厂方法
    public static SingletonTest2 getInstance() {


        return instance;
    }

}
