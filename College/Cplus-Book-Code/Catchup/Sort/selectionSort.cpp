///*
// *  Created on: Feb 19, 2018
// *      Author: Master
// */
//#include <iostream>
//#include <fstream>
//#include <vector>
//using namespace std;
//
//void SelectionSort(int[], int);
//
//int selectionsort() {
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
//	/* Start of the Program */
//	int ar[vc.size()];
//	copy(vc.begin(), vc.end(), ar);
//	cout << "Unsorted array: ";
//	for (int i = 0; i < 10; i++) {
//		cout << ar[i] << " ";
//	}
//	SelectionSort(ar, sizeof(ar) / 4);
//	cout << "\nSorted array: ";
//	for (int i = 0; i < 10; i++) {
//		cout << ar[i] << " ";
//	}
//	return 0;
//}
//
///* Sorts as selecting lowest one and switching. Runtime: O(n^2) */
//void SelectionSort(int array[], int size) {
//	int minIndex, minValue;
//	for (int startIndex = 0; startIndex < (size - 1); startIndex++) {
//		minIndex = startIndex;
//		minValue = array[startIndex];
//		for (int curIndex = startIndex + 1; curIndex < size; curIndex++) { // Internal Iterator
//			if (array[curIndex] < minValue) { // If smaller value
//				minValue = array[curIndex];
//				minIndex = curIndex;
//			}
//		}
//		array[minIndex] = array[startIndex];
//		array[startIndex] = minValue;
//	}
//}
