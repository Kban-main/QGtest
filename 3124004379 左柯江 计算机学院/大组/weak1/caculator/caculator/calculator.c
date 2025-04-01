#include<stdio.h>
#include<stdlib.h>
#include"calculator.h"



// �ж��ַ��Ƿ�Ϊ�����
int isOperator(char c) {
	return c == '+' || c == '/' || c == '*' || c == '-';
}

// ��ȡ��������ȼ�
int precedence(char op) {
	if (op == '+' || op == '-') {
		return 1;
	}
	if (op == '*' || op == '/') {
		return 2;
	}
	return 0;
}

// ִ������
int applyOp(int a, int b, char op) {
	switch (op) {
	case '+': return a + b;
		
	case '-': return a - b;
	case '*':  return a * b;
	case '/':
		if (b == 0) {
			printf("��������Ϊ��\n");
			exit(1);
		}
		return a/b;
	default:return 0;
	}
	return 0;
}

// ��������������ʽ��ֵ
int evaluateExpression(char* exp) {
	Stack  numstack;
	OpStack opstack;
	initOpStack(&opstack);
	initStack(&numstack);
	
	int i = 0;
	while (exp[i] != '\0') {
        //��������
		if (exp[i] >= '0' && exp[i] <= '9') {
			int num = 0;
			while (exp[i] >= '0' && exp[i] <= '9') {
				num = num * 10 + exp[i] - '0';
				i++;
			}
			push(&numstack, num);
			i--;//�������һ��
		}else if (exp[i] == '(')  {
            //����'('
			pushOp(&opstack, exp[i]);
		}else if (exp[i] == ')') {
			//����')'
			while (!isEmptyOp(&opstack) && peekOp(&opstack)!='(') {
				int val2 = pop(&numstack);
				int val1 = pop(&numstack);
				char op = popOp(&opstack);
				push(&numstack, applyOp(val1, val2, op));

			}
			popOp(&opstack);//����������
		} 
		else if (isOperator(exp[i])) { 
			//���������
			while (!isEmptyOp(&opstack) && precedence(peekOp(&opstack)) >= precedence((exp[i]))) {
				int val2 = pop(&numstack);
				int val1 = pop(&numstack);
				char op = popOp(&opstack);
				push(&numstack, applyOp(val1, val2, op));
			}
			pushOp(&opstack, exp[i]);
		}
		i++;
	}
	//����ʣ�������
	while (!isEmptyOp(&opstack)) {
		int val2 = pop(&numstack);
		int val1 = pop(&numstack);
		char op = popOp(&opstack);
		push(&numstack, applyOp(val1, val2, op));

	}


	
	
	return pop(&numstack);
		


}



