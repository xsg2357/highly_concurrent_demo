package com.example.highly_concurrent_demo.immutable.syncContainer;

import com.example.highly_concurrent_demo.annoations.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;

@NotThreadSafe
public class VectorExample3 {

//    ConcurrentModificationException vector不行 换成List等普通容器也不行
    private static  void  test1(Vector<Integer> v1){
        for (Integer i:
             v1) {
            if (i ==3) {
                v1.remove(i);
            }
        }
    }

    //    ConcurrentModificationException
    private static  void  test2(Vector<Integer> v1){
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            v1.remove(i);
        }

    }

    private static  void  test3(Vector<Integer> v1){
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(3)) {
                v1.remove(i);
            }
        }
    }


    public static void main(String[] args) {
//        ArrayIndexOutOfBoundsException: Array index out of range: 12

        Vector<Integer> set = new Vector<>();
        set.add(1);
        set.add(2);
        set.add(3);


        test1(set);
        test2(set);
        test3(set);

    }

}
