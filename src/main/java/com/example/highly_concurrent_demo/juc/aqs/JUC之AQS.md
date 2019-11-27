# AbstractQueuedSynchronizer - AQS
![image](https://github.com/xsg2357/highly_concurrent_demo/blob/master/src/main/java/com/example/highly_concurrent_demo/juc/aqs/aqs_1.png?raw=true)
* 使用Node实现FIFO队列,可以用于构建锁或者其他同步装置的
基础框架
* 利用了一 个int类型表示状态
* 使用方法是继承
* 子类通过继承并通过实现它的方法管理其状态{ acquire和
release }的方法操纵状态
* 可以同时实现排它锁和共享锁模式(独占、共享)
* CountDownLatch
* Semaphore
* CyclicBarrier
* ReentrantLock
* Condition
* FutureTask

![image](https://github.com/xsg2357/highly_concurrent_demo/blob/master/src/main/java/com/example/highly_concurrent_demo/juc/aqs/aqs_2.png?raw=true)
![image](https://github.com/xsg2357/highly_concurrent_demo/blob/master/src/main/java/com/example/highly_concurrent_demo/juc/aqs/aqs_3.png?raw=true)
![image](https://github.com/xsg2357/highly_concurrent_demo/blob/master/src/main/java/com/example/highly_concurrent_demo/juc/aqs/aqs_4.png?raw=true)

## ReentrantLock与锁
### ReentrantLock (可重入锁)和synchronized区别
* 可重入性
* 锁的实现
* 性能的区别
* 功能区别

### ReentrantLock独有的功能
* 可指定是公平锁还是非公平锁
* 提供了一个Condition类 ,可以分组唤醒需要唤醒的线程
* 提供能够中断等待锁的线程的机制 ，lock.lockInterruptibly)