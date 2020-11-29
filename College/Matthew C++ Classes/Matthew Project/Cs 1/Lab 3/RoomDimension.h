#ifndef ROOMDIMENSION_H
#define ROOMDIMENSION_H
#include "FeetInches.h"

class RoomDimension
{
private:
	FeetInches length;
	FeetInches width;
public:
	RoomDimension()
	{
		length.setFeet(0);
		length.setInches(0);
		width.setFeet(0);
		width.setInches(0);
	}
	RoomDimension(int fl, int il, int fw, int iw)
	{
		length.setFeet(fl);
		length.setInches(il);
		width.setFeet(fw);
		width.setInches(iw);
	}
	void setDimensions(int fl, int il, int fw, int iw)
	{
		length.setFeet(fl);
		length.setInches(il);
		width.setFeet(fw);
		width.setInches(iw);
	}
	FeetInches getArea()
	{
		length.multiply(width); //Multiply length by width. This will work the other way around as well.
		return length;
	}
};
#endif