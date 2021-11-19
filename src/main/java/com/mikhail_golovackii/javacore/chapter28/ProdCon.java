
package com.mikhail_golovackii.javacore.chapter28;

import java.util.concurrent.Semaphore;


public class ProdCon {
    public static void main(String[] args) {
        Q q = new Q();
        
        new Consumer(q);
        new Producer(q);
        
    }
}

class Q {
    int n;
    
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semPRod = new Semaphore(1);
    
    void get(){
        
        try {
            semCon.acquire();
        } 
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Получено: " + n);
        
        semPRod.release();
    }
    
    void put(int n){
        try {
            semCon.acquire();
        } 
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        this.n = n;
        System.out.println("Отправлено: " + n);
        
        semPRod.release();
    }
}

class Producer implements Runnable{
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }
    
    public void run(){
        for (int i = 0; i < 20; i++){
            q.put(i);
        }
    }
}

class Consumer implements Runnable{
    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }
    
    public void run(){
        for (int i = 0; i < 20; i++){
            q.get();
        }
    }
    
    
}
