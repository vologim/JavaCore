
package com.mikhail_golovackii.javacore.chapter15;

interface MyFunc<R, T> {
    R func(T t);
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

class MyClass2 {
    String str;

    public MyClass2() {
        str = "";
    }

    public MyClass2(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
        
}

public class ConstructorRefDemo3 {
    static <R, T> R myClassFactory(MyFunc<R, T> cons, T v){
        return cons.func(v);
    }
    
    public static void main(String[] args) {
        MyFunc<MyClass<Double>, Double> myClassCons = MyClass<Double>::new;
        MyClass<Double> mc = myClassFactory(myClassCons, 100.1);
        System.out.println(mc.getVal());
        
        MyFunc<MyClass2, String> myClassCons2 = MyClass2::new;
        MyClass2 mc2 = myClassFactory(myClassCons2, "Hello");
        System.out.println(mc2.getStr());
    }
}
