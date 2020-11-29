/*
 *  Created on: Feb 18, 2018
 *      Author: Master
 */
#include <iostream>
using namespace std;

int reo(int&); // adds to
int reo(int, int); // Adds

int reFunct() {
	int val = 1;
	int ab = 2;
	cout << "Before val is " << val << "\n";
	reo(val);
	cout << "Called reo(&) is " << val;
	reo(val);
	cout << " to " << val << "\n";
	val = 1;
	cout << "Before val is " << val << "\n";
	reo(val);
	cout << "Called reo(i,i) is " << val;
	reo(val, ab);
	cout << " to " << val << "\n";
	return 0;
}

int reo(int &a) {
	a *= 2;
	return a;
}
int reo(int a, int b) {
	a *= b;
	return a;
}
