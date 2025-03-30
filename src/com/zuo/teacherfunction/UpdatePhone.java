package com.zuo.teacherfunction;

import java.sql.*;
import java.util.Scanner;

import static com.zuo.print.Constants.*;

public class UpdatePhone {



    public static void Update() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String name =null;
        int phone;
        System.out.println("请输入想要修改的学生名字:");
        name = sc.nextLine();
        System.out.println("请输入更新的电话号码:");
        phone = sc.nextInt();
        Connection connection = null;
        PreparedStatement ps = null;
        int rs = 0;
        String sql = "UPDATE `students` SET `phone`=? WHERE `name`=?";
        try  {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            ps = connection.prepareStatement(sql);
            ps.setInt(1, phone);
            ps.setString(2, name);
           rs=ps.executeUpdate();
           if(rs!=0) {

               System.out.println("修改成功");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ps.close();
            connection.close();
        }


    }




    }




