
package com.mikhail_golovackii.javacore.chapter15;

interface NumericTest3 {
    boolean test(int a, int b);
}

public class LambdaDemo3 {
    public static void main(String[] args) {
        NumericTest3 nt = (a, b) -> (a % b) == 0;
    
        if(nt.test(10, 2)){
            System.out.println("Число 2 является множителем числа 10");
        }
        
        if(!nt.test(10, 3)){
            System.out.println("Число 3 не является множителем числа 10");
        }
    }

}
