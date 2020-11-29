/*
 *  Created on: Feb 18, 2018
 *      Author: Master
 */
#include<iostream>
#include<fstream>
using namespace std;

void doubleVal(int[]);
void dVal(const int[]);

int array() {
	string qr[10] = { "partially", "filling", "array" };
	/* Putting the file inputs into an array */
	ifstream in;
	in.open("File.txt");
	int count = 0;
	while (count < 10 && in >> qr[count]) {
		count++;
	}
	in.close();
	string q[] = { "this ", "is ", "the ", "array ", "List ", "That ",
			"is auto ", "adjusting" };
	for (string i : q) { // Printing out the array
		cout << i;
	}
	cout << "\n";
	int numbEl = 5; // Number of Elements
	int ar[numbEl]; // Initialize the array
	for (int count = 0; count < numbEl; count++) {
		ar[count] = count;
	}
	doubleVal(ar);
	doubleVal(ar);
	for (int p : ar) {
		cout << p << " ";
	}
	cout << endl;
	return 0;
}

/* Double the values of an array (Also returns them to that original array */
void doubleVal(int gg[]) {
	int count;
	int qs = 5;
	for (count = 0; count < qs; count++) {
		gg[count] *= 2;
	}
}

/* Doesn't Change the values of the array */
void dVal(const int gg[]) {
	int count;
	int qs = 5;
	for (count = 0; count < qs; count++) {
//		gg[count] *= 2; // Can't because it is a read only array
		cout << gg[count] << " ";
	}
}
