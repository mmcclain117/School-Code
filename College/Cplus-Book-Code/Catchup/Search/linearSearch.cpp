/*
 *  Created on: Feb 19, 2018
 *      Author: Master
 */

#include<iostream>
#include <vector>
#include <fstream>
#include <array>
using namespace std;

int LinearSearch(int[], int, int);

int linearsearch() {
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

	/* Start of the program */
	int ar[vc.size()];
	copy(vc.begin(), vc.end(), ar); // Duplicate vc to ar
	int value = 501; // Value searching for
	int result = LinearSearch(ar, sizeof(ar) / 4, value); // Index of element
	if (result == -1) { // Element is not found
		cout << "Element " << value << " cannot be found. What a shame\n";
	} else {
		cout << "The Element " << value << " was found at " << result << "\n";
	}
	return 0;
}

/* Searches through the array with runtime of O(n) */
int LinearSearch(int array[], int size, int value) {
	int index = -1;
	for (int i = 0; i < size; i++) {
		if (array[i] == value) {
			if (index != -1) { // Already found the element
				cout << "Duplicate element found at " << i << "\n";
			} else {
				index = i;
			}
		}
	}
	return index;
}

