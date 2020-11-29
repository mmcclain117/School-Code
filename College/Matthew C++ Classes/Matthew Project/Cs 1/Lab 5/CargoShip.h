#ifndef CARGOSHIP_H
#define CARGOSHIP_H
#include <iostream>
#include <string>
#include "Ship.h"
using namespace std;

class CargoShip : public Ship
{
private:
	int cargocap;
public:
	CargoShip() : Ship()
	{
		shipname = "Name Not Specified";
		yearbuilt = "Year Constructed Not Specified";
		cargocap = 0;
	}
	CargoShip(string n, string y, int cap) : Ship(n, y)
	{
		shipname = n;
		yearbuilt = y;
		cargocap = cap;
	}
	void setcargocap(int cap)
	{
		cargocap = cap;
	}
	int getcargocap()
	{
		return cargocap;
	}
	void print() override
	{
		cout << "Ship Name: " << shipname << endl;
		cout << "Cargo Capacity: " << cargocap << " Tons" << endl;
	}
};
#endif