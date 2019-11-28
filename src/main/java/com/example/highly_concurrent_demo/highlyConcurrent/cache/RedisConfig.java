package com.example.highly_concurrent_demo.highlyConcurrent.cache;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisConfig {


    @Bean(name = "redisPool")
    public JedisPool jedisPool(@Value("${jedis.host}")String host,@Value("${jedis.port}")int port,
                               @Value("${jedis.password}")String pwd){

        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();

        return new JedisPool(genericObjectPoolConfig,host,port,20*1000,pwd);

    }


}
