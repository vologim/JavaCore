
package com.mikhail_golovackii.javacore.chapter21;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList {
    public static void main(String[] args) {
        String path = "/home/vologim/Projects/Study Suleimanov";
        
        DirectoryStream.Filter<Path> how = 
                new DirectoryStream.Filter<Path>(){
            public boolean accept(Path fileName) throws IOException{
                if(Files.isWritable(fileName)){
                    return true;
                }
                return false;
            }
        };
        
        try(DirectoryStream<Path> dirStrim = 
                Files.newDirectoryStream(Paths.get(path), how)){
            
            System.out.println("Каталог: " + path);
            
            for(Path entry : dirStrim){
                BasicFileAttributes attr = 
                        Files.readAttributes(entry, BasicFileAttributes.class);
                
                if(attr.isDirectory()){
                    System.out.println("<DIR>");
                }
                else{
                    System.out.println("    ");
                }
                
                System.out.println(entry.getName(1));
            }
        }
        catch(InvalidPathException ex){
            System.out.println("Ошибка указания пути");
        }
        catch(NotDirectoryException ex){
            System.out.println(path + " не является каталогом");
        }
        catch(IOException ex){
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
