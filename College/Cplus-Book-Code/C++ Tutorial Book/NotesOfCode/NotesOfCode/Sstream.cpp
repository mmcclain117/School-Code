/*
 * Sstream.cpp
 *
 *  Created on: Nov 1, 2017
 *      Author: Master
 */
#include <iostream>
#include <sstream>
using namespace std;

#include "Function.h"

/**
 * String Stream Example:
 * Easy way of converting a string into an int
 */
void sstreams() {
	string mystr;
	float price = 0;
	int quantity = 0;
	cout << "Enter price: ";
	getline(cin, mystr);
	stringstream(mystr) >> price;
	cout << "Enter quantity: ";
	getline(cin, mystr);
	stringstream(mystr) >> quantity;
	cout << "Total price: " << price * quantity << endl;
}



