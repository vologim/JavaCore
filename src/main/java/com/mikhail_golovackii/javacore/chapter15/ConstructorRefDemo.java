
package com.mikhail_golovackii.javacore.chapter15;

interface MyFunc {
    MyClass func(int n);
}

class MyClass {
    private int val;

    public MyClass() {
        val = 0;
    }

    public MyClass(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
        
}

public class ConstructorRefDemo {
    public static void main(String[] args) {
        MyFunc myClassCons = MyClass::new;
        
        MyClass mc = myClassCons.func(100);
        
        System.out.println(mc.getVal());
    }
}
