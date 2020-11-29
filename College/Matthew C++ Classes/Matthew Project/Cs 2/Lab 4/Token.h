#ifndef TOKEN_H
#define TOKEN_H

#include <fstream>
#include <iostream>

using namespace std;

#include "WCS_String.h"
#include "Operator.h"
#include "Variable.h"

class Token
	{
	public:
		//		**********	enums		**********
			enum	Variables				{
											NumVariables = 100
											};
			enum	Exception				{
											TokenFileNotOpen
											};
			enum	TokenType				{
											EndOfInputToken,
											UnknownToken,
											VariableToken,
											ConstantToken,
											KeywordEvalToken,
											KeywordExpToken,
											KeywordValueToken,
											OperatorPlusToken,
											OperatorMinusToken,
											OperatorAsteriskToken,
											OperatorSlashToken,
											SymbolOpenParenToken,
											SymbolCloseParenToken,
											SymbolSemiColonToken,
											NumAndSemiColToken,
											VarAndSemiColToken,
											ConstAndCPToken,
											VarAndCPToken,
											DelimiterSpaceToken,

											NumTokens
											};
		//		**********	typedefs	**********
			typedef unsigned char			UChar;
		//		**********	miscellaneous	**********
			long numchars;
			char chars[7];//Only numbers up to 7 digits are officially supported
		//		**********	functions	**********
											Token			();
					explicit				Token			(const Token &);
					explicit				Token			(TokenType, int);
											~Token			();
	Token &	Build()
	{
		if (SourceFile.is_open())
		{
			numchars = -1;
			TokenState CurrentState(StartGettingToken);
			SetType(UnknownToken);
			do {
				CurrentState = StateFunction[StateTable[GetInputChar()][CurrentState]](*this);
				PutBackLastChar();
				numchars++;
				chars[numchars] = SourceFile.get();
			} while (CurrentState != TokenComplete);
			return *this;
		}
		else
			throw TokenFileNotOpen;
	}
			static	void					CloseFile		();
			Operator::Precedence			GetPrecedence	() const;
					TokenType				GetType			() const;
					Variable::ValueType		GetValue		() const;
					int						GetWhich		() const;
			static	void					OpenFile		(const WCS_String &);
					void					SetPrecedence	(Operator::Precedence);
					void					SetValue		(Variable::ValueType);
					Token &					operator=		(const Token &);
	private:
		//		**********	enums		**********
			enum	InputType				{
											InputUnknown,
											InputA,
											InputE,
											InputL,
											InputP,
											InputU,
											InputV,
											InputX,
											Input0,
											Input1,
											Input2,
											Input3,
											Input4,
											Input5,
											Input6,
											Input7,
											Input8,
											Input9,
											InputPlus,
											InputMinus,
											InputAsterisk,
											InputSlash,
											InputOpenParen,
											InputCloseParen,
											InputSemiColon,
											InputSpace,
											EndOfFile,

											NumInputs
											};
			enum	TokenState				{
											TokenComplete = -1,
											StartGettingToken,
											AfterE,
											AfterV,
											AfterEV,
											AfterEVA,
											AfterVA,
											AfterVAL,
											AfterVALU,
											AfterEX,
											After0,
											After1,
											After2,
											After3,
											After4,
											After5,
											After6,
											After7,
											After8,
											After9,
											AfterNum,

											NumStates
											};
		//		**********	typedefs	**********
			typedef int						State;
			typedef TokenState				(*TokenFunc)		(Token &);
		//	**********	functions	**********
					InputType				GetInputChar			();
					void					Init					(TokenType, int);
					void					PutBackLastChar			() const;
					void					SetType					(TokenType);
					void					SetWhich				(int);
			static	TokenState				NotYetWritten			(Token &);
			static	TokenState				GotE					(Token &);
			static	TokenState				GotEV					(Token &);
			static	TokenState				GotEVA					(Token &);
			static	TokenState				GotEVAL					(Token &);
			static	TokenState				GotV					(Token &);
			static	TokenState				GotVA					(Token &);
			static	TokenState				GotVAL					(Token &);
			static	TokenState				GotVALU					(Token &);
			static	TokenState				GotVALUE				(Token &);
			static	TokenState				GotEX					(Token &);
			static	TokenState				GotEXP					(Token &);
			static	TokenState				GotADD					(Token &);
			static	TokenState				GotSUB					(Token &);
			static	TokenState				GotMUL					(Token &);
			static	TokenState				GotDIV					(Token &);
			static	TokenState				GotOP					(Token &);
			static	TokenState				GotCP					(Token &);
			static	TokenState				GotSemiCol				(Token &);
			static	TokenState				Got0					(Token &);
			static	TokenState				Got1					(Token &);
			static	TokenState				Got2					(Token &);
			static	TokenState				Got3					(Token &);
			static	TokenState				Got4					(Token &);
			static	TokenState				Got5					(Token &);
			static	TokenState				Got6					(Token &);
			static	TokenState				Got7					(Token &);
			static	TokenState				Got8					(Token &);
			static	TokenState				Got9					(Token &);
			static	TokenState				GotVar					(Token &);
			static	TokenState				GotNum					(Token &);
			static	TokenState				GotConst				(Token &);
			static	TokenState				GotNumAndSemiCol		(Token &);
			static	TokenState				GotVarAndSemiCol		(Token &);
			static	TokenState				GotConstAndCP			(Token &);
			static	TokenState				GotVarAndCP				(Token &);
			static	TokenState				GotEndOfFile			(Token &);
			static	TokenState				GotUnexpectedEOF		(Token &);
			static	TokenState				StartedTokenWithSpace	(Token &);
			static	TokenState				GotUnknownInput			(Token &);
			static	TokenState				GotInvalidInput			(Token &);

			static	InputType				InputTable		[];
			static	UChar					LastChar;
			static	ifstream				SourceFile;
			static	TokenFunc				StateFunction	[];
			static	UChar					StateTable		[NumInputs] [NumStates];
			static	Variable				VariableArray	[NumVariables];
		//	**********	data		**********
					TokenType				Type;
					union
						{
						int						Which;
						Operator::Precedence	Precedence;
						Variable::ValueType		Value;
						};
	};

