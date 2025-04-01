#include<stdio.h>
#include<stdlib.h>
#include"calculator.h"
#include<string.h>

char count[100];


int main() {
	
  
    printf("请输入四则运算表达式（支持括号，例如：3+(4*2-1)）：");
    if (fgets(count, sizeof(count), stdin) != NULL) {
        // 去除fgets读取的换行符
        count[strcspn(count, "\n")] = '\0';
        int i = 0;
        while (count[i] != '\0') {
            printf("%c", count[i++]);
        }
        int result = evaluateExpression(count);
        printf("表达式的计算结果是: %d\n", result);
    }
    else {
        printf("输入读取错误\n");
    }

    return 0;


}