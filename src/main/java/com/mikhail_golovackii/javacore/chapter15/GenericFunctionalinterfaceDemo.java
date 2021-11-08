
package com.mikhail_golovackii.javacore.chapter15;

interface SomeFunc <T> {
    T func(T t);
}

public class GenericFunctionalinterfaceDemo {
    public static void main(String[] args) {
        
        SomeFunc<String> reverse = (str) -> {
            String result = "";
            int i;
            
            for(i = str.length() - 1; i >= 0; i--){
                result += str.charAt(i);
            }
                
            return result;
        };
        
        System.out.println("Лямбда обращается на " + reverse.func("Lambda"));
        System.out.println("Слово обращается на " + reverse.func("Word"));
        
        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for(int i = 1; i <= n; i++){
                result = i * result;
            }
            return result;
        };
        
        System.out.println("Факториал 3 = " + factorial.func(3));
        System.out.println("Факториал 5 = " + factorial.func(5));
    }
}
