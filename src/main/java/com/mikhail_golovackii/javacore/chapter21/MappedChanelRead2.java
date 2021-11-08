
package com.mikhail_golovackii.javacore.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedChanelRead2 {
    public static void main(String[] args) {
        String path = "/home/vologim/Projects/Study Suleimanov/file1.txt";
        FileInputStream fileInputStream = null;
        FileChannel fileChannel = null;
        long size;
        MappedByteBuffer mBuf;
        
        try{
            fileInputStream = new FileInputStream(path);
            fileChannel = fileInputStream.getChannel();
            size = fileChannel.size();
            
            mBuf = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, size);
            
            for(int i = 0; i < size; i++){
                System.out.print((char) mBuf.get());
            }
        }
        catch(IOException ex){
            System.out.println("Ошибка ввода-вывода");
        }
        finally{
            try{
                if(fileChannel != null){
                    fileChannel.close();
                }
            }
            catch(IOException ex){
                System.out.println("Ошибка закрытия канала");
            }
            try{
                if(fileInputStream != null){
                    fileInputStream.close();
                }
            }
            catch(IOException ex){
                System.out.println("Ошибка закрытия файла");
            }
        }
    }
}
