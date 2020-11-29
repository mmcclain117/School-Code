/*
 *  Created on: Feb 19, 2018
 *      Author: Master Ward
 */
#include <iostream>
#include <fstream>
#include <vector>
using namespace std;

void BubbleSort(int[], int);

int bubblesort() {
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
	/* Start of program */
	int ar[vc.size()];
	copy(vc.begin(), vc.end(), ar);
	BubbleSort(ar, vc.size());
	for (unsigned int i = 0; i < 100; i++) {
		cout << ar[i] << " ";
	}
	return 0;
}
/* Sorts an array Ascendingly */
void BubbleSort(int array[], int size) {
	bool swap;
	int temp;
	do {
		swap = false;
		for (int i = 0; i < size - 1; i++) {
			if (array[i] > array[i + 1]) { // Sorting ascending
//			if(array[i] < array[i+1]) { // Sorts Descending
				temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
				swap = true;
			}
		}
	} while (swap);
}

