
package com.mikhail_golovackii.javacore.chapter28;

import java.util.concurrent.Phaser;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int curPhaser;
        
        System.out.println("Запуск потоков");
        
        new MyThread2(phaser, "A");
        new MyThread2(phaser, "B");
        new MyThread2(phaser, "C");
        
        curPhaser = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhaser + " завершена");
        
        curPhaser = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhaser + " завершена");
        
        curPhaser = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhaser + " завершена");
        
        phaser.arriveAndDeregister();
        
        if (phaser.isTerminated()){
            System.out.println("Синхронизатор фаз завершен");
        }
    }
}

class MyThread2 implements Runnable{
    Phaser phaser;
    String str;

    public MyThread2(Phaser phaser, String str) {
        this.phaser = phaser;
        this.str = str;
        phaser.register();
        new Thread(this).start();
    }
    
    public void run(){
        System.out.println("Поток " + str + " начинает первую фазу");
        phaser.arriveAndAwaitAdvance();
        
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        
        System.out.println("Поток " + str + " начинает вторую фазу");
        phaser.arriveAndAwaitAdvance();
        
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        
        System.out.println("Поток " + str + " начинает третью фазу");
        phaser.arriveAndAwaitAdvance();

    }
}
