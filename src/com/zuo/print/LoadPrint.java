package com.zuo.print;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import static com.zuo.print.Constants.*;

public class LoadPrint {
   public static void print()throws Exception {
      Scanner sc = new Scanner(System.in);
      System.out.println("===== 用户登录 =====");
      System.out.println("按9直接返回主界面:");
      System.out.print("请输入用户名：");
      String username = sc.nextLine();
      if(username.equals("9")){
         ConsoleClearScreen.clearScreen();
         AllPrint.Aprint();
         return;
      }

      System.out.print("请输入密码：");
      String password = sc.nextLine();

      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      String sql = "SELECT role FROM users WHERE name = ? AND password = ?";
      try  {
         conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         ps = conn.prepareStatement(sql);
         ps.setString(1, username);
         ps.setString(2, password);
         rs = ps.executeQuery();
               if (rs.next())
               {
                  String role = rs.getString("role");
                  System.out.println("登录成功！你的角色是：" + (role.equals("student") ? "学生" : "老师"));
                  //此处要加入下一个StudentMune()
                  //需要判断老师还是学生
                  if (role.equals("student")) {
                     StudentMenu.print(username);//学生菜单
                  }
                  else{
                     TeacherMenu.print(username);//老师菜单
                  }

               } else
               {
                  System.out.println("用户名或密码错误，请重新登录。");
                  ConsoleClearScreen.clearScreen();
                  print();
               }
            }catch (Exception e) {
         e.printStackTrace();
      }finally {
         rs.close();

          ps.close();

          conn.close();
      }
   }
}