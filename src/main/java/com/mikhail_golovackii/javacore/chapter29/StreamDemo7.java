
package com.mikhail_golovackii.javacore.chapter29;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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

public class StreamDemo7 {
    public static void main(String[] args) {
        List<NamePhoneEmail> list = new ArrayList<>();
        
        list.add(new NamePhoneEmail("Misha", "222-22-22", "misha@gmail.com"));
        list.add(new NamePhoneEmail("Vitya", "333-33-33", "vitya@gmail.com"));
        list.add(new NamePhoneEmail("Ira", "444-44-44", "ira@gmail.com"));
        
        Stream<NamePhone> namePhone = list.stream()
                                      .map(el -> new NamePhone(el.getName(), el.getPhoneNum()));
        
        List<NamePhone> namePhoneList = namePhone.collect(Collectors.toList());
        
        System.out.println("Номера и имена телефонов в namePhoneList:");
        namePhoneList.forEach(el -> System.out.println(el.getName() + " : " + el.getPhoneNum()));
        
        namePhone = list.stream().map(el -> new NamePhone(el.getName(), el.getPhoneNum()));
        
        Set<NamePhone> namePhoneSet = namePhone.collect(Collectors.toSet());
        System.out.println("Номера и имена телефонов в namePhoneSet:");
        namePhoneSet.forEach(el -> System.out.println(el.getName() + " : " + el.getPhoneNum()));
        
    }
}

