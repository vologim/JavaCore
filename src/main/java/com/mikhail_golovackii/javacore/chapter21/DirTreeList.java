
package com.mikhail_golovackii.javacore.chapter21;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileVisitor extends SimpleFileVisitor<Path> {
    public FileVisitResult visitFile(Path path, BasicFileAttributes attr) throws IOException{
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}

public class DirTreeList {
    public static void main(String[] args) {
        String dirName = "/home/vologim/Projects/Study Suleimanov";
        
        System.out.println("Дерево каталогов, начиная с каталога " + dirName + ":\n");
        
        try{
            Files.walkFileTree(Paths.get(dirName), new MyFileVisitor());
        }
        catch(IOException ex){
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
