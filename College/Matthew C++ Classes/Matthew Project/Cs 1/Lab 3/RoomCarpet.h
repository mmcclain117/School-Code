#ifndef ROOMCARPET_H
#define ROOMCARPET_H
#include "RoomDimension.h"
#include "FeetInches.h"

class RoomCarpet
{
private:
	RoomDimension dimensions;
	int costpersquarefoot;
public:
	RoomCarpet()
	{
		costpersquarefoot = 0;
		dimensions.setDimensions(0, 0, 0, 0);
	}
	RoomCarpet(int cost, int fl, int il, int fw, int iw)
	{
		costpersquarefoot = cost;
		dimensions.setDimensions(fl, il, fw, iw);
	}
	void setCostpersquarefoot(int c)
	{
		costpersquarefoot = c;
	}
	double getTotalCost()
	{
		FeetInches result = dimensions.getArea();
		double totalcost = ((double)result.area / 144) * costpersquarefoot; //Converts square inches to square feet. There are 144 square inches in a square foot
		return totalcost;
	}
};
#endif