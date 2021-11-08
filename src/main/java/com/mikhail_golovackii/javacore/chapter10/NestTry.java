
package com.mikhail_golovackii.javacore.chapter10;

public class NestTry {
    public static void main(String[] args) {
        try {
            int a = args.length;
            int b = 42 / a;
            
            System.out.println("a = " + a);
            
            try {
                if(a == 1){
                    a = a / (a - a);
                }
                if(a == 2){
                    int c[] = { 1 };
                    c[42] = 99;
                }
            }
            catch (ArrayIndexOutOfBoundsException ex){
                System.out.println("Индекс за пределами массива: " + ex);
            }
        } 
        catch (ArithmeticException ex) {
            System.out.println("Деление на 0: " + ex);
        }
    }
}
