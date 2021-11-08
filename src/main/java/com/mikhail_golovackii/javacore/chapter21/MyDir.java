
package com.mikhail_golovackii.javacore.chapter21;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class MyDir {
    public static void main(String[] args) {
        String path = "/home/vologim/Projects/Study Suleimanov";
        
        try(DirectoryStream<Path> dirStrim = Files.newDirectoryStream(Paths.get(path))){
            System.out.println("Каталог " + path);
            
            for(Path entry : dirStrim){
                BasicFileAttributes attr = Files.readAttributes(entry, BasicFileAttributes.class);
                
                if(attr.isDirectory()){
                    System.out.println("<DIR>");
                }
                else{
                    System.out.println("    ");
                }
                System.out.println(entry.getName(1));
            }
        }
        catch(InvalidPathException e){
            System.out.println("Ошибка указания пути");
        }
        catch(NotDirectoryException e){
            System.out.println("Не является каталогом");
        }
        catch(IOException e){
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
