// Chapter 15, Programming Challege 4: Time Format
#include <iostream>
#include "MilTime.h"
using namespace std;

int main() {
	int int1, int2;
	while (true) {
		cout << "Enter Two Values, One For Hours, And One For Seconds:" << endl;
		cin >> int1 >> int2;
		MilTime timeObj(int1, int2);
		if (timeObj.error == true)
			continue;

		cout << "The hour in military format is " << timeObj.getHour() << endl;
		cout << "The hour in standard format is " << timeObj.getStandHr()
				<< endl;
		cout << "The minutes are " << timeObj.getMin() << endl;
		cout << "The seconds are " << timeObj.getSec() << endl;
	}
	return 0;
}
