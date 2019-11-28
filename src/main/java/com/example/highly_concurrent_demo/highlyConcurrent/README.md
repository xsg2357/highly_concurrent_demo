## 扩容
* 垂直扩容(纵向扩展) :提高系统部件能力
* 水平扩容(横向扩展) : 增加更多系统成员来实现

### 扩容-数据库
* 读操作扩展: memcache、redis、 CDN等缓存
* 写操作扩展: Cassandra、Hbase等

### 缓存特征
* 命中率:命中数/(命中数+没有命中数)
* 最大元素(空间)
* 清空策略:FIFO(先进先出),LFU,LRU,过期时间,随机等

### 缓存命中率影响因素
* 业务场景和业务需求
* 缓存的设计(粒度和策略)
* 缓存容量和基础设施

### 缓存应用方式
* 本地缓存:编程实现(成员变量、局部变量、静态变量)
   Guava Cache
* 分布式缓存: Memcache、Redis片

## 高并发场景下缓存常见问题
* 缓存一致性
![image](https://github.com/xsg2357/highly_concurrent_demo/blob/master/src/main/java/com/example/highly_concurrent_demo/highlyConcurrent/ch01.png?raw=true)
* 缓存并发问题
![image](https://github.com/xsg2357/highly_concurrent_demo/blob/master/src/main/java/com/example/highly_concurrent_demo/highlyConcurrent/ch02.png?raw=true)
* 缓存穿透问题 缓存空对象、单独过滤处理、
![image](https://github.com/xsg2357/highly_concurrent_demo/blob/master/src/main/java/com/example/highly_concurrent_demo/highlyConcurrent/ch03.png?raw=true)
* 缓存的雪崩现象
![image](https://github.com/xsg2357/highly_concurrent_demo/blob/master/src/main/java/com/example/highly_concurrent_demo/highlyConcurrent/ch04.png?raw=true)
