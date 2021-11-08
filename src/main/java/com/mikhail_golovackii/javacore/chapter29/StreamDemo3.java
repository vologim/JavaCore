
package com.mikhail_golovackii.javacore.chapter29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StreamDemo3 {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        Collections.addAll(list, 1.0, 2.0, 4.0, 99.0, 13.0, 1313.0);
        
        double result = list.parallelStream()
                .reduce(1.0, (a, b) -> a * Math.sqrt(b),
                             (a, b) -> a * b);
        
        System.out.println("ПРоизведение квадратных корней: " + result);
    }
}
