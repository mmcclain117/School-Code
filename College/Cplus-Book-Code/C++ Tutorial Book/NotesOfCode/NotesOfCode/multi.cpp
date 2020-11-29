/*
 * multi.cpp
 *
 *  Created on: Oct 25, 2017
 *      Author: Master
 */
#include <iostream>
using namespace std;

#include "Function.h"

#define WIDTH 5
#define HEIGHT 3

int jimmy[HEIGHT][WIDTH];
int n, m;

int multi() {
	for (n = 0; n < HEIGHT; n++)
		for (m = 0; m < WIDTH; m++)
			jimmy[n][m] = (n + 1) * (m + 1);

//	Prints out
	for (n = 0; n < HEIGHT; n++) {
		for (m = 0; m < WIDTH; m++)
			cout << jimmy[n][m] + " ";
		cout << "\n";
	}
	return 0;
}
