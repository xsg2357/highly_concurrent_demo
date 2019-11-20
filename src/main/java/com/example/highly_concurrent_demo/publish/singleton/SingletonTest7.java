package com.example.highly_concurrent_demo.publish.singleton;

import com.example.highly_concurrent_demo.annoations.RecommenThreadSafe;
import com.example.highly_concurrent_demo.annoations.ThreadSafe;

/**
 * 枚举模式 是最安全的
 */
@ThreadSafe
@RecommenThreadSafe
public class SingletonTest7 {

    public SingletonTest7() {

    }

    public static SingletonTest7 getInstance() {

        return Singleton.INSTANCE.getInstance();
    }

    private  enum  Singleton{
        INSTANCE,
        ;

        //JVM方法保证绝对调用一次
        private    SingletonTest7 singleton;


        Singleton() {
            singleton = new SingletonTest7();
        }

        public  SingletonTest7 getInstance() {
            return singleton;
        }
    }
}
