/*
 *  Created on: Mar 19, 2018
 *      Author: Master
 */
#include <iostream>
using namespace std;

#define MAX 1000 // Max size Stack can be

class Stack {
	int lastEl; // Index of Last element
public:
	int ar[MAX];
	Stack() {
		lastEl = -1;
	}
	bool push(int x);
	int pop();
	bool isEmpty();
	void print();
	int getSize();
};

/* Puts element on the stack */
bool Stack::push(int x) {
	if (lastEl >= MAX) {
		cout << "Stack Overflow";
		return false;
	} else {
		ar[++lastEl] = x;
		return true;
	}
}

/* Takes off the top element */
int Stack::pop() {
	if (lastEl < 0) {
		cout << "Stack Underflow";
		return 0;
	} else {
		return ar[lastEl--];
	}
}

/* If there are No elements */
bool Stack::isEmpty() {
	return (lastEl < 0);
}

/* Prints out the Stack by popping */
void Stack::print() {
	int tempPoint = lastEl; // Temporary Pointer to element
	while(tempPoint > 0) {
		cout << ar[tempPoint--] << " ";
	}
	cout << endl;
}
int Stack::getSize() {
	return lastEl;
}

// Driver program to test above functions
int Stacks() {
	struct Stack s;
	for(int i = 0; i < 100;i++) { // Randomly populates the Stack
		int temp = rand();
		if(rand() % 15 == 0) { // Pops if divisible by 15
			cout << s.pop() << " Has been popped from stack\n";
		} else {
			s.push(temp);
			cout << temp << " has been added\n";
		}
	}
	s.print();
	return 0;
}
