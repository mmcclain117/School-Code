/*
 * loops.cpp
 *
 *  Created on: Nov 1, 2017
 *      Author: Master
 */
#include <iostream>
using namespace std;

#include "Function.h"

void loops() {
	int q = 0;
	while (q < 10) {
		cout << q + ", ";
		q++;
	}
	cout << "\n";
	do {
		if (q == 5)
			continue;
		else if (q == 0)
			cout << "FIRE";
		cout << q + ", ";
		q--;
	} while (q > 0);
	for (int i = 0; i < 10; i++) {
		if (i % 2 == 0)
			cout << "Even\n";
		else
			cout << "Odd\n";
	}
}
