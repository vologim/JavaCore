
package com.mikhail_golovackii.javacore.chapter15;

interface MyFunc {
    int func(int a);
}

public class VarCapture {
    public static void main(String[] args) {
        int num = 10;
        
        MyFunc mf = (n) -> {
            int v = num;
            
            //num = 11; Так нельзя
            //num++;    Так нельзя
            
            return v;
        };
    }
}
