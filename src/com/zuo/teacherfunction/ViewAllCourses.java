package com.zuo.teacherfunction;

import java.sql.*;

import static com.zuo.print.Constants.*;

public class ViewAllCourses {

    public static void viewCourses() throws SQLException {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select `course_name` from `courses`";
        try  {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                String name = rs.getString("course_name");
                System.out.println(name);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            connection.close();
        }


    }




}
