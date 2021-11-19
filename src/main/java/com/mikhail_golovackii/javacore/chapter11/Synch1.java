
package com.mikhail_golovackii.javacore.chapter11;


public class Synch1 {
    public static void main(String[] args) {
        Callme clCallme = new Callme();
        Caller obj1 = new Caller(clCallme, "Добро пожаловать");
        Caller obj2 = new Caller(clCallme, "в синхронизированный");
        Caller obj3 = new Caller(clCallme, "мир");
        
        try {
            obj1.t.join();
            obj2.t.join();
            obj3.t.join();
        } 
        catch (InterruptedException e) {
            System.out.println("Прервано");
        }
    }
}

class Callme {
    void call(String msg){
        System.out.println("[" + msg);
        
        try {
            Thread.sleep(1000);
        } 
        catch (InterruptedException e) {
            System.out.println("Прервано");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable{
    String msg;
    Callme target;
    Thread t;

    public Caller(Callme target, String msg) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
        t.start();
    }
    
    public void run(){
        
        synchronized(target){
            target.call(msg);
        }

    }
}