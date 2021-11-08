
package com.mikhail_golovackii.javacore.chapter13;

public class Hypot {
    public static void main(String[] args) {
        double side1 = 3.0;
        double side2 = 4.0;
        double hypot;
        
        hypot = Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
        
        System.out.println("При заданной длине сторон " + side1 
        + " и " + side2 + " гипотенуза = " + hypot);
    }
}
