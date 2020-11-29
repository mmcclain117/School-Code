/*
 *  Created on: Feb 18, 2018
 *      Author: Master
 */
#include<iostream>
#include<string>
using namespace std;

// Default argument (What happens if nothing is given
void taxes(int cost = 10, double r = 8.25);

int defarg() {
	taxes(); // Uses both default arguments
	taxes(11); // Uses default rate
	taxes(10, 8); // No default used
	//system("pause");
	return 0;
}
void taxes(int a, double b) {
	double x = 1 + b;
	cout << (to_string(a * x)) << "\n";
}

