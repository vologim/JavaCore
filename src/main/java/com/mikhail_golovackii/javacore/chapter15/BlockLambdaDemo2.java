
package com.mikhail_golovackii.javacore.chapter15;

interface StringFunc {
    String func(String str);
}

public class BlockLambdaDemo2 {
    public static void main(String[] args) {
        StringFunc reverse = (str) -> {
            String result = "";
            int i;
            
            for(i = str.length() - 1; i >= 0; i--){
                result += str.charAt(i);
            }
                
            return result;
        };
        
        System.out.println("Лямбда обращается на " + reverse.func("Lambda"));
        System.out.println("Слово обращается на " + reverse.func("Word"));
    }
}
