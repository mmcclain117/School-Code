#include<iostream>
#include<fstream>
#include<string>
using namespace std;

//function prototype
void TestScoreAnalysis(ifstream& infile);
// sorted in descending order.
void sort(int arr[], int size);
// The lowest score in the array
int lowestScore(int arr[], int size);
//The highest score in the array
int highestScore(int arr[], int size);
//The total number of scores in the array
int totalScore(int arr[], int size);
//The average score in the array.
double averageScore(int arr[], int size);
// The median score in the array.
double medianScore(int arr[], int size);
void print(int arr[], int size);
//main function
int main() {
	//declare file-stream object.
	ifstream fin;
	string name = "Scores.txt";
	//allocate buffer & populate with file data.
	fin.open(name);

	if (fin.fail()) {
		cout << "Bad file \n\n";
		return -2;
	}
	else
		cout << "Good File \n\n";

	TestScoreAnalysis(fin);
	//pause
	system("pause");
	return 0;
}

//function definition

void TestScoreAnalysis(ifstream& infile)
{
	//Allocate an array to hold at least 100 scores.
	int arr[100];
	//counter
	int c = 0;
	//read score form file
	while (infile >> arr[c])
	{
		//update counter
		c++;
	}
	cout << "Scores:\n";
	print(arr, c);
	cout << "Sorted Array: \n";
	sort(arr, c);
	print(arr, c);
	cout << "Lowest score: " << lowestScore(arr, c) << endl;
	cout << "Highest Score: " << highestScore(arr, c) << endl;
	cout << "Total Score: " << totalScore(arr, c) << endl;
	cout << "Average score: " << averageScore(arr, c) << endl;
	cout << "Median score: " << medianScore(arr, c) << endl;
}
void print(int arr[], int size)
{
	//print 5 numbers in a row
	for (int i = 0; i < size; i++)
	{
		cout << arr[i] << " ";
		if ((i + 1) % 10 == 0)
			cout << endl;
	}
	cout << endl;
}
void sort(int arr[], int size)
{
	for (int i = 0; i < size; i++)
	{
		for (int j = i + 1; j < size; j++)
		{
			if (arr[i] < arr[j])
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
}
int lowestScore(int arr[], int size)
{
	int min = arr[0];
	for (int i = 0; i < size; i++)
	{
		if (min > arr[i])
			min = arr[i];
	}
	return min;
}
int highestScore(int arr[], int size)
{
	int max = arr[0];
	for (int i = 0; i < size; i++)
	{
		if (max < arr[i])
			max = arr[i];
	}
	return max;
}
int totalScore(int arr[], int size)
{
	int sum = 0;
	for (int i = 0; i < size; i++)
	{
		sum += arr[i];
	}
	return sum;
}
double averageScore(int arr[], int size)
{
	return (double)totalScore(arr, size) / size;
}
double medianScore(int arr[], int size)
{
	double median;
	if (size % 2 == 0)
		median = ((double)arr[size / 2] + (double)arr[size / 2 - 1]) / 2;
	else
		median = (double)arr[size / 2];
	return median;
}
