
package com.mikhail_golovackii.javacore.chapter13;

public class MyClass {
    int a;
    int b;
    
    MyClass(int i, int j){
        a = i;
        b = j;
    }
    
    MyClass(int i){
        this(i, i);
    }
    
    MyClass(){
        this(99);
    }
    
    public static void main(String[] args) {
        MyClass m = new MyClass();
        
        System.out.println(m.a + " " + m.b);
    }
}
