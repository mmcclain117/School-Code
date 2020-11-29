/*
 *  Created on: Feb 19, 2018
 *      Author: Master Ward
 */

#include <iostream>
#include <cstring> // Needed for commands
using namespace std;

int charchange() {
	char c = 'c';
	cout << "isupper() " << (isupper(c) ? "Yes" : "No") << endl; // Check casing
	cout << "toupper() " << (char) toupper(c) << endl; // Changes casing
	cout << "isalpha() " << (isalpha(c) ? "Yes" : "No") << endl; // Checks alphanumberic
	cout << "isupper() on * = " << (char) toupper('*') << endl; // Doesn't change
	char ch[100] = "this puts string into a char array";
	cout << ch << endl; // Prints the array
	char ch2[] = "The other array that testing";

	/* String functions */
	cout << strlen(ch) << endl; // Gets length of string/char array
	strcat(ch, ch2); // Concatinates the strings
	cout << ch << endl;
	char *chrPtr = nullptr;
	chrPtr = strstr(ch, "the"); // Searches a string for that word
	cout << chrPtr << endl; // Has too match casing
	if (strcmp(ch, ch2) == 0) {
		cout << "This compares the strings" << endl;
	}

	/* Conversion of Data Types */
	int num = atoi("1001"); // String to Int
	long bN = atol("500000"); // String to Long
	double dum = atof("12.89"); // String to Double
	float flow = atof("3.4"); // String to Float
	cout << "\nCause I hate the yellow lines" << endl;
	cout << "Int: " << num << endl << "Long: " << bN << endl;
	cout << "Double: " << dum << endl << "Float: " << flow << endl;

	/* Problem Solving an amount to Money */
	string currancy = "1029302.85";
	int dp = currancy.find('.');
	if (dp > 3) {
		for (int x = dp - 3; x > 0; x -= 3) {
			currancy.insert(x, ",");
		}
		currancy.insert(0, "$");
	}
	cout << currancy << endl;
	return 0;
}
