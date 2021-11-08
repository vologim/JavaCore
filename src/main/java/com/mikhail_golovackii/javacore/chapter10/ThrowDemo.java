
package com.mikhail_golovackii.javacore.chapter10;

public class ThrowDemo {
    static void demoproc(){
        try {
            throw new NullPointerException("демонстрация");
        } 
        catch (NullPointerException e) {
            System.out.println("Исключение перехвачено в demoproc");
            throw e;
        }
    }
    
    public static void main(String[] args) {
        try {
            demoproc();
        } 
        catch (NullPointerException e) {
            System.out.println("Повторный перехват: " + e);
        }
    }
}
