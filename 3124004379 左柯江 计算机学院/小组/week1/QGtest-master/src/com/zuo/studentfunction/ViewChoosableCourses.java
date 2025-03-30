package com.zuo.studentfunction;

import java.sql.*;

import static com.zuo.print.Constants.*;



public class ViewChoosableCourses {



    public static void view(String name) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select *\n" +
                "from `courses`\n" +
                "where `course_name` not in (\n" +
                "select `course_name`\n" +
                "from `student_courses`\n" +
                "where `student_name`=?)";
        try{
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            rs = pstmt.executeQuery();


            if (!rs.next()) {
                System.out.println("没有可以选的课程");
            } else {
                // 处理第一行数据
                System.out.println(rs.getString("course_name"));
                // 处理剩余的数据行
                while (rs.next()) {
                    System.out.println(rs.getString("course_name"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            if(rs!=null){
                rs.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                 conn.close();
            }
        }

    }


//    public static void main(String[] args) throws SQLException {
//        ViewChoosableCourses.view("梨花");
//
//    }



}
