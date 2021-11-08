
package com.mikhail_golovackii.javacore.chapter15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MyClass {
    private int val;

    public MyClass(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}

public class UseMethodRef {
    static int compareMC(MyClass a, MyClass b){
        return a.getVal() - b.getVal();
    }
    
    public static void main(String[] args) {
        List<MyClass> myClasses = new ArrayList<>();
        
        myClasses.add(new MyClass(1));
        myClasses.add(new MyClass(4));
        myClasses.add(new MyClass(2));
        myClasses.add(new MyClass(9));
        myClasses.add(new MyClass(3));
        myClasses.add(new MyClass(7));
        
        MyClass maxValue = Collections.max(myClasses, UseMethodRef::compareMC);
        
        System.out.println("Максимальное значение = " + maxValue.getVal());
    }
}
