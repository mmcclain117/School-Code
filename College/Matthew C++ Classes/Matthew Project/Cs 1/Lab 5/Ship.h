#ifndef SHIP_H
#define SHIP_H
#include <iostream>
#include <string>
using namespace std;

class Ship
{
protected:
	string shipname;
	string yearbuilt;
public:
	Ship()
	{
		shipname = "Name Not Specified";
		yearbuilt = "Year Constructed Not Specified";
	}
	Ship(string n, string y)
	{
		shipname = n;
		yearbuilt = y;
	}
	void setname(string n)
	{
		shipname = n;
	}
	void setyear(string y)
	{
		yearbuilt = y;
	}
	string getname()
	{
		return shipname;
	}
	string getyear()
	{
		return yearbuilt;
	}
	virtual void print()
	{
		cout << "Ship Name: " << shipname << endl;
		cout << "Year Constructed: " << yearbuilt << endl;
	}
};
#endif