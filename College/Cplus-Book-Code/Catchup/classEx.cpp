/*
 *  Created on: Feb 20, 2018
 *      Author: Master
 */

#include <iostream>
#include <memory> // Used for smart pointers
using namespace std;

/**
 * Didn't Include Chapter 14: Friends 819
 * Object operator=() thing (835)
 */

class Rectangle {
private:
	double width;
	double length;
	static int obj;
public:
	Rectangle() {
		width = 1;
		length = 2;
		obj++;
	}
	; // Default Constructor
//	Rectangle(double, double); // Constructor
	Rectangle(double w, double l) {
		width = w;
		length = l;
		obj++;
	}
	~Rectangle(); // Deconstructor
	void setWidth(double);
	void setLength(double);
	double getWidth() const;
	double getLength();
	int getObj();

	/* Inline */
	double getArea() {
		return width * length;
	}
};
int Rectangle::obj = 0; // Static Stays No Matter What

/* Deconstructor */
Rectangle::~Rectangle() {
	cout << "The Deconstructor is now running.\n";
}

/* Define Member Variables */
void Rectangle::setWidth(double w) {
	width = w;
}

void Rectangle::setLength(double l) {
	length = l;
}

double Rectangle::getWidth() const {
	return width;
}

double Rectangle::getLength() {
	return length;
}
int Rectangle::getObj() {
	return obj;
}

int classex() {
	Rectangle box;
	box.setWidth(10.0);
	box.setLength(12.0);

	/* Dynamically allocate Objects */
	Rectangle *kitchen = new Rectangle;
	kitchen->setLength(20.0);
	kitchen->setWidth(16.0);

	/* Memberwise (=) Both pointing to same data spot*/
	Rectangle box2 = box; // Not 100% sure I'm Right

	/* Smart Pointers */
	unique_ptr<Rectangle> rectPtr(new Rectangle);
	rectPtr->setLength(13.5);
	rectPtr->setWidth(19.87);

	/* Array of Objects */
//	Rectangle r[] = { Rectangle(1.0, 1.9) };
	Rectangle r[] = { Rectangle(1.0, 2.0), Rectangle(1.0, 1.9), Rectangle(2.3,
			4.5) };
	cout << "There are: " << r[2].getObj() << endl;

	return 0;
}
