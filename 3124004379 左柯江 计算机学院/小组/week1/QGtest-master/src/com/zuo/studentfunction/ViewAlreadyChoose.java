package com.zuo.studentfunction;
import java.sql.*;
import com.zuo.print.Constants.*;

import static com.zuo.print.Constants.*;


public class ViewAlreadyChoose {

    public static void view(String name)throws SQLException{



        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select `course_name` from `student_courses` where `student_name` = ?";
        try {
           conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("course_name"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
           if (ps != null) {
               ps.close();
           }
           if (conn != null) {
               conn.close();
           }
        }



    }

    public static void main(String[] args)throws SQLException {
            ViewAlreadyChoose.view("梨花");
    }


}
