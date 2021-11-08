
package com.mikhail_golovackii.javacore.chapter10;

public class ThrowsDemo {
    static void throwOne() throws IllegalAccessException {
        System.out.println("В теле метода throwOne");
        throw new IllegalAccessException("демо");
    }
    
    public static void main(String[] args) {
        try {
            throwOne();
        } 
        catch (IllegalAccessException e) {
            System.out.println("Перехвачено исключение: " + e);
        }
        
    }
}
