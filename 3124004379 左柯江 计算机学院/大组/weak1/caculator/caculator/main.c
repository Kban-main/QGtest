#include<stdio.h>
#include<stdlib.h>
#include"calculator.h"
#include<string.h>

char count[100];


int main() {
	
  
    printf("����������������ʽ��֧�����ţ����磺3+(4*2-1)����");
    if (fgets(count, sizeof(count), stdin) != NULL) {
        // ȥ��fgets��ȡ�Ļ��з�
        count[strcspn(count, "\n")] = '\0';
        int i = 0;
        while (count[i] != '\0') {
            printf("%c", count[i++]);
        }
        int result = evaluateExpression(count);
        printf("���ʽ�ļ�������: %d\n", result);
    }
    else {
        printf("�����ȡ����\n");
    }

    return 0;


}