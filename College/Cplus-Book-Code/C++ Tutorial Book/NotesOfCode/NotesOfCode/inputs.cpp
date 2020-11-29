/*
 * inputs.cpp
 *
 *  Created on: Nov 1, 2017
 *      Author: maste
 */
#include <iostream>
using namespace std;

#include "Function.h"

void inputs() {
	int age;
	cin >> age;
	cout << "I'm " << age << " years old\n";
	string myString;
	cout << "this line\n";
	cin >> myString;
	cout << "c works at extracting the string " << myString + "\n";
	getline(cin, myString);
	getline(cin, myString);
	cout << "But getline also extracts " << myString;
}
