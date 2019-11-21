package com.example.highly_concurrent_demo.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImmutableTest3 {

    private  final static ImmutableList<Integer> list = ImmutableList.of(1,2,3);
    private  final static ImmutableSet<Integer> set = ImmutableSet.copyOf(list);
    private  final static ImmutableMap<Integer,Integer> map1 = ImmutableMap.of(1,2);
    private  final static ImmutableMap<Integer,Integer> map2 =
            ImmutableMap.<Integer,Integer>builder().put(1,2).put(2,4).build();;


    public static void main(String[] args) {
        // ImmutableList ImmutableSet 的add方法不推荐使用 UnsupportedOperationException
        // ImmutableMap 的put方法不推荐使用 UnsupportedOperationException
        log.info("{}",set.toString());
        log.info("{}",map1.get(1));
        log.info("{}",map2.get(1));
//        [1, 2, 3]
//        2
//        2
    }

}
