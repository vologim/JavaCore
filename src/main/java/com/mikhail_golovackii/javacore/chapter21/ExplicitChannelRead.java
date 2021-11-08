
package com.mikhail_golovackii.javacore.chapter21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExplicitChannelRead {
    public static void main(String[] args) throws IOException {
        String path = "/home/vologim/Projects/Study Suleimanov/file1.txt";
        int count;
        Path filePath = null;
        
        try {
            filePath = Paths.get(path);
        }
        catch (InvalidPathException ex) {
            System.out.println("Path Error");
            return;
        }
        
        try (SeekableByteChannel fChan = Files.newByteChannel(filePath)) {
            ByteBuffer buf = ByteBuffer.allocate(128);
            do {
                count = fChan.read(buf);
                
                if (count != -1) {
                    buf.rewind();
                    
                    for(int i = 0; i < count; i++){
                        System.out.print((char) buf.get());
                    }
                }
            }
            while(count != -1);
        }
        catch(InvalidPathException ex){
            System.out.println("Ошибка указания пути");
        }
        catch(IOException ex){
            System.out.println("Ошибка ввода-вывода");
        }
        
    }
}
