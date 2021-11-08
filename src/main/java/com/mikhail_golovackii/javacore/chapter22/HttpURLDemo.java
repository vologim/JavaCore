
package com.mikhail_golovackii.javacore.chapter22;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLDemo {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.google.com");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        
        System.out.println("Метод запроса: " + httpURLConnection.getRequestMethod());
        
        System.out.println("Код ответа: " + httpURLConnection.getResponseCode());
        
        System.out.println("Ответное сообщение: " + httpURLConnection.getResponseMessage());
        
        Map<String, List<String>> hdrMap = httpURLConnection.getHeaderFields();
        Set<String> hdrField = hdrMap.keySet();
        
        System.out.println("Следуют заголовок");
        
        for(String k : hdrField){
            System.out.println("Ключ: " + k + " Значение: " + hdrMap.get(k));
        }
    }
}
