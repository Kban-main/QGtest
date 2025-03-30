package com.zuo.teacherfunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static com.zuo.print.Constants.*;

public class UpdateCreditHour {


    public static void Update() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String object =null;
        int credit=0;
        System.out.println("请输入想要修改课程:");
        object = sc.nextLine();
        System.out.println("请输入更新的学分:");
       credit = sc.nextInt();
        Connection connection = null;
        PreparedStatement ps = null;
        int rs = 0;
        String sql = "UPDATE `courses` SET `credithour`=? WHERE `course_name`=?";
        try  {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            ps = connection.prepareStatement(sql);
            ps.setInt(1, credit);
            ps.setString(2, object);
            rs=ps.executeUpdate();
            if(rs!=0) {

                System.out.println("修改成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ps.close();
            connection.close();
        }

    }

    public static void main(String[] args) throws SQLException {
        UpdateCreditHour update = new UpdateCreditHour();
        update.Update();
    }


}
