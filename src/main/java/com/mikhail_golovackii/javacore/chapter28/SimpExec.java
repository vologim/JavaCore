
package com.mikhail_golovackii.javacore.chapter28;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SimpExec {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        CountDownLatch cdl1 = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        
        ExecutorService es = Executors.newFixedThreadPool(2);
        
        System.out.println("Запуск потоков");
        
        es.execute(new MyThread4(cdl, "A"));
        es.execute(new MyThread4(cdl1, "B"));
        es.execute(new MyThread4(cdl2, "C"));
        es.execute(new MyThread4(cdl3, "D"));
        
        try {
            cdl.await();
            cdl1.await();
            cdl2.await();
            cdl3.await();
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        
        es.shutdown();
        System.out.println("Завершение потоков");
    }
}

class MyThread4 implements Runnable{
    String name;
    CountDownLatch latch;

    public MyThread4(CountDownLatch latch, String name) {
        this.name = name;
        this.latch = latch;
        new Thread(this);
    }
    
    public void run(){
        for (int i = 0; i < 5; i++){
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}
