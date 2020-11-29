/*
 *  Created on: Feb 21, 2018
 *      Author: Master Ward
 */
#include <iostream>
using namespace std;

class BaseClass {
public:
	BaseClass() // Constructor
	{
		cout << "This is the BaseClass Constructor";
	}
	~BaseClass() // Destructor
	{
		cout << "This is the BaseClass Destructor";
	}
};

class DerivedClass: BaseClass {
public:
	DerivedClass() // Constructor
	{
		cout << "This is the DerivedClass Constructor.\n";
	}
	;
	~DerivedClass() // Destructor
	{
		cout << "This is the DerivedClass Destructor.\n";
	}
	;
};

int dev() {
	cout << "We will now define a DerivedClass object.\n";
	DerivedClass obj;
	cout << "The program will now end.\n";
	return 0;
}
