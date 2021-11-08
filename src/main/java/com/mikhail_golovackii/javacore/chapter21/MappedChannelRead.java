
package com.mikhail_golovackii.javacore.chapter21;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class MappedChannelRead {
    public static void main(String[] args) {
        String path = "/home/vologim/Projects/Study Suleimanov/file1.txt";
        
        try(FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get(path))){
            long fSize = fChan.size();
            
            MappedByteBuffer mbuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);
            
            for(int i = 0; i < fSize; i++){
                System.out.print((char) mbuf.get());
            }
            System.out.println();
        }
        catch(InvalidPathException ex){
            System.out.println("Ошибка указания пути");
        }
        catch(IOException ex){
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
