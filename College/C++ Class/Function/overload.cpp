/*
 *  Created on: Feb 18, 2018
 *      Author: Master
 */
#include<iostream>
#include<string>
using namespace std;

void add(int, int);
void add(double, double); // Overloading statement

int overload() {
	add(1, 2);
	add(1.2, 2.1);
	return 0;
}

void add(int a, int b) {
	cout << (a + b) << "\n";
}

void add(double a, double b) {
	double q = a + b;
	cout << to_string(q) << "\n";
}
