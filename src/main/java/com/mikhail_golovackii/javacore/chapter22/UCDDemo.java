
package com.mikhail_golovackii.javacore.chapter22;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class UCDDemo {
    public static void main(String[] args) throws Exception{
        int c;
        URL url = new URL("https://www.onliner.by");
        URLConnection uRLConnection = url.openConnection();
        
        long date = uRLConnection.getDate();
        if(date == 0){
            System.out.println("Дата отсутствует");
        }
        else{
            System.out.println("Дата: " + new Date(date));
        }
        
        System.out.println("Тип содержимого: " + uRLConnection.getContentType());
        
        date = uRLConnection.getExpiration();
        if(date == 0){
            System.out.println("Срок действия отсутствует");
        }
        else{
            System.out.println("Срок действия истекает: " + new Date(date));
        }
        
        date = uRLConnection.getLastModified();
        if(date == 0){
            System.out.println("Модификация отсутствует");
        }
        else{
            System.out.println("Дата модификации истекает: " + new Date(date));
        }
        
        long len = uRLConnection.getContentLengthLong();
        if(len == -1){
            System.out.println("Длина содержимого отсутствует");
        }
        else{
            System.out.println("Длина содержимого: " + len);
        }
        
        if(len != 0){
            System.out.println("===Содержимое===");
            InputStream inputStream = uRLConnection.getInputStream();
            
            while((c = inputStream.read()) != -1){
                System.out.print((char) c);
            }
            
            inputStream.close();
        }
        else{
            System.out.println("Содержимое недоступно");
        }
        
    }
    
}
