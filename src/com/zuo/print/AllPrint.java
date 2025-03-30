package com.zuo.print;

import java.util.Scanner;

public class AllPrint {


    public  static void Aprint() throws Exception {
        System.out.println("============");
        System.out.println("学生选课管理系统");
        System.out.println("============");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("3.退出");
        System.out.println("请选择操作(输入1-3)");

        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        if(input.equals("1")){
            LoadPrint.print();
        }else if(input.equals("2")){
            RegisterPrint register=new RegisterPrint();
            register.Print();
            //清个屏先
            ConsoleClearScreen.clearScreen();
            Aprint();
        }else if(input.equals("3")){
            return;
        }else {
            ConsoleClearScreen.clearScreen();
            System.out.println("输入异常,请输入1到3");
            AllPrint.Aprint();
            return;
        }




    }



}
