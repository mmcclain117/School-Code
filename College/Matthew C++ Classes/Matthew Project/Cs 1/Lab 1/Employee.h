#ifndef EMPLOYEE_H
#define EMPLOYEE_H
#include <string>
using namespace std;
class Employee {
private:
	string name;
	int idNumber;
	string department;
	string position;
public:
	Employee(string n, int num, string d, string p) {
		name = n;
		idNumber = num;
		department = d;
		position = p;
	}
	Employee(string n, int num) {
		name = n;
		idNumber = num;
		department = "";
		position = "";
	}
	Employee() {
		name = "";
		idNumber = 0;
		department = "";
		position = "";
	}
	void setName(string n) {
		name = n;
	}
	void setID(int num) {
		idNumber = num;
	}
	void setDepartment(string d) {
		department = d;
	}
	void setPosition(string p) {
		position = p;
	}
	string getName() {
		return name;;
	}
	int getID() {
		return idNumber;
	}
	string getDepartment() {
		return department;
	}
	string getPosition() {
		return position;
	}
};
#endif
