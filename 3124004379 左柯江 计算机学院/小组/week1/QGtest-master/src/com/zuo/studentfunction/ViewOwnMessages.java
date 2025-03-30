package com.zuo.studentfunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.zuo.print.Constants.*;

public class ViewOwnMessages {

    public static void view(String name)throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select `name`,`password`,`role` from `users` where `name` = ?";
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("姓名是:"+rs.getString("name"));
                System.out.println("密码是:"+rs.getString("password"));
                System.out.println("职务是:"+rs.getString("role"));

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



}
