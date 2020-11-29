/*
 * c.cpp
 *
 *  Created on: Oct 23, 2017
 *      Author: Master
 */
#include <iostream>
#include <string>
#include <sstream>
using namespace std;


/*
int main() {
	int x;
	x = 2.1;
//	cout << x;
	cout << x + "";
	x = 34.0;
	cout << x;
	cout << "Hello World\n";
	cout << "This is also hello world 2.0\n";
	int q = 1;
	int r = 2;
	int s = 3;
	int t = 4;
//	funct1 (q, r, s, t);
	cout << "q= " << q << " r= " << r << " s= " << s << " t= " << t;
	return 0;
}
*/


void funct1(int& q, int& r, int s, int t) {
	q = q * 2;
	r = 200;
//	r = r * 3;
	s = s * 4;
	t = 200;
}

void array() {
	int q[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
	q[2] = 14;
	cout << q[2] + "";
}


