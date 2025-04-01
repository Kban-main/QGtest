#include<stdio.h>
#include<stdlib.h>
#include"calculator.h"



// 判断字符是否为运算符
int isOperator(char c) {
	return c == '+' || c == '/' || c == '*' || c == '-';
}

// 获取运算符优先级
int precedence(char op) {
	if (op == '+' || op == '-') {
		return 1;
	}
	if (op == '*' || op == '/') {
		return 2;
	}
	return 0;
}

// 执行运算
int applyOp(int a, int b, char op) {
	switch (op) {
	case '+': return a + b;
		
	case '-': return a - b;
	case '*':  return a * b;
	case '/':
		if (b == 0) {
			printf("除数不能为零\n");
			exit(1);
		}
		return a/b;
	default:return 0;
	}
	return 0;
}

// 计算四则运算表达式的值
int evaluateExpression(char* exp) {
	Stack  numstack;
	OpStack opstack;
	initOpStack(&opstack);
	initStack(&numstack);
	
	int i = 0;
	while (exp[i] != '\0') {
        //处理数字
		if (exp[i] >= '0' && exp[i] <= '9') {
			int num = 0;
			while (exp[i] >= '0' && exp[i] <= '9') {
				num = num * 10 + exp[i] - '0';
				i++;
			}
			push(&numstack, num);
			i--;//上面加了一个
		}else if (exp[i] == '(')  {
            //处理'('
			pushOp(&opstack, exp[i]);
		}else if (exp[i] == ')') {
			//处理')'
			while (!isEmptyOp(&opstack) && peekOp(&opstack)!='(') {
				int val2 = pop(&numstack);
				int val1 = pop(&numstack);
				char op = popOp(&opstack);
				push(&numstack, applyOp(val1, val2, op));

			}
			popOp(&opstack);//弹出左括号
		} 
		else if (isOperator(exp[i])) { 
			//处理运算符
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
	//处理剩余运算符
	while (!isEmptyOp(&opstack)) {
		int val2 = pop(&numstack);
		int val1 = pop(&numstack);
		char op = popOp(&opstack);
		push(&numstack, applyOp(val1, val2, op));

	}


	
	
	return pop(&numstack);
		


}



