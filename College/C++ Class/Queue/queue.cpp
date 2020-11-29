/*
 *  Created on: Mar 19, 2018
 *      Author: Master
 */
#include <iostream>
#include <cstdlib>
using namespace std;

const int MAX_SIZE = 50;

/* Element is past the tail or MAX_Size */
class QueueOverFlowException {
public:
	QueueOverFlowException() {
		cout << "Queue overflow\n";
	}
};

/* Deals with element is before head */
class QueueEmptyException {
public:
	QueueEmptyException() {
		cout << "Queue is empty\n";
	}
};

class ArrayQueue {
private:
	int data[MAX_SIZE];
	int head; // First element index
	int tail; // Last element index
public:
	ArrayQueue() {
		head = -1;
		tail = -1;
	}

	/* Enqueues an element to the end */
	void Enqueue(int element) {
		if (size() == MAX_SIZE - 1) {
			throw new QueueOverFlowException();
		}
		data[tail] = element;
//		tail = ++tail % MAX_SIZE; // Wrap around for data problems
		int tem = tail + 1;
		tail = tem % MAX_SIZE;
	}

	/* Returns the head Index */
	int getHead() {
		return head;
	}

	/* Shows the problem with the program
	 * Breaks by accessing an element before head
	 */
	int breaking() {
		return data[head - 1];
	}

	/* Removes the first element */
	int Dequeue() {
		if (isEmpty()) {
			throw new QueueEmptyException();
		}
		int ret = data[head];
//		head = ++head % MAX_SIZE; // Wrap around for data problems
		int temp = head + 1;
		head = temp % MAX_SIZE;
		return ret;
	}

	/* Returns head value */
	int Front() {
		if (isEmpty()) {
			throw new QueueEmptyException();
		}
		return data[head];
	}

	/* Returns the size */
	int size() {
		return abs(tail - head);
	}

	/* Returns if it is empty */
	bool isEmpty() {
//		return (head == tail) ? true : false;
		return size() <= 0;
	}

	/* Prints the Queue */
	void print() {
		int dHead = head;
		while(dHead < tail) {
			cout << data[dHead++] << " ";
		}
		cout << endl;
	}

	/* Clears the array */
	void clears() {
		for(int i =0;i < MAX_SIZE;i++) {
			data[i] = 0;
		}
		head = -1;
		tail = -1;
	}

	/* In case head went to far (Added to many elements) */
	/* Would like to just move a pointer but don't know how to do that */
	void reSize() {

	}
};

int ArQueue() {
	ArrayQueue q;
	try {
		cout << "It is " << (q.isEmpty() ? "" : "not ") << "empty\n";
		int temp;
		for (int i = 0; i < 100; i++) { // Randomly populates the Queue
			temp = rand();
			if (rand() % 50 == 0) { // DeQueue one if divisible by 15
				cout << q.Dequeue() << " has been deQueued\n";
			} else {
				q.Enqueue(temp);
				cout << temp << " has been Queued\n";
			}
			if(q.size() == 98) { // Trim it down some
				for(int o = 0; o < 10;o++) {
					q.Dequeue();
				}
			}
		}
		q.print();
		cout << "Returning before head returns " << q.breaking() << endl;
		cout << "Size of queue = " << q.size() << endl;
		cout << "Front value is " <<q.Front() << endl;
		cout << "Head index is " << q.getHead() << endl;
		cout << "It is " << (q.isEmpty() ? "" : "not ") << "empty\n";
		q.clears();
		cout << "It is " << (q.isEmpty() ? "" : "not ") << "empty\n";
		q.Enqueue(10);
		q.Enqueue(20);
		q.Enqueue(30);
		q.Enqueue(40);
		cout << q.Dequeue() << endl;
		q.print();
	} catch (...) {
		cout << "You done goof and Terminating it because of you\nThanks a lot";
	}
	return 0;
}
