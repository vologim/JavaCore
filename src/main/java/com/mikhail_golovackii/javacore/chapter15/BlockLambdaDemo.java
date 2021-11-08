
package com.mikhail_golovackii.javacore.chapter15;

interface NumericFunc {
    int func(int a);
}

public class BlockLambdaDemo {
    public static void main(String[] args) {
        NumericFunc factorial = (n) -> {
            int result = 1;
            for(int i = 1; i <= n; i++){
                result = i * result;
            }
            return result;
        };
        
        System.out.println("Факториал 3 = " + factorial.func(3));
        System.out.println("Факториал 5 = " + factorial.func(5));
    }
}
