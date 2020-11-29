/*
 * Nullterm.cpp
 *
 *  Created on: Nov 1, 2017
 *      Author: Master
 */
#include <iostream>
#include <string>
using namespace std;

#include "Function.h"

void nullTerm() {
	char question[] = "Please, enter your first name: ";
	char greeting[] = "Hello, ";
	char yourname[80];
	cout << question;
	cin >> yourname;
	cout << greeting << yourname << "!";
	yourname[2] = '\0';
	cout << "Edited, " << yourname << "!";
}
