
package com.mikhail_golovackii.javacore.chapter29;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class NamePhoneEmail{
    private String name;
    private String phoneNum;
    private String email;

    public NamePhoneEmail(String name, String phoneNum, String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class NamePhone{
    private String name;
    private String phoneNum;

    public NamePhone(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}

public class StreamDemo5 {
    public static void main(String[] args) {
        List<NamePhoneEmail> list = new ArrayList<>();
        
        list.add(new NamePhoneEmail("Misha", "222-22-22", "misha@gmail.com"));
        list.add(new NamePhoneEmail("Vitya", "333-33-33", "vitya@gmail.com"));
        list.add(new NamePhoneEmail("Ira", "444-44-44", "ira@gmail.com"));
        
        System.out.println("Исходные материалы из list:");
        list.stream().forEach(elem -> System.out.println(elem.getName() 
                                             + " " + elem.getPhoneNum()
                                             + " " + elem.getEmail()));
        
        System.out.println();
        
        Stream<NamePhone> namePhone = list.stream().map(a -> new NamePhone(a.getName(), a.getPhoneNum()));
        
        System.out.println("Список имен и телефонов:");
        namePhone.forEach(elem -> System.out.println(elem.getName() + " " + elem.getPhoneNum()));
        
        
    }
}
