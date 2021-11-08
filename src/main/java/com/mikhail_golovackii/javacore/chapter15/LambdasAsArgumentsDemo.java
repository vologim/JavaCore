
package com.mikhail_golovackii.javacore.chapter15;

interface StringFunc {
    String func(String str);
}

public class LambdasAsArgumentsDemo {
    
    static String stringOp(StringFunc strFunc, String str){
        return strFunc.func(str);
    }
    
    public static void main(String[] args) {
        String inStr = "Simple text for java example";
        String outStr;
        
        System.out.println("Это исходная строка: " + inStr);
        
        outStr = stringOp((n) -> {
            String res = "";
            int i;
            
            for(i = 0; i < n.length(); i++){
                if(n.charAt(i) != ' '){
                    res += n.charAt(i);
                }
            }
            return res;
        }, inStr);
        
        System.out.println("Это строка без пробелов: " + outStr);
        
        StringFunc reverse = (str) -> {
            String result = "";
            for(int i = str.length() - 1; i >= 0; i--){
                result += str.charAt(i);
            }
            return result;
        };
        
        System.out.println("Переворачиваем строку: " + stringOp(reverse, inStr));
        
    }
}
