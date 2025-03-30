package com.zuo.print;

import java.sql.SQLException;
import java.util.Scanner;

import com.zuo.studentfunction.ViewOwnMessages;
import com.zuo.teacherfunction.*;


//管理员菜单
public class TeacherMenu {

    public static void print(String name) throws Exception {
        System.out.println("=====管理员菜单======");
        System.out.println("1. 查看所有学生");
        System.out.println("2. 修改学生手机号");
        System.out.println("3. 查询所有课程");
        System.out.println("4. 修改课程学分");
        System.out.println("5. 查看某课程的学生名单");
        System.out.println("6. 查看某学生的选课情况");
        System.out.println("7. 修改密码");
        System.out.println("8. 查看自己的信息");
        System.out.println("9. 退出");
        System.out.println("请选择操作（输入 1-9）：");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            ViewAllStudent.viewStudents();
            print(name);
            return ;
        }else if (choice.equals("2")) {
            UpdatePhone.Update();
            print(name);
            return;
        }else if (choice.equals("3")) {
            ViewAllCourses.viewCourses();
            print(name);
            return;
        }else if (choice.equals("4")) {
            UpdateCreditHour.Update();
            print(name);
            return ;
        }else if (choice.equals("5")) {
            ViewStudentList.viewList();
            print(name);
            return;
        }else if (choice.equals("6")) {
            ViewStudentObject.View();
            print(name);
            return ;
        }else if(choice.equals("7")){
            UpdateKeyTeacher.update(name);
            print(name);
            return ;
        }else if(choice.equals("8")) {
            ViewOwnMessages.view(name);
            print(name);
            return ;
        } else if (choice.equals("9")) {
            return ;
        }else {
           ConsoleClearScreen.clearScreen();
            System.out.println("请输入1到9");
            TeacherMenu.print(name);
            return ;
        }
    }
}
