
package com.mikhail_golovackii.javacore.chapter29;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class StreamDemo9 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Альфа");
        list.add("Бета");
        list.add("Гамма");
        list.add("Дельта");
        list.add("Кси");
        list.add("Омега");
        
        Spliterator<String> spliterator = list.spliterator();
        
        spliterator.forEachRemaining(n -> System.out.println(n));
    }
}
