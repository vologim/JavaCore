
package com.mikhail_golovackii.javacore.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TinyEditor {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = new String[100];
        System.out.println("Введите текст");
        System.out.println("Введите 'stop' для завершения");
        for(int i = 0; i < 100; i++){
            str[i] = br.readLine();
            if(str[i].equals("stop")){
                break;
            }
        }
        System.out.println("Содержимое файла:");
        for(int i = 0; i < 100; i++){
            if(str[i].equals("stop")){
                break;
            }
            System.out.println(str[i]);
        }
    }
}
