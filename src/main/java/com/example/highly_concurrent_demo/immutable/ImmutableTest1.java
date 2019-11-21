package com.example.highly_concurrent_demo.immutable;

import com.example.highly_concurrent_demo.annoations.NotThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * final的用法
 */
@Slf4j
@NotThreadSafe
public class ImmutableTest1 {

    public static final Integer a =1;
    public static final String b ="2";

    private static final Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(2,2);
        map.put(3,2);
    }


    public static void main(String[] args) {

//        a = 2;
//        b ="3";

//        map = new HashMap<>();

        map.put(1,3);

        log.info("{}",map.get(1));
//        3

    }

    private  void  test3(final int a){
//         a =3;
    }


}
