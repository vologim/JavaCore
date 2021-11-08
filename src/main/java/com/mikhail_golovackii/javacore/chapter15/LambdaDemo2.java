
package com.mikhail_golovackii.javacore.chapter15;

interface NumericTest {
    boolean test(int i);
}

public class LambdaDemo2 {

    public static void main(String[] args) {
        NumericTest isEven = (n) -> (n % 2) == 0;
        
        if(isEven.test(10)){
            System.out.println("Четное число");
        }
        if(!isEven.test(9)){
            System.out.println("Нечетное число");
        }
        
        NumericTest isNonNeg = (n) -> n >= 0;
        
        if(isNonNeg.test(1)){
            System.out.println("Положительное число");
        }
        if(!isNonNeg.test(-2)){
            System.out.println("Отрицательное число");
        }
    }
}
