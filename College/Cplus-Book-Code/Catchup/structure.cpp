/*
 *  Created on: Feb 20, 2018
 *      Author: Master
 */
#include <iostream>
using namespace std;

struct Books {
	string title;
	string author;
	string publisher;
	double price;
};
struct Mass {
	string name;
	int id;
	double weight;
	Books b; // Nested
};
struct Circle {
	double radius;
	double diameter;
	double area;
};
Circle createCircle();

/* Also Unions but don't mess with that crap now */

int structions() {
	/* Enumeration in display */
	enum Day {
		Monday = 2, Tuesday, Wednesday = 22, Thursday, Friday, Saturday, Sunday
	};
	// Assigning numbers to the names (also upgrades the unasigned)
	int x = Thursday;
	cout << x << endl;
	cout << Monday << " " << Tuesday << " " << Sunday << endl;

	Mass m; // Define structure variable
	m.name = "This name"; // Setting name
	cout << "The name is: " << m.name << endl;

	/* Creating an array of Structures */
	Books bl[10];
	bl[10].title = "title10"; // Setting 10 title to something
	cout << "The title is: " << bl[0].title << endl;

	/* Accessing Nested Structures */
	m.b.title = "title test book";
	cout << "Testing " << m.b.title << " is the test book\n";

	Circle c = createCircle();
	/* Pointers to Structures */
	Circle *cirptr = &c;
	delete cirptr;

	/* Dynamic Allocating Structure */
	cirptr = new Circle;
	cirptr->radius = 10; // Sets the radius

	return 0;
}

/* Setting the structures values (uses reference Parameter) */
void getItem(Books &b) {

	/* User Inputting the Data */
//	cin >> b.title;
//	cin >> b.author;
//	cin >> b.publisher;
//	cin >> b.price;
	/* Automation of Entering the Data */
	b.title = "title #1";
	b.author = "whats his name";
	b.publisher = "Professional whats his name";
	b.price = 1992.3;
//	No return needed since it is referenced
}

/* Using a structure as Function Argument */
void showItem(Books b) {
	/* Print Book Information */
	cout << "Title: " << b.title << endl;
	cout << "Author: " << b.author << endl;
	cout << "Publisher: " << b.publisher << endl;
	cout << "Price: " << b.price << endl;
}

/* Returning a structure */
Circle createCircle() {
	Circle temp;
	temp.radius = 10;
	temp.diameter = 20.0;
	temp.area = 314.159;
	return temp;
}
