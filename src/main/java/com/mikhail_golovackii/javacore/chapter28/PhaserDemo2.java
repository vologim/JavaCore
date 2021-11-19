
package com.mikhail_golovackii.javacore.chapter28;

import java.util.concurrent.Phaser;

public class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser mp = new MyPhaser(1, 4);
        System.out.println("Запуск потоков");
        
        new MyThread3(mp, "A");
        new MyThread3(mp, "B");
        new MyThread3(mp, "C");
        
        while (!mp.isTerminated()){
            mp.arriveAndAwaitAdvance();
        }
        System.out.println("Синхронизатор фаз завершен");
    }
}

class MyPhaser extends Phaser{
    int numPhaser;

    public MyPhaser(int parties, int phaserCount) {
        super(parties);
        numPhaser = phaserCount - 1;
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("Фаза " + phase + " завершена");
        
        if (numPhaser == phase || registeredParties == 0){
            return true;
        }
        
        return false;
    }
}

class MyThread3 implements Runnable{
    Phaser phaser;
    String name;

    public MyThread3(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
        new Thread(this).start();
    }
    
    public void run(){
        while (!phaser.isTerminated()){
            System.out.println("Поток " + name + " начинает фазу: " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}
