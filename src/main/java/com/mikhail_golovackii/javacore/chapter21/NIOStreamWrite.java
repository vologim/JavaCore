
package com.mikhail_golovackii.javacore.chapter21;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class NIOStreamWrite {
    public static void main(String[] args) {
        String path = "/home/vologim/Projects/Study Suleimanov/file1.txt";
        
        try(OutputStream output = new BufferedOutputStream(Files.newOutputStream(Paths.get(path)))){
            for(int i = 0; i < 26; i++){
                output.write((byte) ('A' + i));
            }
        }
        catch(InvalidPathException ex){
            System.out.println("Ошибка указания пути");
        }
        catch(IOException ex){
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
