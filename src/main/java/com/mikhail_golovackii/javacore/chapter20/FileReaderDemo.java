
package com.mikhail_golovackii.javacore.chapter20;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        String path = "/home/vologim/Projects/Study Suleimanov/file1.txt";
        
        try (FileReader fr = new FileReader(path)) {
            int c;
            
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        }
        catch (IOException ex) {
            System.out.println("Ошибка " + ex);
        }
    }
}
