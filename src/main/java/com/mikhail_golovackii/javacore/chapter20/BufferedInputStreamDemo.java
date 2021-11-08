
package com.mikhail_golovackii.javacore.chapter20;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        String s = "Это знак авторского права &copy; "
                + ", а &copy - нет";
        byte b[] = s.getBytes();
        int c;
        boolean marked = false;
        ByteArrayInputStream in = new ByteArrayInputStream(b);
        
        try (BufferedInputStream f = new BufferedInputStream(in)) {
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
                            System.out.println("(c)");
                        }
                        else {
                            System.out.println((char) c);
                        }
                        break;
                    case ' ':
                        if (marked) {
                            marked = false;
                            f.reset();
                            System.out.println("&");
                        }
                        else {
                            System.out.println((char) c);
                        }
                        
                        break;
                    default:
                        if (!marked){
                            System.out.println((char) c);
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
