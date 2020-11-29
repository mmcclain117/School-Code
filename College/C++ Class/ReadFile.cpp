/*
 *  Created on: Feb 18, 2018
 *      Author: Master
 */
#include<iostream>
#include<fstream> // For input and Output file
using namespace std;

int readFile() {

	/* Reading from a file */
	ifstream inFile;
	inFile.open("File.txt");
//	ifstream inFile("File.txt"); // Alterative
	string s = "";
	inFile >> s; // Reads word from file
	while (inFile >> s) { // While still reading in words
		cout << s << endl;
	}

	/* Checking File open Errors */
	if (inFile) {
		cout << "Successfully opened the file";
	} else {
		cout << "Error when opening the file\n";
	}
	cout << "Closing file now\n";
	inFile.close();
	system("pause");
	return 0;
}

