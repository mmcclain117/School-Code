#ifndef CRUISESHIP_H
#define CRUISESHIP_H
#include <iostream>
#include <string>
#include "Ship.h"
using namespace std;

class CruiseShip : public Ship
{
private:
	int passengercap;
public:
	CruiseShip() : Ship()
	{
		shipname = "Name Not Specified";
		yearbuilt = "Year Constructed Not Specified";
		passengercap = 0;
	}
	CruiseShip(string n, string y, int cap) : Ship(n, y)
	{
		shipname = n;
		yearbuilt = y;
		passengercap = cap;
	}
	void setpassengercap(int cap)
	{
		passengercap = cap;
	}
	int getpassengercap()
	{
		return passengercap;
	}
	void print() override
	{
		cout << "Ship Name: " << shipname << endl;
		cout << "Passenger Capacity: " << passengercap << endl;
	}
};
#endif