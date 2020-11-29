//@Author: Matthew Wethington

#include <iostream>
#include "NumDays.h"
using namespace std;

int main() {
	NumDays timeworked;
	NumDays timeworked2(2);
	timeworked = timeworked++;
	timeworked = ++timeworked;
	timeworked2 = --timeworked2;
	timeworked2 = timeworked2--;
	timeworked2 = timeworked2++;
	NumDays timeworked3 = timeworked + timeworked2;
	NumDays timeworked4 = timeworked - timeworked2;
	cout << timeworked.getHours() << " " << timeworked.getDays() << endl;
	cout << timeworked2.getHours() << " " << timeworked2.getDays() << endl;
	cout << timeworked3.getHours() << " " << timeworked3.getDays() << endl;
	cout << timeworked4.getHours() << " " << timeworked4.getDays() << endl;
	return 0;
}

