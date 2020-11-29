/*
 * main.cpp
 *
 *  Created on: Nov 1, 2017
 *      Author: Master
 */

#include <iostream>

using namespace std;

//#include "Function.h"
#include "enum.cpp"

enum mon {
	jan = 1, feb = 3, mar, april, may, jun, jul, aug, sep, oct, nov, dec
} month;


void vers() {
	if (month == feb) {
		cout << "this is it";
	} else if (month == 3) {
		cout << "Number placement also works";
	} else if (month == jan) {
		cout << "Number placement doesn't work";
	} else {
		cout << "itis none of these\n" << month;
	}
}

int main() {
//	cout << "The factorial of 5 is " << factorial(5) << endl;
//	multi();
	month = mar;
	vers();
	return 0;
}

