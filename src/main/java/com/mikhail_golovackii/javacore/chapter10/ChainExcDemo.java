
package com.mikhail_golovackii.javacore.chapter10;

public class ChainExcDemo {
    static void demoproc(){
        RuntimeException ex = new NullPointerException("верхний уровень");
        ex.initCause(new ArithmeticException("причина"));
        
        throw ex;
    }
    
    public static void main(String[] args) {
        try {
            demoproc();
        } 
        catch (NullPointerException e) {
            System.out.println("Перехвачено искл: " + e);
            System.out.println("Первопричина: " + e.getCause());
        }
    }
}
