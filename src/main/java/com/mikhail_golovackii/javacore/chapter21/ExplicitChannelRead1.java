
package com.mikhail_golovackii.javacore.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExplicitChannelRead1 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;
        int count;
        String path = "/home/vologim/Projects/Study Suleimanov/file1.txt";
        
        try{
            fis = new FileInputStream(path);
            fChan = fis.getChannel();
            mBuf = ByteBuffer.allocate(128);
            
            do{
                count = fChan.read(mBuf);
                
                if(count != -1){
                    mBuf.rewind();
                    
                    for(int i = 0; i < count; i++){
                        System.out.print((char) mBuf.get());
                    }
                }
            }
            while(count != -1);
            System.out.println();
        }
        catch(IOException ex){
            System.out.println("Ошибка ввода-вывода");
        }
        finally{
            try{
                if(fChan != null){
                    fChan.close();
                }
            }
            catch(IOException ex){
                System.out.println("Ошибка закрытия канала");
            }
            try{
                if(fis != null){
                    fis.close();
                }
            }
            catch(IOException ex){
                System.out.println("Ошибка закрытия файла");
            }
        }
        
    }
}
