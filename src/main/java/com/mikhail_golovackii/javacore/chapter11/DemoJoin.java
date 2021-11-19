
package com.mikhail_golovackii.javacore.chapter11;


public class DemoJoin {
    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("One");
        MyThread2 t2 = new MyThread2("Two");
        MyThread2 t3 = new MyThread2("Three");
        
        System.out.println("Поток One запущен: "
                + t1.t.isAlive());
        System.out.println("Поток Two запущен: "
                + t2.t.isAlive());
        System.out.println("Поток THree запущен: "
                + t3.t.isAlive());
        
        try {
            System.out.println("Ожидание завершение потоков");
            t1.t.join();
            t2.t.join();
            t3.t.join();
        } 
        catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        
        System.out.println("Поток One запущен: "
                + t1.t.isAlive());
        System.out.println("Поток Two запущен: "
                + t2.t.isAlive());
        System.out.println("Поток THree запущен: "
                + t3.t.isAlive());
        
        System.out.println("Главный поток прерван");
    }   
}

class MyThread2 implements Runnable {
    
    String name;
    Thread t;

    public MyThread2(String name) {
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
