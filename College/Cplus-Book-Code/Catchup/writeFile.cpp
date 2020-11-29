/*
 *  Created on: Feb 19, 2018
 *      Author: Master
 */
#include <fstream>
using namespace std;

int writeFile() {
	/* Outputting to a file */
	ofstream outFile;
	outFile.open("File.txt");
//	ofstream outFile("File.txt"); // Alternative

	outFile << "Writting first line\n";
	outFile << "Second line\r"; // \r works on reading but not viewing output
	outFile << "\n"; // So just use \n
	outFile << "Final Line\n";
	outFile << "Just Kidding\n";
	outFile << "Here is the last line\n";
	outFile.close(); // Closes the file
	return 0;
}

