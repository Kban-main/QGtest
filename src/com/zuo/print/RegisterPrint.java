package com.zuo.print;
import java.io.BufferedReader;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.sql.*;

import static com.zuo.print.Constants.*;






//注册账户



public class RegisterPrint {
    private static String username;

    private static String password;


    public RegisterPrint() throws Exception {
    }

    public static void Print() throws Exception {


        System.out.println("请输入用户名");
        Scanner sc = new Scanner(System.in);
        String name1 = sc.nextLine();


        System.out.println("请输入密码");

        String password1 = sc.nextLine();
        System.out.println("请选择角色(1代表老师,2代表学生)");
        int charact = 0;
        charact = sc.nextInt();
        sc.nextLine(); // 消耗换行符
        /*
        statement.executeQuery()//查询
        statement.executeUpdate()//更新,插入,删除,返回一个受影响的行数
         */
        //连接数据据库操作
        String url = DB_URL;
        String sql = "INSERT INTO users (name, password, role) VALUES (?,?,?)";
        String sql1 = "insert into students (name,phone) values(?,?)";
        PreparedStatement ps1=null;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name1);
            ps.setString(2, password1);
            if (charact == 1) {
                ps.setString(3, "teacher");
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("注册成功！");
                }else {
                    System.out.println("老师详细信息插入失败！");
                }
            }
            else if (charact == 2)
            {
                ps.setString(3, "student");
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("注册成功！");
                }else {
                    System.out.println("学生详细信息插入失败！");
                }
                System.out.println("请输入你的电话号码:");
                int phone = sc.nextInt();
                ps1 = connection.prepareStatement(sql1);
                ps1.setString(1, name1);
                ps1.setInt(2, phone);
                int rowsAffected1 = ps1.executeUpdate();
                if(rowsAffected1>0){
                    System.out.println("学生信息录入成功!");
                }else {
                    System.out.println("学生信息录入失败!");
                }

            }

        } catch (Exception e) {
         e.printStackTrace();

        }


    }
}