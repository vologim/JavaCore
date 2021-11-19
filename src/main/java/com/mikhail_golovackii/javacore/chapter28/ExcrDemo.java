
package com.mikhail_golovackii.javacore.chapter28;

import java.util.concurrent.Exchanger;


public class ExcrDemo {
    public static void main(String[] args) {
        Exchanger<String> exgr = new Exchanger<>();
        
        new UseString(exgr);
        new MakeString(exgr);
    }
}

class MakeString implements Runnable{
    Exchanger<String> ex;
    String str;

    public MakeString(Exchanger<String> ex) {
        this.ex = ex;
        this.str = str;
        new Thread(this).start();
    }
    
    public void run(){
        char ch = 'A';
        
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 5; j++){
                str += (char) ch++;
            }
            try {
                str = ex.exchange(str);
            } 
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class UseString implements Runnable{
    Exchanger<String> ex;
    String str;

    public UseString(Exchanger<String> ex) {
        this.ex = ex;
        new Thread(this).start();
    }
    
    public void run(){
        for (int i = 0; i < 3; i++){
            
            try {
                str = ex.exchange(new String());
                System.out.println("Получено: " + str);
            } 
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}