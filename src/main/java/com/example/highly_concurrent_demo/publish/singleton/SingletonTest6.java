package com.example.highly_concurrent_demo.publish.singleton;

import com.example.highly_concurrent_demo.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 第一次使用对象时创建实例 类加载时创建
 *  资源浪费
 */
@ThreadSafe
public class SingletonTest6 {

    private SingletonTest6() {
        //私有构造对象
    }

    // 单例对象
    private static SingletonTest6 instance;

    static {//静态款初始化 一定要声明 再在静态代码块里面初始化
        instance = new SingletonTest6();
    }

    //静态工厂方法
    public static SingletonTest6 getInstance() {

        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
//        980546781
//        980546781
    }

}
