
package com.mikhail_golovackii.javacore.chapter20;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutpuStreamDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n"
                + "to come to the aid of their country\n"
                + "and pay their due taxes";
        byte buf[] = source.getBytes();
        
        FileOutputStream f0 = null;
        FileOutputStream f1 = null;
        FileOutputStream f2 = null;
        
        try {
            f0 = new FileOutputStream("/home/vologim/Projects/Study Suleimanov/file1.txt");
            f1 = new FileOutputStream("/home/vologim/Projects/Study Suleimanov/file2.txt");
            f2 = new FileOutputStream("/home/vologim/Projects/Study Suleimanov/file3.txt");
            
            for(int i = 0; i < buf.length; i += 2){
                f0.write(buf[i]);
            }
            
            f1.write(buf);
            
            f2.write(buf, buf.length - buf.length / 4, buf.length / 4);
        }
        catch (IOException ex) {
            System.out.println("Ошибка ввода-вывода");
        }
        finally {
            try {
                if(f0 != null){
                    f0.close();
                }
            }
            catch (IOException ex) {
                    System.out.println("Ошибка закрытия file1.txt");
            }
            try {
                if(f1 != null){
                    f1.close();
                }
            }
            catch (IOException ex) {
                    System.out.println("Ошибка закрытия file2.txt");
            }
            try {
                if(f2 != null){
                    f2.close();
                }
            }
            catch (IOException ex) {
                    System.out.println("Ошибка закрытия file3.txt");
            }
        }
    }
}
