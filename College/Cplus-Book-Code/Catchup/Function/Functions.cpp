/*
 *  Created on: Feb 18, 2018
 *      Author: Master
 */
#include<iostream>
#include<fstream> // Numb.close fix
using namespace std;

/* Used to call a method written after main*/
void writeNumb(int); // Function prototype

/* Global Variables (Accessed anywhere */
int duo = 100;
const double rate = 1.0825; // Constant Global

int Functions() {

	/* Function Call */
	writeNumb(6);
	return 0;
}

/* Used to make a file with random numbers generated from seed */
void writeNumb(int seed) { // Function header
	ofstream numb("Numbers.txt");
	int q = 0;
	for (; q < 20; q++) {
		numb << (rand() / 1) << "\n";
	}
	numb.close();
}

