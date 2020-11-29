// Program 10// 
#include<iostream>
#include<string>
#include <ctime>
//#include <bits/stdc++.h> 

using namespace std;


/* Subhelper for the array */
void swap(int* xp, int* yp)
{
	int temp = *xp;
	*xp = *yp;
	*yp = temp;
}
/* Sorts the array */
void selectionSort(int arr[], int n)
{
	int i, j, min_idx;

	// One by one move boundary of unsorted subarray 
	for (i = 0; i < n - 1; i++)
	{
		// Find the minimum element in unsorted array 
		min_idx = i;
		for (j = i + 1; j < n; j++)
			if (arr[j] < arr[min_idx])
				min_idx = j;

		// Swap the found minimum element with the first element 
		swap(&arr[min_idx], &arr[i]);
	}
}
/* Function to print an array */
void printArray(int arr[], int size) { // Need to come back to this
	int i;
	string row = ""; // 55 55 55 55 56 56 56 56 56 57
//	if It is a multiple of 10:
//		Then print the row
	//
	for (i = 0; i < size; i++) {
		row = to_string(arr[i]);
		if (i % 10 == 0) {
			cout << row << endl;
		}
		//	cout << arr[i] << " ";
	}
	cout << endl;
}

/* Initialize an array of size */
int* initArr(int n)
{
	int* arr = (int*)malloc(sizeof(int*) * n);
	for (int i = 0; i < n; i++) {
		// Randomize a number between 55 and 99 
		arr[i] = (rand() % 44) + 55; //55  to  99
	}
	return arr;
}



/* The main function */
int main() {
	int size = 200;
	int* arr2 = initArr(size);
	selectionSort(arr2, size);
	printArray(arr2, size); // Look over again

	/* Print out the Mean */
	int average = 0;
	int count = 0;
	int total = 0;
	for (int i = 0; i < size; i++) { // Go through the array
		int currentValue = arr2[i];
		count = count + 1;
		total += currentValue;
	}
	cout << "The mean is: ";
	average = total / count;
	cout << average << endl;

	/* Print the variance by (AVG-CURRENT)^2 */
	count = 0; // Number in the array
	total = 0;
	for (int i = 0; i < size; i++) { // Go through the array
		int currentValue = arr2[i]; // ( AVG - CURRENT ) ^2
		currentValue = (average - currentValue);
		currentValue = currentValue * currentValue;
		count = count + 1;
		total += currentValue;
	}
	int variance = total / count;
	cout << "The variance is: ";
	cout << variance << endl;

	/* Print out the median */


	/* Print out the mode (The number that appears most often in a set of numbers)*/
	for (int i = 0; i < size; i++) { // Go through the array
		// Count how many numbers of each number are present in the array
		// Range from 55 to 99
		// Find number with most appearances
	}
	
	/* Create a histogram of the scores */
	cout << endl << endl << "Creating a histogram" << endl << endl;
	cout << to_string(55) << "-" << to_string(59) << "|" << "**" << endl; //    55-59|**

	int minimum = 55;
	int maximum = 59;
	cout << minimum << "-" << maximum << "|";
	for (int i = 0; i < size; i++) { // Go through the array
		if (minimum < maximum) {
			cout << "*";	// Print * for every number found
		}
	// Find every number between minimum and maximum number
	}
	cout << endl;
	

	return 0;
}