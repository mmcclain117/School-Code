/*
 *  Created on: Feb 18, 2018
 *      Author: Master
 */
#include <iostream>
#include<iomanip> // For setprecision, showpoint, fixed
using namespace std;

int precision() {
	double t = 10.2134;

	/* Using different printout formatation*/
	cout << setprecision(3) << t << endl; // Set precision before Decimal
	cout << setprecision(8) << showpoint << t << endl; // Adds Trailing zeros
	cout << setprecision(3) << fixed << t << endl; // Set precision after Decimal

	return 0;
}

