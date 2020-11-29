//@Author: Matthew Wethington
#include <iostream>
#include <string>
#include "Ship.h"
#include "CruiseShip.h"
#include "CargoShip.h"
using namespace std;

void main()
{
	Ship *ships[] = { new Ship("The Annihilator", "2172"), new CruiseShip("The Acclaimator Heavy Cruiser", "2125", 2000), new CargoShip("Atlas Super Freighter", "2096", 50000) };
	
	for (int i = 0; i < 3; i++)
	{
		ships[i]->print();
	}
	for (int i = 0; i < 3; i++)
	{
		delete ships[i];
	}
}