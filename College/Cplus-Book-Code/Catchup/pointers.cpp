/*
 *  Created on: Feb 19, 2018
 *      Author: Master Ward
 */
#include <iostream>
#include <string>
#include <memory> // Used for smart pointers
using namespace std;

/* Take into note that array pointers are not always sorted */

string *getFullName(string[]);

int pointing() {
	int x[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50 };
	int *ptr = nullptr;
	ptr = x;

	/* Illegal because not Compatible data types
	 * float myFloat;
	 * int *ft = &myFloat;
	 */

	int size = static_cast<int>(sizeof(x) / 4);
//	int *pint = &size;
	for (int count = 0; count < size; count++) {
		cout << *(x + count) << " ";
	}
	cout << endl << "Is the same as\n";
	for (int count = 0; count < size; count++) {
		cout << x[count] << " ";
	}
	cout << endl << "And can use PTR reference\n";
	for (int count = 0; count < size; count++) {
		cout << *ptr << " ";
		ptr++;
	}
	cout << *ptr << endl << endl;
	delete ptr; // Can only delete pointers
//	ptr = 12; // Can't Change the type
	cout << *ptr << endl;
	string fn[3];
	string *arr = getFullName(fn);
//	cout << sizeof(arr); // Accurate on the size for once
	for (int count = 0; count < 3; count++) {
		cout << *arr++;
	}

	/* Smart pointers: Delete when done */
	unique_ptr<int> po(new int);
	*po = 99; // Needs * to declare pointer
	cout << *po << endl;
	return 0;
}

/* Find the full name and return pointer to it */
string *getFullName(string fullname[]) {
	cout << "Enter first name: " << endl;
	fullname[0] = "John\n";
	cout << "Enter middle name: " << endl;
	fullname[1] = "Long\n";
	cout << "Enter last name: " << endl;
	fullname[2] = "Board\n";
	return fullname;
}
