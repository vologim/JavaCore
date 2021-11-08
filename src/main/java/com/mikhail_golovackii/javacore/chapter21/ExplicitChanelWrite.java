
package com.mikhail_golovackii.javacore.chapter21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class ExplicitChanelWrite {
    public static void main(String[] args) {
        String path = "/home/vologim/Projects/Study Suleimanov/file1.txt";
        
        try(FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get(path),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE)){
            
            ByteBuffer buf = ByteBuffer.allocate(100);
            
            for(int i = 0; i < 100; i++){
                buf.put((byte) ('A' + i));
            }
            
            buf.rewind();
            
            fChan.write(buf);
        }
        catch(InvalidPathException ex){
            System.out.println("Ошибка указания пути");
        }
        catch(IOException ex){
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
