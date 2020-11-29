#define TOKEN_CPP

#include "Token.h"

//**********  Static Variables from Token Class **********

Token::UChar Token::LastChar;

ifstream Token::SourceFile;

Token::InputType Token::InputTable [] =			{
												InputUnknown,		// 00
												InputUnknown,		// 01
												InputUnknown,		// 02
												InputUnknown,		// 03
												InputUnknown,		// 04
												InputUnknown,		// 05
												InputUnknown,		// 06
												InputUnknown,		// 07
												InputUnknown,		// 08
												InputUnknown,		// 09
												InputSpace,			// 0A
												InputUnknown,		// 0B
												InputUnknown,		// 0C
												InputSpace,			// 0D
												InputUnknown,		// 0E
												InputUnknown,		// 0F
												InputUnknown,		// 10
												InputUnknown,		// 11
												InputUnknown,		// 12
												InputUnknown,		// 13
												InputSpace,			// 14
												InputUnknown,		// 15
												InputUnknown,		// 16
												InputUnknown,		// 17
												InputUnknown,		// 18
												InputUnknown,		// 19
												InputUnknown,		// 1A
												InputUnknown,		// 1B
												InputUnknown,		// 1C
												InputUnknown,		// 1D
												InputUnknown,		// 1E
												InputUnknown,		// 1F
												InputSpace,			// 20
												InputUnknown,		// 21
												InputUnknown,		// 22
												InputUnknown,		// 23
												InputUnknown,		// 24
												InputUnknown,		// 25
												InputUnknown,		// 26
												InputUnknown,		// 27
												InputOpenParen,		// 28
												InputCloseParen,	// 29
												InputAsterisk,		// 2A
												InputPlus,			// 2B
												InputUnknown,		// 2C
												InputMinus,			// 2D
												InputUnknown,		// 2E
												InputSlash,			// 2F
												Input0,				// 30
												Input1,				// 31
												Input2,				// 32
												Input3,				// 33
												Input4,				// 34
												Input5,				// 35
												Input6,				// 36
												Input7,				// 37
												Input8,				// 38
												Input9,				// 39
												InputUnknown,		// 3A
												InputSemiColon,		// 3B
												InputUnknown,		// 3C
												InputUnknown,		// 3D
												InputUnknown,		// 3E
												InputUnknown,		// 3F
												InputUnknown,		// 40
												InputA,				// 41
												InputUnknown,		// 42
												InputUnknown,		// 43
												InputUnknown,		// 44
												InputE,				// 45
												InputUnknown,		// 46
												InputUnknown,		// 47
												InputUnknown,		// 48
												InputUnknown,		// 49
												InputUnknown,		// 4A
												InputUnknown,		// 4B
												InputL,				// 4C
												InputUnknown,		// 4D
												InputUnknown,		// 4E
												InputUnknown,		// 4F
												InputP,				// 50
												InputUnknown,		// 51
												InputUnknown,		// 52
												InputUnknown,		// 53
												InputUnknown,		// 54
												InputU,				// 55
												InputV,				// 56
												InputUnknown,		// 57
												InputX,				// 58
												InputUnknown,		// 59
												InputUnknown,		// 5A
												InputUnknown,		// 5B
												InputUnknown,		// 5C
												InputUnknown,		// 5D
												InputUnknown,		// 5E
												InputUnknown,		// 5F
												InputUnknown,		// 60
												InputA,				// 61
												InputUnknown,		// 62
												InputUnknown,		// 63
												InputUnknown,		// 64
												InputE,				// 65
												InputUnknown,		// 66
												InputUnknown,		// 67
												InputUnknown,		// 68
												InputUnknown,		// 69
												InputUnknown,		// 6A
												InputUnknown,		// 6B
												InputL,				// 6C
												InputUnknown,		// 6D
												InputUnknown,		// 6E
												InputUnknown,		// 6F
												InputP,				// 70
												InputUnknown,		// 71
												InputUnknown,		// 72
												InputUnknown,		// 73
												InputUnknown,		// 74
												InputU,				// 75
												InputV,				// 76
												InputUnknown,		// 77
												InputX,				// 78
												InputUnknown,		// 79
												InputUnknown,		// 7A
												InputUnknown,		// 7B
												InputUnknown,		// 7C
												InputUnknown,		// 7D
												InputUnknown,		// 7E
												InputUnknown,		// 7F
												InputUnknown,		// 80
												InputUnknown,		// 81
												InputUnknown,		// 82
												InputUnknown,		// 83
												InputUnknown,		// 84
												InputUnknown,		// 85
												InputUnknown,		// 86
												InputUnknown,		// 87
												InputUnknown,		// 88
												InputUnknown,		// 89
												InputUnknown,		// 8A
												InputUnknown,		// 8B
												InputUnknown,		// 8C
												InputUnknown,		// 8D
												InputUnknown,		// 8E
												InputUnknown,		// 8F
												InputUnknown,		// 90
												InputUnknown,		// 91
												InputUnknown,		// 92
												InputUnknown,		// 93
												InputUnknown,		// 94
												InputUnknown,		// 95
												InputUnknown,		// 96
												InputUnknown,		// 97
												InputUnknown,		// 98
												InputUnknown,		// 99
												InputUnknown,		// 9A
												InputUnknown,		// 9B
												InputUnknown,		// 9C
												InputUnknown,		// 9D
												InputUnknown,		// 9E
												InputUnknown,		// 9F
												InputUnknown,		// A0
												InputUnknown,		// A1
												InputUnknown,		// A2
												InputUnknown,		// A3
												InputUnknown,		// A4
												InputUnknown,		// A5
												InputUnknown,		// A6
												InputUnknown,		// A7
												InputUnknown,		// A8
												InputUnknown,		// A9
												InputUnknown,		// AA
												InputUnknown,		// AB
												InputUnknown,		// AC
												InputUnknown,		// AD
												InputUnknown,		// AE
												InputUnknown,		// AF
												InputUnknown,		// B0
												InputUnknown,		// B1
												InputUnknown,		// B2
												InputUnknown,		// B3
												InputUnknown,		// B4
												InputUnknown,		// B5
												InputUnknown,		// B6
												InputUnknown,		// B7
												InputUnknown,		// B8
												InputUnknown,		// B9
												InputUnknown,		// BA
												InputUnknown,		// BB
												InputUnknown,		// BC
												InputUnknown,		// BD
												InputUnknown,		// BE
												InputUnknown,		// BF
												InputUnknown,		// C0
												InputUnknown,		// C1
												InputUnknown,		// C2
												InputUnknown,		// C3
												InputUnknown,		// C4
												InputUnknown,		// C5
												InputUnknown,		// C6
												InputUnknown,		// C7
												InputUnknown,		// C8
												InputUnknown,		// C9
												InputUnknown,		// CA
												InputUnknown,		// CB
												InputUnknown,		// CC
												InputUnknown,		// CD
												InputUnknown,		// CE
												InputUnknown,		// CF
												InputUnknown,		// D0
												InputUnknown,		// D1
												InputUnknown,		// D2
												InputUnknown,		// D3
												InputUnknown,		// D4
												InputUnknown,		// D5
												InputUnknown,		// D6
												InputUnknown,		// D7
												InputUnknown,		// D8
												InputUnknown,		// D9
												InputUnknown,		// DA
												InputUnknown,		// DB
												InputUnknown,		// DC
												InputUnknown,		// DD
												InputUnknown,		// DE
												InputUnknown,		// DF
												InputUnknown,		// E0
												InputUnknown,		// E1
												InputUnknown,		// E2
												InputUnknown,		// E3
												InputUnknown,		// E4
												InputUnknown,		// E5
												InputUnknown,		// E6
												InputUnknown,		// E7
												InputUnknown,		// E8
												InputUnknown,		// E9
												InputUnknown,		// EA
												InputUnknown,		// EB
												InputUnknown,		// EC
												InputUnknown,		// ED
												InputUnknown,		// EE
												InputUnknown,		// EF
												InputUnknown,		// F0
												InputUnknown,		// F1
												InputUnknown,		// F2
												InputUnknown,		// F3
												InputUnknown,		// F4
												InputUnknown,		// F5
												InputUnknown,		// F6
												InputUnknown,		// F7
												InputUnknown,		// F8
												InputUnknown,		// F9
												InputUnknown,		// FA
												InputUnknown,		// FB
												InputUnknown,		// FC
												InputUnknown,		// FD
												InputUnknown,		// FE
												EndOfFile			// FF
												};

