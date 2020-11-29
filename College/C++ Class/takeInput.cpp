/*
 *  Created on: Feb 18, 2018
 *      Author: Master Ward
 */
#include<iostream>
using namespace std;

int takeInput() {
	/* Different ways to take input */
	char ch;
	cin >> ch;
	cout << "\nFirst Input: " << ch << "\n";
	cin.ignore(); // Ignores the newline (\n or [enter])
	cin.get(ch);
	cout << "\nSecond Input: " << ch << "\n";
	ch = cin.get(); // No output
	cout << "\nThird Input: " << ch << "\n";

	system("pause");
	return 0;
}
