
package com.mikhail_golovackii.javacore.chapter29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 3, -1212, 1212, -1212, 55, 2, 1233, 938);
        
        Optional<Integer> optional = list.stream()
                .reduce((a, b) -> a * b);
        
        if(optional.isPresent()){
            System.out.println("Произведение типа Optional: " + optional.get());
        }
        
        int result = list.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Произведение типа int: " + result);
    }
}
