#include <stdlib.h>

#include "Token.h"

WCS_String Temp;
Token Toke;

void PrintResult()
{
	for (int i = 0; i < Toke.numchars; i++)
	{
		cout << Toke.chars[i];
	}
	cout << endl;
}

void main (int argc, char * argv [])
	{
	if (argc < 2)
			{
			cout << "You need to place the file name on the command line" << endl;
			exit (0);
			}
		else
			Temp = argv [1];
		// the following three lines are just to show what was entered on the command line
	cout << "Argv [0] is " << argv [0] << endl;
	cout << "Argv [1] is " << argv [1] << endl;
	//return;

	Token::OpenFile (Temp);
	do	{
		Toke.Build ();
		switch (Toke.GetType ())
			{
			case Token::UnknownToken:
				cout << "I don't have any idea what you are saying" << endl;
				break;
			case Token::DelimiterSpaceToken:
				break;
			case Token::KeywordEvalToken:
				cout << "Found Keyword EVAL" << endl;
				break;
			case Token::KeywordValueToken:
				cout << "Found Keyword VALUE" << endl;
				break;
			case Token::KeywordExpToken:
				cout << "Found Keyword EXP" << endl;
				break;
			case Token::OperatorPlusToken:
				cout << "Found Operator +" << endl;
				break;
			case Token::OperatorMinusToken:
				cout << "Found Operator -" << endl;
				break;
			case Token::OperatorAsteriskToken:
				cout << "Found Operator *" << endl;
				break;
			case Token::OperatorSlashToken:
				cout << "Found Operator /" << endl;
				break;
			case Token::SymbolOpenParenToken:
				cout << "Found Symbol (" << endl;
				break;
			case Token::SymbolCloseParenToken:
				cout << "Found Symbol )" << endl;
				break;
			case Token::SymbolSemiColonToken:
				cout << "Found Symbol ;" << endl;
				break;
			case Token::ConstantToken:
				cout << "Found Constant ";
				PrintResult();
				break;
			case Token::VariableToken:
				cout << "Found Variable ";
				PrintResult();
				break;
			case Token::NumAndSemiColToken:
				cout << "Found Constant ";
				PrintResult();
				cout << "Found Symbol ;" << endl;
				break;
			case Token::VarAndSemiColToken:
				cout << "Found Variable ";
				PrintResult();
				cout << "Found Symbol ;" << endl;
				break;
			case Token::ConstAndCPToken:
				cout << "Found Constant ";
				PrintResult();
				cout << "Found Symbol )" << endl;
				break;
			case Token::VarAndCPToken:
				cout << "Found Variable ";
				PrintResult();
				cout << "Found Symbol )" << endl;
				break;
			case Token::EndOfInputToken:
				cout << "Found end of input file" << endl;
				break;
			default:
				cout << "Should not get here" << endl;
			}
		} while (Toke.GetType () != Token::EndOfInputToken);
	Token::CloseFile ();
	}
