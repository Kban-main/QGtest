package com.zuo.studentfunction;

public class Student {
    private static String name;
    private static int phone;


    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Student.name = name;
    }

    public static int getPhone() {
        return phone;
    }

    public static void setPhone(int phone) {
        Student.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{}";
    }



}
