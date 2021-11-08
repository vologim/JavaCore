
package com.mikhail_golovackii.javacore.chapter21;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MappedChannelWrite {
    public static void main(String[] args) {
        String path = "/home/vologim/Projects/Study Suleimanov/file1.txt";
        
        try(FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get(path),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.READ)){
            
            MappedByteBuffer buf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);
            
            for(int i = 0; i < 26; i++){
                buf.put((byte) ('A' + i));
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
