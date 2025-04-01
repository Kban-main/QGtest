
#ifndef CALCULATOR_H
#define CALCULATOR_H

#include "stack.h"

// �ж��ַ��Ƿ�Ϊ�����
int isOperator(char c);

// ��ȡ��������ȼ�
int precedence(char op);

// ִ������
int applyOp(int a, int b, char op);

// ��������������ʽ��ֵ
int evaluateExpression(char* exp);

#endif