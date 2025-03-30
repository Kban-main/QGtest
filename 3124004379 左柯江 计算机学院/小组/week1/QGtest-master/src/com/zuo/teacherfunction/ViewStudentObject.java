package com.zuo.teacherfunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static com.zuo.print.Constants.*;

public class ViewStudentObject {

    public static void  View()throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入想要查询的学生:");
        String name = sc.nextLine();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select `course_name` from `student_courses` where `student_name` = ?";
        try  {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {

                System.out.println(rs.getString("course_name"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            connection.close();
        }





    }

//    public static void main(String[] args) throws Exception {
//
//        ViewStudentObject view = new ViewStudentObject();
//        view.View();
//    }




}
