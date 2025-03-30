package com.zuo.print;
import java.io.IOException;

public class ConsoleClearScreen {
    public static void clearScreen() {
        try {
            // 获取当前操作系统名称
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // 如果是 Windows 系统，调用 cmd 命令清屏
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // 如果是 Linux 或 macOS 系统，使用 ANSI 转义序列清屏
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}