
package com.mikhail_golovackii.javacore.chapter13;

public class NativeDemo {
    int i;
    
    public static void main(String[] args) {
        NativeDemo ob = new NativeDemo();
        ob.i = 10;
        
        System.out.println("Содержимое переменной ob.i перед вызовом "
                + "платформенно-ориентированного метода: " + ob.i);
        
        ob.test();
    }

    public native void test();
    
    static {
        System.out.println("NativeDemo");
    }
}
