package com.example.highly_concurrent_demo.aqs.lock;

import com.example.highly_concurrent_demo.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock de 用法
 */
@Slf4j
@ThreadSafe
public class LockExample3 {

    private final Map<String,Data> map = new Hashtable<>();

    private  static  final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    class Data{

    }

    public  Data get(String key){
        readLock.lock();
        try{
            return  map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public Set<String> getAllKeys(String key){
        readLock.lock();
        try{
            return  map.keySet();
        }finally {
            readLock.unlock();
        }
    }

    public Data put(String key,Data value){
        writeLock.lock();
        try{
            return  map.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }

}
