
package com.mikhail_golovackii.javacore.chapter21;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MappedChannelWrite1 {
    public static void main(String[] args) {
        String path = "/home/vologim/Projects/Study Suleimanov/file1.txt";
        RandomAccessFile file = null;
        FileChannel fChannel = null;
        ByteBuffer mBuffer;
        
        try{
            file = new RandomAccessFile(path, "rw");
            fChannel = file.getChannel();
            mBuffer = fChannel.map(FileChannel.MapMode.READ_WRITE, 0, 26);
            
            for(int i = 0; i < 26; i++){
                mBuffer.put((byte)('A' + i));
            }
        }
        catch(IOException ex){
            System.out.println("Ошибка ввода-вывода");
        }
        finally{
            try{
                if(fChannel != null){
                    fChannel.close();
                }
            }
            catch(IOException ex){
                System.out.println("Ошибка закрытия канала");
            }
            try{
                if(file != null){
                    file.close();
                }
            }
            catch(IOException ex){
                System.out.println("Ошибка закрытия файла");
            }
        }
    }
}