Token::TokenFunc Token::StateFunction [] =		{
												NotYetWritten,			//	0
												GotE,					//  1
												GotV,					//  2
												GotEV,					//	3
												GotEVA,					//	4
												GotEVAL,				//	5
												GotEndOfFile,			//	6
												GotUnexpectedEOF,		//	7
												StartedTokenWithSpace,	//	8
												GotInvalidInput,		//  9

												GotVA,					//	10
												GotVAL,					//	11
												GotVALU,				//	12
												GotVALUE,				//	13
												GotEX,					//	14
												GotEXP,					//	15
												GotADD,					//	16
												GotSUB,					//	17
												GotMUL,					//	18
												GotDIV,					//	19
												GotOP,					//	20
												GotCP,					//	21
												GotSemiCol,				//	22

												GotUnknownInput,		//	23
												Got0,					//	24
												Got1,					//	25
												Got2,					//	26
												Got3,					//	27
												Got4,					//	28
												Got5,					//	29
												Got6,					//	30
												Got7,					//	31
												Got8,					//	32
												Got9,					//	33
												GotVar,					//	34
												GotNum,					//	35
												GotConst,				//	36
												GotNumAndSemiCol,		//	37
												GotVarAndSemiCol,		//	38
												GotConstAndCP,			//	39
												GotVarAndCP				//	40
												};

