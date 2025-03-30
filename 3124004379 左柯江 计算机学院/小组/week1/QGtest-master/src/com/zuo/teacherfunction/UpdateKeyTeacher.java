package com.zuo.teacherfunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import static com.zuo.print.Constants.*;

public class UpdateKeyTeacher {
    public static void update(String name)throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs=0;
        System.out.println("请输入您的新密码");
        String password=null;
        Scanner sc = new Scanner(System.in);
        password= sc.nextLine();
        String sql = "UPDATE `users` SET `password`=? WHERE `name`=?";
        try  {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2 ,name);
            rs=ps.executeUpdate();

            if(rs!=0) {

                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if(ps!=null){
                ps.close();
            }
            if(conn!=null){
                conn.close();
            }

        }

    }

}
