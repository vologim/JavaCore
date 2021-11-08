
package com.mikhail_golovackii.javacore.chapter15;

interface MyFunc<T> {
    int func(T[] vals, T v);
}

class MyArraysOps {
    static <T> int countMatching(T[] vals, T v){
        int count = 0;
        for(int i = 0; i < vals.length; i++){
            if(vals[i] == v){
                count++;
            }
        }
        return count;
    }
}

public class GenericMethodRefDemo {
    static <T> int myOp(MyFunc<T> f, T[] vals, T v){
        return f.func(vals, v);
    }
    
    public static void main(String[] args) {
        Integer[] vals = { 1, 2, 3, 4, 2, 3, 4, 4, 5 }; 
        String[] str = { "One", "Two", "Three", "Two" };
        int count;
        
        count = myOp(MyArraysOps::<Integer>countMatching, vals, 4);
        System.out.println("Массив содержит " + count + " числа 4");
        
        count = myOp(MyArraysOps::<String>countMatching, str, "Two");
        System.out.println("Массив содержит " + count + " Two");
    }
}
