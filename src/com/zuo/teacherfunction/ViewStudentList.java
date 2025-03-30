package com.zuo.teacherfunction;


import java.sql.*;
import java.util.Scanner;

import static com.zuo.print.Constants.*;

/*
查询某课程的学生名单
 */
public class ViewStudentList {

    public static void viewList() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的课程:");
        String name = sc.nextLine();


        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select `student_name` from `student_courses` where `course_name` = ?";
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("student_name"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            connection.close();
        }


    }

//    public static void main(String[] args)throws Exception {
//        ViewStudentList view = new ViewStudentList();
//        view.viewList();
//    }




}