inline Token::Token ()
	{
	Init (EndOfInputToken, 0);
	}

inline Token::Token (const Token & T)
	{
	Init (T.Type, T.Which);
	}

inline Token::Token (TokenType NewType, int NewValue)
	{
	Init (NewType, NewValue);
	}

inline Token::~Token ()
	{
	}

inline void Token::CloseFile ()
	{
	SourceFile.close ();
	}

inline Operator::Precedence Token::GetPrecedence () const
	{
	return Precedence;
	}

inline Token::TokenType Token::GetType () const
	{
	return Type;
	}

inline Variable::ValueType Token::GetValue () const
	{
	return (Type == VariableToken) ? VariableArray [Which].GetValue () : Value;
	}

inline int Token::GetWhich () const
	{
	return Which;
	}

inline void Token::OpenFile (const WCS_String & FileName)
	{
	SourceFile.open (static_cast <const char *> (FileName));
	if (!SourceFile.is_open ())
			{
			cout << "File did not open" << endl;
			exit (0);
			}
		else;
	}

inline void Token::SetValue (Variable::ValueType V)
	{
	if (Type == VariableToken)
			VariableArray [Which].SetValue (V);
		else
			Value = V;
	}

inline Token & Token::operator= (const Token & T)
	{
	if (this != &T)
			Init (T.Type, T.Which);
		else;
	return *this;
	}

inline Token::InputType Token::GetInputChar ()
	{
	return InputTable [LastChar = static_cast <UChar> (SourceFile.get ())];
	}

inline void Token::Init (TokenType T, int V)
	{
	Type = T;
	Value = V;
	}

inline void Token::PutBackLastChar () const
	{
	SourceFile.putback (LastChar);
	}

inline void Token::SetPrecedence (Operator::Precedence P)
	{
	Precedence = P;
	}

inline void Token::SetType (TokenType T)
	{
	Type = T;
	}

inline void Token::SetWhich (int W)
	{
	Which = W;
	}

#endif
