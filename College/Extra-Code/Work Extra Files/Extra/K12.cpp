#include <iostream>
#include <string>	
#include<cctype>
#include <cstring>
using namespace std;

//Function prototype
int Countchar(string);
void backward(char*);



//Main function
int main()
{
	string input;
	int totalcount;
	char string[50];

	cout << "Please enter a String: ";
	cin >> input;
	totalcount = Countchar(input);
	cout << "Total number of characters in the string " << input << " is: " << totalcount << endl;

	cout << "Please enter a string :" << endl;

	// display string entered backwards
	cin >> string;

	cout << "The entered string displayed in backward is ";

	backward(string); //calling backward function

	system("pause");
	return 0;
}

int Countchar(string words) {
	int totalcount = 0, i = 0;
	while (words[i] != '\0') {
		totalcount++;
		i++;
	}
	return totalcount;
}


void backward(char* strPtr) //Define the backward function
{
	char* k = strPtr;
	while (*k != '\0') {
		++k;
	}
	while (k != strPtr) {
		cout.put(*--k);
	}
}