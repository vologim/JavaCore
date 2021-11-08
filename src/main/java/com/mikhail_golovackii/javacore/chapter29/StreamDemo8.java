
package com.mikhail_golovackii.javacore.chapter29;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo8 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Альфа");
        list.add("Бета");
        list.add("Гамма");
        list.add("Дельта");
        list.add("Кси");
        list.add("Омега");
        
        Stream<String> stream = list.stream();
        
        Iterator<String> itr = stream.iterator();
        
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
