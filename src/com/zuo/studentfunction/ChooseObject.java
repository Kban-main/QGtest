package com.zuo.studentfunction;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;

import static com.zuo.print.Constants.*;

public class ChooseObject {


    public static void choose(String name)throws Exception {



        //先判断已经选了几节课了
       Connection conn = null;
       PreparedStatement ps1 = null;
       PreparedStatement ps2 = null;
       PreparedStatement ps3 = null;
       ResultSet rs1 = null;
       ResultSet rs3 = null;
       int rs2 = 0;
       String sql1 = "select * from `student_courses` where `student_name` = ?";
       try {
           conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
           ps1=conn.prepareStatement(sql1);
           ps1.setString(1, name);
           rs1 = ps1.executeQuery();
           int count = 0;
           while (rs1.next()) {
               count++;
           }
           if (count == 5) {System.out.println("选课已满无法再选课");return ;}
           else {

               System.out.println("请输入想要选择的课程:");
               String courseName = null;
               Scanner sc = new Scanner(System.in);
               courseName = sc.nextLine();

               //判断时间是否符合要求
               String sql3 = "select start_date from `courses` where `course_name` = ?";
               ps3 = conn.prepareStatement(sql3);
               ps3.setString(1, courseName);
               rs3 = ps3.executeQuery();
               if (rs3.next()) {

                   Timestamp courseTime = rs3.getTimestamp("start_date");
                   LocalDateTime currentTime = LocalDateTime.now();
                   LocalDateTime courseDateTime = courseTime.toLocalDateTime();

                   if (courseDateTime.isBefore(currentTime)) {
                       System.out.println("课程时间已过,无法退选");
                       return;
                   } else {

                       String sql2 = "insert into `student_courses` (`student_name`,`course_name`) values(?,?)";
                       ps2 = conn.prepareStatement(sql2);
                       ps2.setString(1, name);
                       ps2.setString(2, courseName);

                       rs2 = ps2.executeUpdate();

                       if (rs2 != 0) {
                           System.out.println("选课成功");
                       } else {
                           System.out.println("选课失败,请重新选课");
                       }

                   }
               }
           }
       }catch(Exception e) {
           e.printStackTrace();
       }finally{
           if(rs1!=null) try{rs1.close();}catch(SQLException e){
               e.printStackTrace();
           }
          if(ps2!=null) try{ps2.close();}catch(SQLException e){
              e.printStackTrace();
          }
          if(conn!=null) try{conn.close();}catch(SQLException e){
              e.printStackTrace();
          }

       }




    }


    public static void main(String[] args)throws Exception {
        ChooseObject.choose("新华");
    }



}
