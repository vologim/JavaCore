
package com.mikhail_golovackii.javacore.chapter10;

public class MultiCatch {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int vals[] = { 1, 2, 3 };
        
        try {
            int result = a / b;
            vals[10] = 19;
        } 
        catch (ArithmeticException | ArrayIndexOutOfBoundsException ex) {
            System.out.println("Исключение перехвачено: " + ex);
        }
        System.out.println("После многократного перехвата");
    }
}