Token::UChar Token::StateTable [NumInputs] [NumStates] =	{
						//							StartGettingToken	AfterE	AfterV	AfterEV	AfterEVA	AfterVA		AfterVAL	AfterVALU	AfterEX		After0		After1		After2		After3		After4		After5		After6		After7		After8		After9		AfterNum
						/*	InputUnknown	*/	{			23,				0,		0,		0,		0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0	},
						/*	InputA			*/	{			23,				9,		10,		4,		0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0	},
						/*	InputE			*/	{			1,				0,		0,		0,		0,			0,			0,			13,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0	},
						/*	InputL			*/	{			23,				0,		0,		0,		5,			11,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0	},
						/*	InputP			*/	{			23,				0,		0,		0,		0,			0,			0,			0,			15,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0	},
						/*	InputU			*/	{			23,				0,		0,		0,		0,			0,			12,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0	},
						/*	InputV			*/	{			2,				3,		0,		0,		0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0	},
						/*	InputX			*/	{			23,				14,		0,		0,		23,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0	},
						/*	Input0			*/	{			35,				0,		24,		0,		0,			0,			0,			0,			0,			24,			24,			24,			24,			24,			24,			24,			24,			24,			24,			35	},
						/*	Input1			*/	{			35,				0,		25,		0,		0,			0,			0,			0,			0,			25,			25,			25,			25,			25,			25,			25,			25,			25,			25,			35	},
						/*	Input2			*/	{			35,				0,		26,		0,		0,			0,			0,			0,			0,			26,			26,			26,			26,			26,			26,			26,			26,			26,			26,			35	},
						/*	Input3			*/	{			35,				0,		27,		0,		0,			0,			0,			0,			0,			27,			27,			27,			27,			27,			27,			27,			27,			27,			27,			35	},
						/*	Input4			*/	{			35,				0,		28,		0,		0,			0,			0,			0,			0,			28,			28,			28,			28,			28,			28,			28,			28,			28,			28,			35	},
						/*	Input5			*/	{			35,				0,		29,		0,		0,			0,			0,			0,			0,			29,			29,			29,			29,			29,			29,			29,			29,			29,			29,			35	},
						/*	Input6			*/	{			35,				0,		30,		0,		0,			0,			0,			0,			0,			30,			30,			30,			30,			30,			30,			30,			30,			30,			30,			35	},
						/*	Input7			*/	{			35,				0,		31,		0,		0,			0,			0,			0,			0,			31,			31,			31,			31,			31,			31,			31,			31,			31,			31,			35	},
						/*	Input8			*/	{			35,				0,		32,		0,		0,			0,			0,			0,			0,			32,			32,			32,			32,			32,			32,			32,			32,			32,			32,			35	},
						/*	Input9			*/	{			35,				0,		33,		0,		0,			0,			0,			0,			0,			33,			33,			33,			33,			33,			33,			33,			33,			33,			33,			35	},
						/*	InputPlus		*/	{			16,				0,		0,		0,		0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			36	},
						/*	InputMinus		*/	{			17,				0,		0,		0,		0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			36	},
						/*	InputAsterisk	*/	{			18,				0,		0,		0,		0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			36	},
						/*	InputSlash		*/	{			19,				0,		0,		0,		0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			36	},
						/*	InputOpenParen	*/	{			20,				0,		0,		0,		0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			0,			36	},
						/*	InputCloseParen	*/	{			21,				0,		0,		0,		0,			0,			0,			0,			0,			40,			40,			40,			40,			40,			40,			40,			40,			40,			40,			39	},
						/*	InputSemiColon	*/	{			22,				0,		0,		0,		0,			0,			0,			0,			0,			38,			38,			38,			38,			38,			38,			38,			38,			38,			38,			37	},
						/*	InputSpace		*/	{			8,				0,		0,		0,		0,			0,			0,			0,			0,			34,			34,			34,			34,			34,			34,			34,			34,			34,			34,			36	},
						/*	EndOfFile		*/	{			6,				7,		7,		7,		7,			7,			7,			7,			7,			7,			7,			7,			7,			7,			7,			7,			7,			7,			7,			7	},
												};

Variable Token::VariableArray [NumVariables];

//********** Methods from Token Class **********

