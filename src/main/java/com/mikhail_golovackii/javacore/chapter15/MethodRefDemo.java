
package com.mikhail_golovackii.javacore.chapter15;

interface StringFunc {
    String func(String str);
}

class MyStringsOps {
    static String strReverse(String str){
        String result = "";
        
        for(int i = str.length() - 1; i >= 0; i--){
            result += str.charAt(i);
        }
        
        return result;
    }
}

public class MethodRefDemo {
    static String stringOp(StringFunc sf, String str){
        return sf.func(str);
    }
    
    public static void main(String[] args) {
        String inStr = "Simple text for java example";
        String outStr;
        
        outStr = stringOp(MyStringsOps::strReverse, inStr);
        
        System.out.println("Исходная строка: " + inStr);
        System.out.println("Обращенная строка: " + outStr);
    }
}
