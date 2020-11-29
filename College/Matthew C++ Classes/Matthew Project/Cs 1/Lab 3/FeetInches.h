#ifndef FEETINCHES_H
#define FEETINCHES_H

class FeetInches
{
private:
	int feet;
	int inches;
public:
	int area;
	FeetInches()
	{
		feet = 0;
		inches = 0;
	}
	FeetInches(int f, int i)
	{
		feet = f;
		inches = i;
	}
	void setFeet(int f)
	{
		feet = f;
	}
	void setInches(int i)
	{
		inches = i;
	}
	int getFeet()
	{
		return feet;
	}
	int getInches()
	{
		return inches;
	}
	void multiply(FeetInches second)
	{
		int lengthinches = feet * 12 + inches; //Data for the first object
		int widthinches = second.getFeet() * 12 + second.getInches(); //Data for the second object
		area = lengthinches * widthinches; //Area is in square inches. Need to convert to square feet later
	}
};
#endif
