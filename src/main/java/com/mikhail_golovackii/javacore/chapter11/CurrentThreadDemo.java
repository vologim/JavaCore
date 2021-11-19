
package com.mikhail_golovackii.javacore.chapter11;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        
        System.out.println("This is currenThread: " + t);
        
        t.setName("MyThread");
        System.out.println("New name id currentThread: " + t);
        
        try {
            for(int i = 5; i > 0; i--){
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Поток прерван");
        }
    }
}
