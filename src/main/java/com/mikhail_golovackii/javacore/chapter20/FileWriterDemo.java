
package com.mikhail_golovackii.javacore.chapter20;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException{
        String source = "Now is the time for all good men\n"
                + " to come to the aid of their country\n"
                + " and pay their due taxes";
        char buf[] = new char[source.length()];
        
        source.getChars(0, source.length(), buf, 0);
        
        try (FileWriter f0 = new FileWriter("/home/vologim/Projects/Study Suleimanov/file1.txt");
             FileWriter f1 = new FileWriter("/home/vologim/Projects/Study Suleimanov/file2.txt");
             FileWriter f2 = new FileWriter("/home/vologim/Projects/Study Suleimanov/file3.txt")) {
            
            for(int i = 0; i < buf.length; i += 2){
                f0.write(buf[i]);
            }
            
            f1.write(buf);
            
            f2.write(buf, buf.length - buf.length / 4, buf.length / 4);
        }
        catch (IOException ex) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
    
}
