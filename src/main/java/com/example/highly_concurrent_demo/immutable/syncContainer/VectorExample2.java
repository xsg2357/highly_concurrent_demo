package com.example.highly_concurrent_demo.immutable.syncContainer;

import com.example.highly_concurrent_demo.annoations.NotThreadSafe;

import java.util.Vector;
@NotThreadSafe
public class VectorExample2 {

    private static Vector<Integer> set = new Vector<>();

    public static void main(String[] args) {
//        ArrayIndexOutOfBoundsException: Array index out of range: 12

        while (true){
            for (int i = 0; i <10 ; i++) {
                set.add(i);
            }
            Thread thread1 = new Thread(() -> {
                for (int i = 0; i <set.size() ; i++) {
                    set.remove(i);
                }
            });
            Thread thread2 = new Thread(() -> {
                for (int i = 0; i <set.size() ; i++) {
                    set.get(i);
                }
            });

            thread1.start();
            thread2.start();
        }

    }

}
