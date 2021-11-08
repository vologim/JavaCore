
package com.mikhail_golovackii.javacore.chapter21;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        
        if(args.length != 1){
            System.out.println("Применение: ShowFile имя_файла");
            return;
        }
        
        try(InputStream fin = Files.newInputStream(Paths.get(args[0]))){
            do{
                i = fin.read();
                if(i != -1){
                    System.out.println((char) i);
                }
                
            }
            while(i != -1);
        }
        catch(InvalidPathException ex){
            System.out.println("Ошибка указания пути");
        }
        catch(IOException ex){
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
