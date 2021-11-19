
package com.mikhail_golovackii.javacore.chapter28;

import java.util.concurrent.locks.ReentrantLock;


public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        
        new LockThread(reentrantLock, "A");
        new LockThread(reentrantLock, "B");
    }
}

class Shared{
    static int count = 0;
}

class LockThread implements Runnable{
    ReentrantLock lock;
    String name;

    public LockThread(ReentrantLock lock, String name) {
        this.lock = lock;
        this.name = name;
        new Thread(this).start();
    }
    
    public void run(){
        System.out.println("Запуск потока");
        
        try {
            System.out.println("Поток " + name + " ожидает блокировки счетчика");
            lock.lock();
            System.out.println("Поток " + name + " блокирует счетчик");
            Shared.count++;
            System.out.println("Поток " + name + ": " + Shared.count);
            
            System.out.println("Поток " + name + " ожидает");
            Thread.sleep(1000);
            
        } 
        catch (InterruptedException e) {
            System.out.println(e);
        }
        finally{
            System.out.println("Поток " + name + " разблокирует счетчик");
            lock.unlock();
        }
    }
}