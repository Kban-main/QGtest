#ifndef STACK_H
#define STACK_H

// 定义链栈节点结构(存储数字)
typedef struct StackNode {
    int data;
   struct  StackNode* next;
} StackNode;

//存储运算符
typedef struct OpStackNode {
    char op;
     struct OpStackNode* next;
}OpStackNode;

// 定义链栈结构
typedef struct Stack {
     StackNode* top;
} Stack;



// 定义链栈结构(运算符)
typedef struct OpStack {
     OpStackNode* top;
} OpStack;



// 初始化链栈
void initOpStack(OpStack* s);

// 入栈操作
void pushOp(OpStack* s, char value);

// 判断链栈是否为空
int isEmptyOp(OpStack* s);

// 出栈操作
char popOp(OpStack* s);

// 获取栈顶元素
char peekOp(OpStack* s);




//以下是对存储数字结构体的操作





// 初始化链栈
void initStack(Stack* s);

// 判断链栈是否为空
int isEmpty(Stack* s);

// 入栈操作
void push(Stack* s, int value);

// 出栈操作
int pop(Stack* s);



#endif
