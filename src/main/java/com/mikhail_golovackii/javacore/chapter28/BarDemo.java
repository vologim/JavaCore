
package com.mikhail_golovackii.javacore.chapter28;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
        
        System.out.println("Запуск потоков");
        
        new MyThread1(cb, "A");
        new MyThread1(cb, "B");
        new MyThread1(cb, "C");
    }
}

class MyThread1 implements Runnable{
    CyclicBarrier cb;
    String name;

    public MyThread1(CyclicBarrier cb, String name) {
        this.cb = cb;
        this.name = name;
        new Thread(this).start();
    }
    
    public void run(){
        System.out.println(name);
        
        try {
            cb.await();
        } 
        catch (BrokenBarrierException e) {
            System.out.println(e);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
    }
}

class BarAction implements Runnable{
    public void run(){
        System.out.println("Барьер достигнут");
    }
}