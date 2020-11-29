#include <iostream>
#include <string>
#include "UBArray.h"
#include "Queue.h"
using namespace std;

//Use methods in the STL string class to help parse commands.
void main()
{
	string response;
	queue data;
	cout << "Valid Commands For This Program Include:" << endl;
	cout << "1. Help, Which Will Bring Up This List Of Commands." << endl;
	cout << "2. Q (String), Which Will Queue A String To The Tail Of A List." << endl;
	cout << "3. D, Which Will Remove The Head Of A List." << endl;
	cout << "4. X, Which Will Terminate This Program." << endl;
	cout << "Commands Are Not Case Sensitive." << endl;
	cout << endl;
	while (true)
	{
		cout << "Please Enter A Command:" << endl;
		getline(cin, response);
		if (response == "X" || response == "x")
		{
			cout << "Exiting..." << endl;
			break;
		}
		else if (response == "HELP" || response == "Help" || response == "help")
		{
			cout << endl;
			cout << "Valid Commands For This Program Include:" << endl;
			cout << "1. Help, Which Will Bring Up This List Of Commands." << endl;
			cout << "2. Q (String), Which Will Queue A String To The Tail Of A List." << endl;
			cout << "3. D, Which Will Remove The Head Of A List." << endl;
			cout << "4. X, Which Will Terminate This Program." << endl;
			cout << "Commands Are Not Case Sensitive." << endl;
		}
		else if (response == "D" || response == "d")
		{
			data.DeQueue();
		}
		else if (response == "Q" || response == "q")
		{
			cout << "There Is No String To Queue. Please Enter A String After The Command." << endl;
		}
		else if (response.substr(0, 2) == "Q " || response.substr(0, 2) == "q ")
		{
			data.Queue(response.substr(2, string::npos));
		}
		else if (response.substr(0,1) == "Q" || response.substr(0,1) == "q")
		{
			cout << "Command Should Have A Space After It. I Assume You Meant \"" << response.substr(0, 1) << " " << response.substr(1, string::npos) << "\". " << "String Was Not Queued." << endl;
		}
		else
			cout << "Unrecognized Command. Type \"Help\" Without Quotes To Bring Up The List Of Commands." << endl;
		cout << endl;
	}
}