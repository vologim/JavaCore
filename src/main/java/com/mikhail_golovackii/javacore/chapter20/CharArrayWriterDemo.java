
package com.mikhail_golovackii.javacore.chapter20;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriterDemo {
    public static void main(String[] args) {
        CharArrayWriter f = new CharArrayWriter();
        String s = "Эти данные должны быть выведены в массив";
        char buf[] = new char[s.length()];
        
        try {
            f.write(buf);
        }
        catch (IOException ex) {
            System.out.println("Ошибка записи в буфер");
            return;
        }
        
        System.out.println("Буфер в виде символьной строки");
        System.out.println(f.toString());
        System.out.println("В массив");
        char b[] = f.toCharArray();
        for(int i = 0; i < b.length; i++){
            System.out.println(b[i]);
        }
        System.out.println("\nВ поток вывода типа OutputStream()");
        
        try (FileWriter f2 = new FileWriter("/home/vologim/Projects/Study Suleimanov/file1.txt")){
            f.writeTo(f2);
        }
        catch (IOException ex) {
            System.out.println("Ошибка " + ex);
            return;
        }
        
        System.out.println("Установка в исходное состояние");
        f.reset();
        
        for(int i = 0; i < 3; i++){
            f.write('X');
        }
        
        System.out.println(f.toString());
    }
}
