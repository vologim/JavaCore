
package com.mikhail_golovackii.javacore.chapter15;

interface MyNumber {
    double getValue();
}

public class LambdaDemo {
    public static void main(String[] args) {
        MyNumber myNumber;
        
        myNumber = () -> 123.12;
        System.out.println("Фиксированное значение: " + myNumber.getValue());
        
        myNumber = () -> Math.random() * 100;
        
        for(int i = 0; i < 5; i++){
            System.out.println(myNumber.getValue());
        }
    }
}
