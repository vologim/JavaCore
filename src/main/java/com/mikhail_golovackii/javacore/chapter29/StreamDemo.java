
package com.mikhail_golovackii.javacore.chapter29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(12);
        list.add(444);
        list.add(-92);
        list.add(0);
        list.add(5);
        list.add(35);
        list.add(53);
        list.add(-999);
        
        System.out.println("Ихсодный список: " + list);
        
        Stream<Integer> stream = list.stream();
        Optional<Integer> minVal = stream.min(Integer::compare);
        if(minVal.isPresent()){
            System.out.println("min " + minVal.get());
        }
        
        stream = list.stream();
        Optional<Integer> maxVal = stream.max(Integer::compare);
        if(maxVal.isPresent()){
            System.out.println("max " + maxVal.get());
        }
        
        System.out.println("Сортировка: ");
        list.stream().sorted().forEach(n -> System.out.println(n));
        
        
        System.out.println("Нечетные числа: ");
        list.stream().sorted()
                .filter(n -> (n % 2) == 1)
                .forEach(element -> System.out.println(element));
        
        System.out.println("Нечетные числа больше 5");
        list.stream().sorted()
                .filter(el -> (el % 2) == 1)
                .filter(el -> el > 5)
                .forEach(el -> System.out.println(el));
    }
}
