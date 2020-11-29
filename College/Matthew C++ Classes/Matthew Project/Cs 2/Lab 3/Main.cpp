#include <stdlib.h>
#include <string>
#include <iostream>
using namespace std;

#include "RAFile.h"

//Use methods in the STL string class to help parse commands.
void main()
{
	RAFile			DBase;
	string			response;
	UINT			numresponse;

	cout << "Enter the Database name: ";
	cin >> response;

	if (DBase.Open(response) != RAFile::OK)
		cout << "Open Failed" << endl;
	else
	{
		cout << "Valid Commands For This Program Include:" << endl;
		cout << "1. Help, Which Will Bring Up This List Of Commands." << endl;
		cout << "2. G, (Integer) Which Will Print Out The Record At The Specified Index." << endl;
		cout << "3. R, (Integer) (String) Which Will Take The Inputted String, And Write It To The Specified Index." << endl;
		cout << "4. I, (Integer) (String) Which Will Take The Inputted String, And Insert It Into The Specified Index." << endl;
		cout << "5. S, Which Will Return The Size Of The Database." << endl;
		cout << "6. X, Which Will Terminate This Program." << endl;
		cout << "Commands Are Not Case Sensitive." << endl;
		cout << "Do Not Enter Spaces After Commands. The Engine On Which This Program Is Written Cannot Parse Such Commands." << endl;
		cout << endl;

		while (true)
		{
			cout << "Please Enter A Command:" << endl;
			cin >> response;
			if (response == "X" || response == "x")
			{
				DBase.Close();
				cout << "Exiting..." << endl;
				break;
			}
			else if (response == "HELP" || response == "Help" || response == "help")
			{
				cout << endl;
				cout << "Valid Commands For This Program Include:" << endl;
				cout << "1. Help, Which Will Bring Up This List Of Commands." << endl;
				cout << "2. G (Integer), Which Will Print Out The Record At The Specified Index." << endl;
				cout << "3. R (Integer), (String), Which Will Take The Inputted String, And Write It To The Specified Index." << endl;
				cout << "4. I (Integer), (String), Which Will Take The Inputted String, And Insert It Into The Specified Index." << endl;
				cout << "5. S, Which Will Return The Size Of The Database." << endl;
				cout << "6. X, Which Will Terminate This Program." << endl;
				cout << "Commands Are Not Case Sensitive." << endl;
				cout << "Do Not Enter Spaces After Commands. The Engine On Which This Program Is Written Cannot Parse Such Commands." << endl;
			}
			if (response == "S" || response == "s")
			{
				cout << "Size Of Database: " << DBase.Size() << " Records." << endl;
			}
			else if (response == "G" || response == "g")
			{
				cout << "Enter An Index To Retrieve Data From." << endl;
				cin >> numresponse;
				DBase.Get(numresponse, response);
				cout << "String At This Index: " << response << endl;
			}
			else if (response == "R" || response == "r")
			{
				cout << "Enter An Index To Write Data To." << endl;
				cin >> numresponse;
				cout << "Enter A String." << endl;
				cin >> response;
				DBase.Replace(numresponse, response);
			}
			else if (response == "I" || response == "i")
			{
				cout << "Enter An Index To Insert Data Into." << endl;
				cin >> numresponse;
				cout << "Enter A String." << endl;
				cin >> response;
				DBase.Insert(numresponse, response);
			}
			else
				cout << "Unrecognized Command. Type \"Help\" Without Quotes To Bring Up The List Of Commands." << endl;
			cout << endl;
		}
	}
}