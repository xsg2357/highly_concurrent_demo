package com.example.highly_concurrent_demo.controller;

import com.example.highly_concurrent_demo.highlyConcurrent.cache.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private RedisClient redisClient;

    @RequestMapping("/set")
    @ResponseBody
    public String set(@RequestParam("k")String key,@RequestParam("v")String value) throws  Exception{
        redisClient.set(key,value);
        return "SUCCESS";
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(@RequestParam("k")String key) throws  Exception{
        return redisClient.get(key);
    }

}
