
package com.mikhail_golovackii.javacore.chapter21;

import java.io.*;
import java.nio.file.*;

public class NIOCopy {
    public static void main(String[] args) {
        String path1 = "/home/vologim/Projects";
        String path2 = "/home/vologim/Projects/Study Suleimanov";
        
        try{
            Path source = Paths.get(path1);
            Path target = Paths.get(path2);
            
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        }
        catch(InvalidPathException ex){
            System.out.println("Ошибка пути");
        }
        catch(IOException ex){
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
