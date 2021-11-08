
package com.mikhail_golovackii.javacore.chapter29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        Collections.addAll(list, 1.0, 2.0, 4.0, 99.0, 13.0, 1313.0);
        
        Stream<Double> sqrt = list.stream().map(a -> Math.sqrt(a));
        
        double resultSqrt = sqrt.reduce(1.0, (a, b) -> a * b);
        
        System.out.println(resultSqrt);
    }
}
