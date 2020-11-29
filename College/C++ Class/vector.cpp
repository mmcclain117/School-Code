/*
 *  Created on: Feb 18, 2018
 *      Author: Master
 */
#include <iostream>
#include <vector>
using namespace std;

int vect() {
	vector<int> vec(3); // Automatically Grows

	/* Populate the Vector */
	for (int &q : vec) {
		cout << "Enter an Integer value: ";
		cin >> q;
	}
	vec.push_back(11); // Puts the element at the end
	vec.push_back(12);
	vec.pop_back(); // Removes the last element
	vec[0] = 111; // Can edit if element is there
	vec[4] = 20; // If not real then can't
	cout << vec.size() << " is the size of the vector.\n"; // Get size of array

	/* Prints values of vector */
	for (int val : vec) {
		cout << val << " ";
	}
	cout << "\n";
	vec.clear(); // Resets the vector elements
	cout << (vec.empty() ? "Xs is" : "XS isn't") << " Empty.\n"; // Check if array is empty
	vec[3] = 98;
	return 0;
}

