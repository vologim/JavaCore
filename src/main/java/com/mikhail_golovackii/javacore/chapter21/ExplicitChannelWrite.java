
package com.mikhail_golovackii.javacore.chapter21;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExplicitChannelWrite {
    public static void main(String[] args) {
        String path = "/home/vologim/Projects/Study Suleimanov/file1.txt";
        FileOutputStream fileOutputStream = null;
        FileChannel fileChannel = null;
        ByteBuffer mBuf;
        
        try{
            fileOutputStream = new FileOutputStream(path);
            fileChannel = fileOutputStream.getChannel();
            mBuf = ByteBuffer.allocate(26);
            
            for(int i = 0; i < 26; i++){
                mBuf.put((byte) 'A');
            }
            
            mBuf.rewind();
            
            fileChannel.write(mBuf);
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
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
            }
            catch(IOException ex){
                System.out.println("Ошибка закрытия файла");
            }
        }
    }
}
