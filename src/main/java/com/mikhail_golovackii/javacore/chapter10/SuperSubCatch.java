
package com.mikhail_golovackii.javacore.chapter10;

public class SuperSubCatch {
    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 42 / a;
        } 
        catch (Exception e) {
            System.out.println("Перехват исключений");
        }
//        catch (ArithmeticException ex){
//            System.out.println("Этот код никогда не сработает");
//        }
    }
}
