//@Author: Matthew Wethington
#include <iostream>
#include "Employee.h"
using namespace std;

int main() {
	const int arrlen = 3;
	Employee employeearray[arrlen] = { {"Susan Meyers", 47899, "Accounting", "Vice President"}, {"Mark Jones", 39119, "IT", "Programmer"}, {"Joy Rogers", 81774, "Manufacturing", "Engineer"} };
	for (int i = 0; i < arrlen; i++) {
		cout << "Name: " + employeearray[i].getName() + ", ID#: ";
		cout << employeearray[i].getID();
		cout << ", Department: " + employeearray[i].getDepartment() + ", Position: " + employeearray[i].getPosition() << endl;
	}
	return 0;
}
