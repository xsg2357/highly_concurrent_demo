package com.example.highly_concurrent_demo.example.atomic;

import com.example.highly_concurrent_demo.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicIntegerFieldUpdater的介绍
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;

//    private  static  AtomicExample5 atomicExample5 = new AtomicExample5();
// update success 1 120
//- update failed 2 120

    public static void main(String[] args) {
        AtomicExample5 atomicExample5 = new AtomicExample5();
        if (updater.compareAndSet(atomicExample5, 100, 120)) {
            log.info("update success 1 {}", atomicExample5.getCount());
        }
        if (updater.compareAndSet(atomicExample5, 100, 120)) {
            log.info("update success 2 {}", atomicExample5.getCount());
        } else {
            log.info("update failed 2 {}", atomicExample5.getCount());
        }
// update success 1 120
//- update failed 2 120

    }

}
