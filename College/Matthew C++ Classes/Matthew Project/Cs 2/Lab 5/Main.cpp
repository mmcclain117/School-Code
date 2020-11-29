#include <iostream>
#include <string>
#include <sstream>
#include "MathTree.h"

using namespace std;

void main()
{
	string response;
	MathTree tree;
	int temp;
	int varval;
	int mathoperator;

		cout << "Valid Commands For This Program Include:" << endl;
		cout << "1. Help, Which Will Bring Up This List Of Commands." << endl;
		cout << "2. C (Integer), Which Will Insert A Number Into The Tree (Supports Negative Numbers)." << endl;
		cout << "3. VXX, Which Will Take The Specified Variable And Place It In The Tree." << endl;
		cout << "4. vXX (Integer), Which Will Find The Specified Variable And Modify Its Value To The Value Specified." << endl;
		cout << "5. O (Operator) (Precedence), Which Will Insert The Operator Into The Tree And Set Its Precedence." << endl;
		cout << "6. E, Which Will Have The Tree Evaluated And The Resulting Value Will Be Printed." << endl;
		cout << "7. D, Which Will Delete The Tree." << endl;
		cout << "8. X, Which Will Terminate This Program." << endl;
		cout << "Commands Are Not Case Sensitive With The Exception Of V And v." << endl;
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
				cout << "2. C (Integer), Which Will Insert A Number Into The Tree (Supports Negative Numbers)." << endl;
				cout << "3. VXX, Which Will Take The Specified Variable And Place It In The Tree." << endl;
				cout << "4. vXX (Integer), Which Will Find The Specified Variable And Modify Its Value To The Value Specified." << endl;
				cout << "5. O (Operator) (Precedence), Which Will Insert The Operator Into The Tree And Set Its Precedence." << endl;
				cout << "6. E, Which Will Have The Tree Evaluated And The Resulting Value Will Be Printed." << endl;
				cout << "7. D, Which Will Delete The Tree." << endl;
				cout << "8. X, Which Will Terminate This Program." << endl;
				cout << "Commands Are Not Case Sensitive With The Exception Of V And v." << endl;
			}
			if (response.substr(0, 1) == "C" || response.substr(0, 1) == "c")
			{
				if (response.substr(2,1) == "-")
				{
					stringstream number(response.substr(3, string::npos));
					number >> temp;
					temp *= -1;
				}
				else
				{
					stringstream number(response.substr(2, string::npos));
					number >> temp;
				}
				tree.InsertOperand(temp);
			}
			else if (response.substr(0, 1) == "V")
			{
				stringstream number(response.substr(1, 2));
				number >> temp;
				tree.InsertVariableOperand(temp);
			}
			else if (response.substr(0, 1) == "v")
			{
				stringstream number(response.substr(1, 2));
				number >> temp;
				stringstream number2(response.substr(4, string::npos));
				number2 >> varval;
				tree.ModifyVariableOperand(temp, varval);
			}
			else if (response.substr(0, 1) == "O" || response.substr(0, 1) == "o")
			{
				if (response.substr(2, 1) == "+")
					mathoperator = 0;
				if (response.substr(2, 1) == "-")
					mathoperator = 1;
				else if (response.substr(2, 1) == "*")
					mathoperator = 2;
				else if (response.substr(2, 1) == "/")
					mathoperator = 3;
				stringstream number(response.substr(4, string::npos));
				number >> temp;
				tree.InsertBinaryOperator(mathoperator, temp);
			}
			else if (response == "E" || response == "e")
			{
				cout << "Evaluating Tree:" << endl;
				cout << "The Result Is "<< tree.Evaluate() << endl;
			}
			else if (response == "D" || response == "d")
			{
				tree.Delete();
			}
			else
				cout << "Unrecognized Command. Type \"Help\" Without Quotes To Bring Up The List Of Commands." << endl;
			cout << endl;
		}
}