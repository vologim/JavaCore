
package com.mikhail_golovackii.javacore.chapter20;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIODemo {
    public static void main(String[] args) {
        String path = "/home/vologim/Projects/Study Suleimanov/file1.txt";
        
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream(path))) {
            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeBoolean(true);
        }
        catch (FileNotFoundException ex) {
            System.out.println("Нельзя открыть файл вывода");
            return;
        }
        catch (IOException ex) {
            System.out.println("Ошибка ввода-вывода");
        }
        
        try (DataInputStream din = new DataInputStream(new FileInputStream(path))) {
            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();
            
            System.out.println("Значения: " + d + " " + i + " " + b);
        }
        catch (FileNotFoundException ex) {
            System.out.println("Нельзя открыть файл вывода");
            return;
        }
        catch (IOException ex) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
