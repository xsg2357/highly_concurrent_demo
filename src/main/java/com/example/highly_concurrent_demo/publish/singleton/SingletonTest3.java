package com.example.highly_concurrent_demo.publish.singleton;

import com.example.highly_concurrent_demo.annoations.NotRecommenThreadSafe;
import com.example.highly_concurrent_demo.annoations.NotThreadSafe;
import com.example.highly_concurrent_demo.annoations.ThreadSafe;

/**
 * 懒汉模式
 * 第一次使用对象时创建实例
 *  性能开销
 */
@ThreadSafe
@NotRecommenThreadSafe
public class SingletonTest3 {

    private SingletonTest3() {
        //私有构造对象
    }

    // 单例对象
    private static SingletonTest3 instance = null;

    //静态工厂方法
    public static synchronized  SingletonTest3  getInstance() {

        if (instance == null){
            instance = new SingletonTest3();
        }

        return instance;
    }

}
