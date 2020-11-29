/*
 *  Created on: Feb 19, 2018
 *      Author: Master
 */
#include <iostream>
#include <vector>
#include <fstream>
using namespace std;

void insertSort(int[], int);

/* NOT DONE */

int insertionsort() {
	/* Populating a vector */
	ifstream in;
	in.open("randInt.txt");
	vector<int> vc; // Temporary reading in vector
	vc.begin();
	int x;
	while (in >> x) {
		vc.push_back(x);
	}
	in.close();
	/* Start of the code */

	return 0;
}

void insertSort(int array[], int size) {

}

