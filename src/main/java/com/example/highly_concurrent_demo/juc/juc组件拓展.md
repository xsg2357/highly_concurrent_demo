## FutureTask
* Callable 与Runnable接口对比
* Future 接口
* FutureTask类

## BlockingQueue
* ArrayBlockingQueue 基于数组实现,适合做有界队列，队列可容纳的最大元素需要在队列创建时指定
* DelayQueue  缓存系统的设计：使用DelayQueue保存缓存元素的有效期，使用一个线程循环查询DelayQueue，一旦能从DelayQueue中获取元素时，就表示有缓存到期了。 
              定时任务调度：使用DelayQueue保存当天要执行的任务和执行时间，一旦从DelayQueue中获取到任务就开始执行，比如Timer就是使用DelayQueue实现的。
* LinkedBlockingQueue 适合做无界队列，或者边界值非常大的队列，不会因为初值设置容量很大，吃掉很大的内存
* PriorityBlockingQueue 是一个支持优先级的无界阻塞队列。默认情况下元素采用自然顺序升序排列。也可以自定义类实现compareTo()方法来指定元素排序规则，或者初始化PriorityBlockingQueue时，指定构造参数Comparator来对元素进行排序。但需要注意的是不能保证同优先级元素的顺序。
* SynchronousQueue 没有容量，是无缓冲等待队列，是一个不存储元素的阻塞队列，会直接将任务交给消费者，必须等队列中的添加元素被消费后才能继续添加新的元素。