#include<stdio.h>
#include<stdlib.h>
#include"Stack.h"





// 初始化链栈
void initStack(Stack* s) {
	s->top = NULL;
}

void initOpStack(OpStack* a) {
	a->top = NULL;
}




// 判断链栈是否为空
int isEmpty(Stack* s) {
	return s->top == NULL;
}


// 判断链栈是否为空
int isEmptyOp(OpStack* a) {
	return a->top == NULL;
}

// 入栈操作
void push(Stack* s, int value) {
	
	StackNode* newNode = (StackNode*)malloc(sizeof(StackNode));
	if (newNode == NULL) {
		printf("分配内存失败");
		exit(1);
	}
	else {
		newNode->data = value;
		newNode->next = s->top;
		s->top = newNode;
		
		
	}

}


// 入栈操作
void pushOp(OpStack* s, char value) {
	
	OpStackNode* new = (OpStackNode*)malloc(sizeof(OpStackNode));
	if (new == NULL) {
		printf("分配内存失败");
		exit(1);
	}
	else {
		new->op = value;
		new->next = s->top;
		s->top = new;
		
		
	}

}


// 出栈操作
int pop(Stack* s) {
	if (isEmpty(s)) {
		printf("栈链是空的,无法出栈\n");
		return -1;
	}
	StackNode* temp = s->top;

	int value;
	value=temp->data;
	s->top=temp->next;
	free(temp);
	
	return value;


}



// 出栈操作
char popOp(OpStack* s) {
	if (isEmptyOp(s)) {
		printf("栈链是空的,无法出栈\n");
		return -1;
	}
	OpStackNode* tempop = s->top;
	s->top = tempop->next;
	char outop;
	outop = tempop->op;
	free(tempop);
	return outop;


}




// 获取栈顶元素
char peekOp(OpStack* s) {
	if (isEmptyOp(s)) {
		printf("栈链是空的,无法获取栈顶元素\n");
		return -1;
	}
	return s->top->op;

}
