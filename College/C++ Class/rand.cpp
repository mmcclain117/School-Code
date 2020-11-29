/*
 *  Created on: Feb 18, 2018
 *      Author: Master
 */
#include<iostream>
#include<cstdlib> // For rand and srand
#include<ctime> // For time
#include<string> // Used to print out strings
using namespace std;

int rands() {
	/* Random generator */
	unsigned int seed = time(0); // Gets system time
	srand(seed); // Seed the random number generator
	//  srand(1);  Setting srand to a specific seed creates same number everytime
	cout << rand() << endl; // First random number
	cout << rand() << endl; // Second random number
	/* Creates a random number between 10 and 80 */
	const int MIN = 10;
	const int MAX = 80;
	double y = (rand() % (MAX - MIN + 1)) + MIN;
	cout << y << "\n";

	/* if statements*/
	const int x = 3, z = 5;
	if (x == 2 or y == 4) {  // same as x == 2 || y == 4
		cout << "Made it to the first statement";
	} else if (x == 3 and z != 5) {  // same as x == 3 && not y==5
		cout << "It got to here";
	} else {
		cout << "Good to add to catch any exceptions";
	}

	return 0;
}
