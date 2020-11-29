/*
 *  Created on: Feb 18, 2018
 *      Author: Master
 */
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <ctime>
#include <string>
using namespace std;

void wr(string filename) {

}

int mains() {
	/* Random generator */
	unsigned int seed = time(0); // Gets system time
//	srand(time(NULL));
	srand(seed); // Seed the random number generator
	int n = 1500; // Number of elements

	/* Creates a random number between -10000 and 100000 */
	const int MIN = -10000;
	const int MAX = 100000;
	int y = rand(); // Rand was calling othe class and crashed

	/* Outputting to a file */
	ofstream outFile;
	outFile.open("randInt.txt");
//	outFile << y << "\n";
	if (outFile.is_open()) {
		for (int i = 0; i < n; i++) {
			y = ((rand() % (MAX - MIN + 1)) - 10000);
			outFile << y;
			outFile << "\n";
		}
		outFile.close(); // Closes the file
	} else {
		cout << "Something screwed up and file writing is not possible.\n";
	}

	return 0;
}
