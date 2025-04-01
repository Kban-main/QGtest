
#ifndef CALCULATOR_H
#define CALCULATOR_H

#include "stack.h"

// 判断字符是否为运算符
int isOperator(char c);

// 获取运算符优先级
int precedence(char op);

// 执行运算
int applyOp(int a, int b, char op);

// 计算四则运算表达式的值
int evaluateExpression(char* exp);

#endif