#include<stdio.h>
#include<stdlib.h>
#include"Stack.h"





// ��ʼ����ջ
void initStack(Stack* s) {
	s->top = NULL;
}

void initOpStack(OpStack* a) {
	a->top = NULL;
}




// �ж���ջ�Ƿ�Ϊ��
int isEmpty(Stack* s) {
	return s->top == NULL;
}


// �ж���ջ�Ƿ�Ϊ��
int isEmptyOp(OpStack* a) {
	return a->top == NULL;
}

// ��ջ����
void push(Stack* s, int value) {
	
	StackNode* newNode = (StackNode*)malloc(sizeof(StackNode));
	if (newNode == NULL) {
		printf("�����ڴ�ʧ��");
		exit(1);
	}
	else {
		newNode->data = value;
		newNode->next = s->top;
		s->top = newNode;
		
		
	}

}


// ��ջ����
void pushOp(OpStack* s, char value) {
	
	OpStackNode* new = (OpStackNode*)malloc(sizeof(OpStackNode));
	if (new == NULL) {
		printf("�����ڴ�ʧ��");
		exit(1);
	}
	else {
		new->op = value;
		new->next = s->top;
		s->top = new;
		
		
	}

}


// ��ջ����
int pop(Stack* s) {
	if (isEmpty(s)) {
		printf("ջ���ǿյ�,�޷���ջ\n");
		return -1;
	}
	StackNode* temp = s->top;

	int value;
	value=temp->data;
	s->top=temp->next;
	free(temp);
	
	return value;


}



// ��ջ����
char popOp(OpStack* s) {
	if (isEmptyOp(s)) {
		printf("ջ���ǿյ�,�޷���ջ\n");
		return -1;
	}
	OpStackNode* tempop = s->top;
	s->top = tempop->next;
	char outop;
	outop = tempop->op;
	free(tempop);
	return outop;


}




// ��ȡջ��Ԫ��
char peekOp(OpStack* s) {
	if (isEmptyOp(s)) {
		printf("ջ���ǿյ�,�޷���ȡջ��Ԫ��\n");
		return -1;
	}
	return s->top->op;

}
