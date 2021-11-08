
package com.mikhail_golovackii.javacore.chapter20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemo {
    public static void main(String[] args) {
        String path = "/home/vologim/Projects/Study Suleimanov/file1.txt";
        
        try (ObjectOutputStream objOStream = new ObjectOutputStream(new FileOutputStream(path))) {
            MyClass obj1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("Obj1: " + obj1);
            objOStream.writeObject(obj1);
        }
        catch (IOException ex) {
            System.out.println("Исключение при сериализации");
        }
        
        try (ObjectInputStream objIStream = new ObjectInputStream(new FileInputStream(path))) {
            MyClass obj2 = (MyClass) objIStream.readObject();
            System.out.println("Obj2: " + obj2);
        }
        catch (Exception ex) {
            System.out.println("Исключение при десериализации");
        }
    }
}

class MyClass implements Serializable {
    String s;
    int i;
    double d;

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return "MyClass{" + "s=" + s + ", i=" + i + ", d=" + d + '}';
    }
    
    
}
