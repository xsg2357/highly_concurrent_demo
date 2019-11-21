package com.example.highly_concurrent_demo.immutable;

import com.example.highly_concurrent_demo.annoations.ThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * unmodifiableMap
 */
@Slf4j
@ThreadSafe
public class ImmutableTest2 {


    private static  Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(2,2);
        map.put(3,2);

//        java.lang.UnsupportedOperationException
        map =  Collections.unmodifiableMap(map);
    }


    public static void main(String[] args) {


        map.put(1,3);

        log.info("{}",map.get(1));

    }



}
