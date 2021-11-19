
package com.mikhail_golovackii.javacore.chapter11;

public class MultiThreadDemo {
    public static void main(String[] args) {
        new MyThread("One");
        new MyThread("Two");
        new MyThread("Three");
        
        try {
            Thread.sleep(10_000);
        } 
        catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
}

class MyThread implements Runnable {
    
    String name;
    Thread t;

    public MyThread(String name) {
        this.name = name;
        this.t = new Thread(this, name);
        System.out.println("New thread: " + t);
        t.start();
    }
    
    public void run(){
        try {
            for (int i = 5; i > 0; i--){
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } 
        catch (InterruptedException e) {
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен");
    }
}
