//@Author: Matthew Wethington
#include <iostream>
#include "FeetInches.h"
#include "RoomDimension.h"
#include "RoomCarpet.h"
using namespace std;

void main()
{
	int lengthfeet;
	int lengthinches;
	int widthfeet;
	int widthinches;
	int carpetpricerate;
	cout << "Please Enter The Dimensions Of The Room (in Ft, In form):" << endl;
	cout << "Length: " << endl;
	cout << "Ft: ";
	cin >> lengthfeet;
	cout << "In: ";
	cin >> lengthinches;
	cout << endl;
	cout << "Width: " << endl;
	cout << "Ft: ";
	cin >> widthfeet;
	cout << "In: ";
	cin >> widthinches;
	cout << endl;
	cout << "Please Enter The Price Per Square Foot Of Carpet: $";
	cin >> carpetpricerate;
	cout << endl;
	RoomCarpet carpetdimensions(carpetpricerate, lengthfeet, lengthinches, widthfeet, widthinches);
	cout << "Total Cost Of The Carpet With These Dimensions: $" << carpetdimensions.getTotalCost() << endl;
}