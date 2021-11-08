
package com.mikhail_golovackii.javacore.chapter20;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        String s = "Это знак авторского права &copy; "
                + ", а &copy - нет";
        char b[] = new char[s.length()];
        s.getChars(0, s.length(), b, 0);
        int c;
        boolean marked = false;
        CharArrayReader in = new CharArrayReader(b);
        
        try (BufferedReader f = new BufferedReader(in)) {
            while ((c = f.read()) != -1) {
                switch (c) {
                    case '&':
                        if (!marked) {
                            f.mark(32);
                            marked = true;
                        }
                        else {
                            marked = false;
                        }
                        break;
                    case ';':
                        if (marked) {
                            marked = false;
                            System.out.print("(c)");
                        }
                        else {
                            System.out.print((char) c);
                        }
                        break;
                    case ' ':
                        if (marked) {
                            marked = false;
                            f.reset();
                            System.out.print("&");
                        }
                        else {
                            System.out.print((char) c);
                        }
                        
                        break;
                    default:
                        if (!marked){
                            System.out.print((char) c);
                        }
                        break;                           
                    }
                }
            }
            catch (IOException ex) {
                System.out.println("Ошибка " + ex);
            }
    }
}
