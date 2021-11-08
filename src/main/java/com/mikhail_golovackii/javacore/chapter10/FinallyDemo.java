
package com.mikhail_golovackii.javacore.chapter10;

public class FinallyDemo {
    static void procA(){
        try {
            System.out.println("В теле метода procA");
            throw new RuntimeException("демонстрация");
        } 
        finally {
            System.out.println("finally в procA");
        }
    }
    
    static void procB(){
        try {
            System.out.println("В теле метода procB");
            return;
        } 
        finally {
            System.out.println("finally в procB");
        }
    }
    
    static void procC(){
        try {
            System.out.println("В теле метода procC");
        } 
        finally {
            System.out.println("finally в procC");
        }
    }
    
    public static void main(String[] args) {
        try {
            procA();
        } 
        catch (Exception e) {
            System.out.println("Исключение перехвачено: " + e);
        }
        procB();
        procC();
    }
}
