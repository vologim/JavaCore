
package com.mikhail_golovackii.javacore.chapter15;

interface MyFunc<T> {
    MyClass<T> func(T n);
}

class MyClass<T> {
    private T val;

    public MyClass() {
        val = null;
    }

    public MyClass(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }
        
}

public class ConstructorRefDemo2 {
    public static void main(String[] args) {
        MyFunc<Integer> myClassCons = MyClass<Integer>::new;
        
        MyClass<Integer> mc = myClassCons.func(50);
        
        System.out.println(mc.getVal());
    }
}
