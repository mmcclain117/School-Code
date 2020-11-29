/*
 *  Created on: Feb 18, 2018
 *      Author: Master
 */
#include <iostream>
using namespace std;

int multiarray() {
	const int numbColumn = 4;
	const int numbRow = 6;
	double scores[numbColumn][numbRow] = { { 1, 2, 3, 4, 5 }, { 1, 2, 0, 0, 2 },
			{ 4, 4, 2, 1991, 2 } };
	double total;
	/* Average of each row */
	for (int row = 0; row < numbColumn; row++) {
		total = 0;
		// Sum of row
		for (int col = 0; col < numbRow; col++) {
			total += scores[row][col];
		}
		cout << "Row " << row << " has a value of " << total << "\n";
	}
	/* Can create 3D, 4D, etc arrays
	 * warehouse[10][1][2][3]
	 */
	return 0;
}

