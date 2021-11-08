
package com.mikhail_golovackii.javacore.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRReader {
    public static void main(String[] args) throws IOException{
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Введите q для выхода");
        
        do {            
            c = (char) br.read();
            System.out.println(c);
        } 
        while (c != 'q');
    }
}
