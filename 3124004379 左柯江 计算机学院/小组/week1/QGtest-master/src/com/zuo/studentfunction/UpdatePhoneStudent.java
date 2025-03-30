package com.zuo.studentfunction;

import java.sql.*;
import java.util.Scanner;

import static com.zuo.print.Constants.*;

public class UpdatePhoneStudent {



    public static void update(String name)throws Exception{



        Connection conn = null;
        PreparedStatement ps = null;
      int rs=0;
        System.out.println("请输入您的新电话");
        String phone=null;
        Scanner sc = new Scanner(System.in);
        phone = sc.nextLine();


        String sql = "UPDATE `students` SET `phone`=? WHERE `name`=?";
        try  {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            ps.setString(2 ,name);

            rs=ps.executeUpdate();

            if(rs!=0) {

                System.out.println("修改成功");
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
