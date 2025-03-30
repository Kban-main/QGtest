package com.zuo.studentfunction;

import java.sql.*;
import com.zuo.print.Constants.*;

import static com.zuo.print.Constants.*;

public class DeletObject {


    public static void delete(String name)throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from `student_courses` where student_name = ?";

        try{
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps=conn.prepareStatement(sql);
            ps.setString(1, name);
   }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

}
