
package com.mikhail_golovackii.javacore.chapter29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class StreamDemo6 {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        Collections.addAll(list, 1.2, 0.3, -99.2, 100.2, 13.3);
        
        System.out.println("Данные list:");
        list.forEach(elem -> System.out.println(elem));
        
        IntStream intStream = list.stream().mapToInt(elem -> (int) Math.ceil(elem));
        
        System.out.println("Допустимые пределы значений:");
        intStream.forEach(el -> System.out.println(el));
    }
}
