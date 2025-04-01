#ifndef STACK_H
#define STACK_H

// ������ջ�ڵ�ṹ(�洢����)
typedef struct StackNode {
    int data;
   struct  StackNode* next;
} StackNode;

//�洢�����
typedef struct OpStackNode {
    char op;
     struct OpStackNode* next;
}OpStackNode;

// ������ջ�ṹ
typedef struct Stack {
     StackNode* top;
} Stack;



// ������ջ�ṹ(�����)
typedef struct OpStack {
     OpStackNode* top;
} OpStack;



// ��ʼ����ջ
void initOpStack(OpStack* s);

// ��ջ����
void pushOp(OpStack* s, char value);

// �ж���ջ�Ƿ�Ϊ��
int isEmptyOp(OpStack* s);

// ��ջ����
char popOp(OpStack* s);

// ��ȡջ��Ԫ��
char peekOp(OpStack* s);




//�����ǶԴ洢���ֽṹ��Ĳ���





// ��ʼ����ջ
void initStack(Stack* s);

// �ж���ջ�Ƿ�Ϊ��
int isEmpty(Stack* s);

// ��ջ����
void push(Stack* s, int value);

// ��ջ����
int pop(Stack* s);



#endif
