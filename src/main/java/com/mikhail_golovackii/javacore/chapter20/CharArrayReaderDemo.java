
package com.mikhail_golovackii.javacore.chapter20;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderDemo {
    public static void main(String[] args) {
        String tmp = "abcdefghijklmnopqrstuvwxyz";
        int length = tmp.length();
        char c[] = new char[length];
        
        tmp.getChars(0, length, c, 0);
        int i;
        
        try (CharArrayReader input1 = new CharArrayReader(c)) {
            System.out.println("input1:");
            while ((i = input1.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
        }
        catch (IOException ex) {
            System.out.println("Ошибка " + ex);
        }
        
        try (CharArrayReader input2 = new CharArrayReader(c, 8, 2)) {
            System.out.println("input2:");
            while ((i = input2.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
        }
        catch (IOException ex) {
            System.out.println("Ошибка " + ex);
        }
    }
}
