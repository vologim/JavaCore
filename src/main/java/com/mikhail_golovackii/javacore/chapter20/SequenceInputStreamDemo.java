
package com.mikhail_golovackii.javacore.chapter20;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

class InputStreamEnumerator implements Enumeration<FileInputStream> {
    private Enumeration<String> files;

    public InputStreamEnumerator(Vector<String> files) {
        this.files = files.elements();
    }  
    
    @Override
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    @Override
    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement().toString());
        }
        catch (IOException ex) {
            return null;
        }
    }
    
}

public class SequenceInputStreamDemo {
    public static void main(String[] args) {
        String path = "/home/vologim/Projects/Study Suleimanov/";
        int c;
        Vector<String> files = new Vector<>();
        
        files.add(path + "file1.txt");
        files.add(path + "file2.txt");
        files.add(path + "file3.txt");
        
        InputStreamEnumerator ise = new InputStreamEnumerator(files);
        
        try (InputStream input = new SequenceInputStream(ise)) {
            while ((c = input.read()) != -1) {
                System.out.println((char) c);
            }
        }
        catch (NullPointerException ex) {
            System.out.println("Ошибка открытия файла");
        }
        catch (IOException ex) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
