package com.zuo.print;

import com.zuo.studentfunction.*;

import java.util.Scanner;

//学生菜单
public  class StudentMenu {
 public static void print(String name)throws Exception{
        System.out.println("=====学生菜单======");
        System.out.println("1. 查看可选课程");
        System.out.println("2. 选择课程");
        System.out.println("3. 退选课程");
        System.out.println("4. 查看已选课程");
        System.out.println("5. 修改手机号");
        System.out.println("6. 修改密码");
        System.out.println("7. 查看自己的数据");
        System.out.println("8. 退出");
        System.out.println("请选择操作（输入 1-8）：");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if(choice.equals("1")){
            ViewChoosableCourses.view(name);
            print(name);
            return ;
        }else if(choice.equals("2")){
            ChooseObject.choose(name);
            print(name);
            return ;
        } else if(choice.equals("3")){
            DeletObject.delete(name);
            print(name);
            return ;
        }else if(choice.equals("4")){
            ViewAlreadyChoose.view(name);
            print(name);
            return ;
        }else if(choice.equals("5")){
            UpdatePhoneStudent.update(name);
            print(name);
            return ;
        }else if(choice.equals("6")){
            UpdateKey.update(name);
            print(name);
            return ;
        }else if(choice.equals("7")){
            ViewOwnMessages.view(name);
            print(name);
            return ;
        }else if(choice.equals("8")){
            return;
        }else {
           ConsoleClearScreen.clearScreen();
            System.out.println("输入有误(请输入1到8)");
            StudentMenu.print(name);
            return;
        }
    }

}