Token::TokenState Token::NotYetWritten (Token &)
	{
	cout << "You called a method which has not yet been implemented" << endl;
	return TokenComplete;
	}

Token::TokenState Token::GotE (Token &)
	{
	return AfterE;
	}

Token::TokenState Token::GotV (Token &)
	{
	return AfterV;
	}

Token::TokenState Token::GotEV (Token &)
	{
	return AfterEV;
	}

Token::TokenState Token::GotEVA (Token &)
	{
	return AfterEVA;
	}

Token::TokenState Token::GotVA(Token &)
{
	return AfterVA;
}

Token::TokenState Token::GotVAL(Token &)
{
	return AfterVAL;
}

Token::TokenState Token::GotVALU(Token &)
{
	return AfterVALU;
}

Token::TokenState Token::GotEX(Token &)
{
	return AfterEX;
}

Token::TokenState Token::Got0(Token &)
{
	return After0;
}

Token::TokenState Token::Got1(Token &)
{
	return After1;
}

Token::TokenState Token::Got2(Token &)
{
	return After2;
}

Token::TokenState Token::Got3(Token &)
{
	return After3;
}

Token::TokenState Token::Got4(Token &)
{
	return After4;
}

Token::TokenState Token::Got5(Token &)
{
	return After5;
}

Token::TokenState Token::Got6(Token &)
{
	return After6;
}

Token::TokenState Token::Got7(Token &)
{
	return After7;
}

Token::TokenState Token::Got8(Token &)
{
	return After8;
}

Token::TokenState Token::Got9(Token &)
{
	return After9;
}

Token::TokenState Token::GotNum(Token &)
{
	return AfterNum;
}

Token::TokenState Token::GotEVAL (Token & T)
	{
	T.SetType (KeywordEvalToken);
	return TokenComplete;
	}

Token::TokenState Token::GotVALUE(Token & T)
{
	T.SetType(KeywordValueToken);
	return TokenComplete;
}

Token::TokenState Token::GotEXP(Token & T)
{
	T.SetType(KeywordExpToken);
	return TokenComplete;
}

Token::TokenState Token::GotADD(Token & T)
{
	T.SetType(OperatorPlusToken);
	return TokenComplete;
}

Token::TokenState Token::GotSUB(Token & T)
{
	T.SetType(OperatorMinusToken);
	return TokenComplete;
}

Token::TokenState Token::GotMUL(Token & T)
{
	T.SetType(OperatorAsteriskToken);
	return TokenComplete;
}

Token::TokenState Token::GotDIV(Token & T)
{
	T.SetType(OperatorSlashToken);
	return TokenComplete;
}

Token::TokenState Token::GotOP(Token & T)
{
	T.SetType(SymbolOpenParenToken);
	return TokenComplete;
}

Token::TokenState Token::GotCP(Token & T)
{
	T.SetType(SymbolCloseParenToken);
	return TokenComplete;
}

Token::TokenState Token::GotSemiCol(Token & T)
{
	T.SetType(SymbolSemiColonToken);
	return TokenComplete;
}

Token::TokenState Token::GotVar(Token & T)
{
	T.SetType(VariableToken);
	return TokenComplete;
}

Token::TokenState Token::GotConst(Token & T)
{
	T.SetType(ConstantToken);
	return TokenComplete;
}

Token::TokenState Token::GotNumAndSemiCol(Token & T)
{
	T.SetType(NumAndSemiColToken);
	return TokenComplete;
}

Token::TokenState Token::GotVarAndSemiCol(Token & T)
{
	T.SetType(VarAndSemiColToken);
	return TokenComplete;
}

Token::TokenState Token::GotConstAndCP(Token & T)
{
	T.SetType(ConstAndCPToken);
	return TokenComplete;
}

Token::TokenState Token::GotVarAndCP(Token & T)
{
	T.SetType(VarAndCPToken);
	return TokenComplete;
}

Token::TokenState Token::GotEndOfFile (Token & T)
	{
	T.SetType (EndOfInputToken);
	return TokenComplete;
	}

Token::TokenState Token::GotUnexpectedEOF (Token & T)
	{
	cout << "Got Unexpected EOF" << endl;
	T.SetType (EndOfInputToken);
	return TokenComplete;
	}

Token::TokenState Token::StartedTokenWithSpace (Token & T)
	{
	T.SetType(DelimiterSpaceToken);
	return TokenComplete;
	}

Token::TokenState Token::GotUnknownInput (Token & T)
	{
	cout << "Got unexpected input" << endl;
	T.SetType (UnknownToken);
	return TokenComplete;
	}

Token::TokenState Token::GotInvalidInput (Token & T)
	{
	cout << "Got invalid input" << endl;
	T.SetType (UnknownToken);
	return TokenComplete;
	}

