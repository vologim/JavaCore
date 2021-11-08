
package com.mikhail_golovackii.javacore.chapter13;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Hypot2 {
    public static void main(String[] args) {
        double side1 = 3.0;
        double side2 = 4.0;
        double hypot;
        
        hypot = sqrt(pow(side1, 2) + pow(side2, 2));
        
        System.out.println("При заданной длине сторон " + side1 
        + " и " + side2 + " гипотенуза = " + hypot);
    }
}
    
