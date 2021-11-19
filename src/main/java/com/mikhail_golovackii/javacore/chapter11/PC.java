
package com.mikhail_golovackii.javacore.chapter11;


public class PC {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}

class Q {
    int n;
    boolean valueSet = false;
    
    synchronized int get(){
        while (!valueSet){
            try {
                wait();
            } 
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            
            System.out.println("Получено: " + n);
            valueSet = false;
            notify();
            
        }
        return n;
    }
    
    synchronized void put(int n){
        while (valueSet){
            try {
                wait();
            } 
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            
            this.n = n;
            System.out.println("Отправлено: " + n);
            valueSet = true;
            notify();
            
        }
    }
}

class Producer implements Runnable{
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this, "Поставщик").start();
    }
    
    public void run(){
        int i = 0;
        while (true){
            q.put(i++);
        }
    }
}

class Consumer implements Runnable{
    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Потребитель").start();
    }
    
    public void run(){
        while (true){
            q.get();
        }
    }
    
    
}
