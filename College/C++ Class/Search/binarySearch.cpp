///*
// *  Created on: Feb 19, 2018
// *      Author: Master
// */
//
//#include <iostream>
//#include <vector>
//#include <fstream>
//#include <array>
//#include <algorithm>
//using namespace std;
//
//int BinarySearch(int[], int, int);
//
//int binarysearch() {
//	/* Populating a vector */
//	ifstream in;
//	in.open("randInt.txt");
//	vector<int> vc; // Temporary reading in vector
//	vc.begin();
//	int x;
//	while (in >> x) {
//		vc.push_back(x);
//	}
//	in.close();
//
//	/* Start of the program */
//	int ar[vc.size()];
//	sort(vc.begin(), vc.end()); // Sorts to make Binary Search Possible
//	copy(vc.begin(), vc.end(), ar); // Duplicate vc to ar
//	int value = 50; // Value searching for
//	int result = BinarySearch(ar, sizeof(ar) / 4, value); // Index of element
//	if (result == -1) { // Element is not found
//		cout << "Element " << value << " cannot be found. What a shame\n";
//	} else {
//		cout << "The Element " << value << " was found at " << result << "\n";
//	}
//	return 0;
//}
//
///* Searches through the array with runtime of O(log(n)) */
//int BinarySearch(int array[], int size, int value) {
//	int first = 0;
//	int last = size - 1;
//	int middle;
//	int index = -1;
//	bool found = false;
//	while (!found && first <= last) {
//		middle = (first + last) / 2;
//		if (array[middle] == value) {
//			found = true;
//			index = middle;
//		} else if (array[middle] > value) { // If value is in lower half
//			last = middle - 1;
//		} else { // If value is in upper half
//			first = middle + 1;
//		}
//	}
//	return index;
//}
