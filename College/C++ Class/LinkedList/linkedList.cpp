/*
 *  Created on: Mar 19, 2018
 *      Author: Master
 */
#include <iostream>

using namespace std;

struct Node {
	int data;
	Node *next;
	Node *last; // Previous one
};

class linked_list {
private:
	Node *head, *tail;
public:
	linked_list() {
		head = NULL;
		tail = NULL;
	}

	void createnode(int value) {
		Node *temp = new Node;
		temp->data = value;
		temp->next = NULL;
		if (head == NULL) {
			head = temp;
			tail = temp;
			temp = NULL;
		} else {
			tail->next = temp;
			tail = temp;
		}
	}

	/* Displays the array head -> tail */
	void prints() {
		Node *temp = new Node;
		temp = head;
		while (temp != NULL) {
			cout << temp->data << " ";
			temp = temp->next;
		}
	}

	void insertStart(int value) {
		Node *temp = new Node;
		temp->data = value;
		temp->next = head;
		head = temp;
	}

	void insert_position(int pos, int value) {
		Node *pre = new Node;
		Node *cur = new Node;
		Node *temp = new Node;
		cur = head;
		for (int i = 1; i < pos; i++) {
			pre = cur;
			cur = cur->next;
		}
		temp->data = value;
		pre->next = temp;
		temp->next = cur;
	}

	/* Delete the head node */
	void removeFirst() {
		Node *temp = new Node;
		temp = head;
		head = head->next;
		delete temp;
	}

	/* Deletes tail node */
	void removeLast() {
		Node *current = new Node;
		Node *previous = new Node;
		current = head;
		while (current->next != NULL) {
			previous = current;
			current = current->next;
		}
		tail = previous;
		previous->next = NULL;
		delete current;
	}

	void delete_position(int pos) {
		Node *current = new Node;
		Node *previous = new Node;
		current = head;
		for (int i = 1; i < pos; i++) {
			previous = current;
			current = current->next;
		}
		previous->next = current->next;
	}

	/* NEED TO DELETE Adds a value to the end */
	void addValue(int val) {
		Node *n = new Node;
		n->data = val;
		n->next = NULL;
		if (head == NULL) { // Is empty
			head = n;
			tail = n;
			n->last = n;
			delete n;
		} else {
			n->last = tail;
			tail->next = NULL;
			tail = n;
		}
	}

	/* Return head value */
	int getHead() {
		return head->data;
	}

	/* Return tail value */
	int getTail() {
		return tail->data;
	}

	/* Checks if empty */
	bool isEmpty() {
		return head == NULL and tail == NULL;
	}

	/* Prints all of the LinkedList values */
	void printing() {

	}
};

int linkedMain() {
	linked_list a;
	for (int i = 0; i < 100; i += 10) {
		a.createnode(i);
	}
	cout << "Head value is " << a.getHead() << endl;
	cout << "Tail value is " << a.getTail() << endl;
	a.removeFirst();
	a.removeLast();
	cout << "Head value is " << a.getHead() << endl;
	cout << "Tail value is " << a.getTail() << endl;
	a.prints();
	cout << endl;
	return 0;
}

