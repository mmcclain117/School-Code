/* https://github.com/victorbreder/math-expression-derivative/blob/master/deriver.cpp */

#include <iostream>
#include <cmath>
#include <vector>
#include <stack>
#include <string>
using namespace std;

const double EPS = 1e-8;

/* FUNCTION TREE */
enum AtomType { ATOM_OTHER, ATOM_NULL, ATOM_ONE, ATOM_MINUS_ONE, ATOM_NUMBER };
class Atom {
protected:
	Atom* left;
	Atom* right;
public:
	Atom() {
		left = NULL;
		right = NULL;
	}
	Atom(Atom* left) {
		this->left = left;
		this->right = NULL;
	}
	Atom(Atom* left, Atom* right) {
		this->left = left;
		this->right = right;
	}
	virtual double eval(double x) {
		return 0;
	}
	virtual Atom* derive() {
		return NULL;
	}
	virtual void print() {
	}
	virtual AtomType getType() {
		return ATOM_OTHER;
	}
};
class NullAtom : public Atom {
public:
	double eval(double x) {
		return 0;
	}
	Atom* derive() {
		return new NullAtom();
	}
	virtual void print() {
		cout << "0";
	}
	AtomType getType() {
		return ATOM_NULL;
	}
};
class Number : public Atom {
	double value;
public:
	Number(double value) {
		this->value = value;
	}
	double eval(double x) {
		return value;
	}
	Atom* derive() {
		return new NullAtom();
	}
	void print() {
		cout << value;
	}
	AtomType getType() {
		if (value >= -EPS && value <= EPS) {
			return ATOM_NULL;
		}
		else if (value >= 1 - EPS && value <= 1 + EPS) {
			return ATOM_ONE;
		}
		else if (value >= -1 - EPS && value <= -1 + EPS) {
			return ATOM_MINUS_ONE;
		}
		return ATOM_NUMBER;
	}
};
class Plus : public Atom {
public:
	Plus(Atom* left, Atom* right) : Atom(left, right) {}
	double eval(double x) {
		return left->eval(x) + right->eval(x);
	}
	Atom* derive() {
		Atom* left_derive = left->derive();
		Atom* right_derive = right->derive();
		if (left_derive->getType() != ATOM_NULL && right_derive->getType() != ATOM_NULL) {
			return new Plus(left->derive(), right->derive());
		}
		else if (left_derive->getType() != ATOM_NULL) {
			return left_derive;
		}
		else {
			return right_derive;
		}
	}
	void print() {
		cout << "("; left->print(); cout << " + "; right->print(); cout << ")";
	}
};
class Minus : public Atom {
public:
	Minus(Atom* left, Atom* right) : Atom(left, right) {}
	double eval(double x) {
		return left->eval(x) - right->eval(x);
	}
	Atom* derive() {
		Atom* left_derive = left->derive();
		Atom* right_derive = right->derive();
		if (left_derive->getType() != ATOM_NULL && right_derive->getType() != ATOM_NULL) {
			return new Minus(left->derive(), right->derive());
		}
		else if (left_derive->getType() != ATOM_NULL) {
			return left_derive;
		}
		else {
			return right_derive;
		}
	}
	void print() {
		cout << "("; left->print(); cout << " - "; right->print(); cout << ")";
	}
};
class Times : public Atom {
public:
	Times(Atom* left, Atom* right) : Atom(left, right) {}
	double eval(double x) {
		return left->eval(x) * right->eval(x);
	}
	Atom* derive() {
		Atom* left_derive = left->derive();
		Atom* right_derive = right->derive();
		if (left_derive->getType() != ATOM_NULL && right_derive->getType() != ATOM_NULL) {
			Atom* a; Atom* b;
			if (left_derive->getType() != ATOM_ONE) {
				a = new Times(left_derive, right);
			}
			else {
				a = right;
			}
			if (right_derive->getType() != ATOM_ONE) {
				b = new Times(left, right_derive);
			}
			else {
				b = left;
			}
			return new Plus(a, b);
		}
		else if (left_derive->getType() != ATOM_NULL) {
			if (left_derive->getType() != ATOM_ONE) {
				return new Times(left_derive, right);
			}
			else {
				return right;
			}
		}
		else {
			if (right_derive->getType() != ATOM_ONE) {
				return new Times(left, right_derive);
			}
			else {
				return left;
			}
		}

	}
	void print() {
		cout << "("; left->print(); cout << " * "; right->print(); cout << ")";
	}
};
class Divide : public Atom {
public:
	Divide(Atom* left, Atom* right) : Atom(left, right) {}
	double eval(double x) {
		return left->eval(x) / right->eval(x);
	}
	Atom* derive() {
		Atom* left_derive = left->derive();
		Atom* right_derive = right->derive();
		if (left_derive->getType() != ATOM_NULL && right_derive->getType() != ATOM_NULL) {
			Atom* a; Atom* b;
			if (left_derive->getType() != ATOM_ONE) {
				a = new Times(left_derive, right);
			}
			else {
				a = right;
			}
			if (right_derive->getType() != ATOM_ONE) {
				b = new Times(left, right_derive);
			}
			else {
				b = left;
			}
			return new Divide(new Minus(a, b), new Times(right, right));
		}
		else if (left_derive->getType() != ATOM_NULL) {
			Atom* a;
			if (left_derive->getType() != ATOM_ONE) {
				a = new Times(left_derive, right);
			}
			else {
				a = right;
			}
			return new Divide(a, new Times(right, right));
		}
		else {
			Atom* a;
			if (right_derive->getType() != ATOM_ONE) {
				a = new Times(left, right_derive);
			}
			else {
				a = left;
			}
			return new Divide(new Times(new Number(-1), a), new Times(right, right));
		}

	}
	void print() {
		cout << "("; left->print(); cout << ") / ("; right->print(); cout << ")";
	}
};
class X : public Atom {
	int n;
public:
	X() {
		n = 1;
	}
	X(int n) {
		this->n = n;
	}
	double eval(double x) {
		if (n == 1) {
			return x;
		}
		else {
			return pow(x, n);
		}
	}
	Atom* derive() {
		if (n == 1) {
			return new Number(1);
		}
		else {
			return new Times(new Number(n), new X(n - 1));
		}
	}
	void print() {
		if (n == 1) {
			cout << "x";
		}
		else {
			cout << "x^" << n;
		}
	}
};
class Cos : public Atom {
public:
	Cos(Atom* X);
	double eval(double x);
	Atom* derive();
	void print();
};
class Sin : public Atom {
public:
	Sin(Atom* X);
	double eval(double x);
	Atom* derive();
	void print();
};
Cos::Cos(Atom* X) {
	left = X;
	right = NULL;
}
double Cos::eval(double x) {
	return cos(left->eval(x));
}
Atom* Cos::derive() {
	Atom* left_derive = left->derive();
	if (left_derive->getType() == ATOM_ONE) {
		return new Times(new Number(-1), new Sin(left));
	}
	else {
		return new Times(new Times(new Number(-1), new Sin(left)), left_derive);
	}
}
void Cos::print() {
	cout << "cos("; left->print(); cout << ")";
}
Sin::Sin(Atom* X) {
	left = X;
	right = NULL;
}
double Sin::eval(double x) {
	return sin(left->eval(x));
}
Atom* Sin::derive() {
	Atom* left_derive = left->derive();
	if (left_derive->getType() == ATOM_ONE) {
		return new Cos(left);
	}
	else {
		return new Times(new Cos(left), left_derive);
	}
}
void Sin::print() {
	cout << "sin("; left->print(); cout << ")";
}
class Exp : public Atom {
public:
	Exp(Atom* X) : Atom(X) {}
	double eval(double x) {
		return exp(left->eval(x));
	}
	Atom* derive() {
		Atom* left_derive = left->derive();
		if (left_derive->getType() == ATOM_NULL) {
			return new NullAtom();
		}
		else if (left_derive->getType() == ATOM_ONE) {
			return new Exp(left);
		}
		else {
			return new Times(left_derive, new Exp(left));
		}
	}
	void print() {
		cout << "e^("; left->print(); cout << ")";
	}
};
class Log : public Atom {
public:
	Log(Atom* X) : Atom(X) {}
	double eval(double x) {
		return log(left->eval(x));
	}
	Atom* derive() {
		Atom* left_derive = left->derive();
		if (left_derive->getType() == ATOM_NULL) {
			return new NullAtom();
		}
		else if (left_derive->getType() == ATOM_ONE) {
			return new Divide(new Number(1), left);
		}
		else {
			return new Times(new Divide(new Number(1), left), left_derive);
		}
	}
	void print() {
		cout << "log("; left->print(); cout << ")";
	}
};

/* PARSER */
enum TokenType { TOKEN_NUMBER, TOKEN_X, TOKEN_XN, TOKEN_OPEN, TOKEN_CLOSE, TOKEN_PLUS, TOKEN_MINUS, TOKEN_TIMES, TOKEN_DIVIDE, TOKEN_SIN, TOKEN_COS, TOKEN_EXP, TOKEN_LOG };
class Token {
	TokenType type;
	double value;
public:
	Token(TokenType type) {
		this->type = type;
		this->value = 0;
	}
	Token(TokenType type, double value) {
		this->type = type;
		this->value = value;
	}
	TokenType getType() {
		return type;
	}
	double getValue() {
		return value;
	}
	int getPrecendence() {
		if (type == TOKEN_OPEN) {
			return 0;
		}
		if (type == TOKEN_CLOSE) {
			return 0;
		}
		if (type == TOKEN_PLUS || type == TOKEN_MINUS) {
			return 1;
		}
		if (type == TOKEN_TIMES || type == TOKEN_DIVIDE) {
			return 2;
		}
		return -1;
	}
	void print() {
		cout << "<";
		if (type == TOKEN_NUMBER) {
			cout << value;
		}
		else if (type == TOKEN_X) {
			cout << "x";
		}
		else if (type == TOKEN_OPEN) {
			cout << "(";
		}
		else if (type == TOKEN_CLOSE) {
			cout << ")";
		}
		else if (type == TOKEN_PLUS) {
			cout << "+";
		}
		else if (type == TOKEN_MINUS) {
			cout << "-";
		}
		else if (type == TOKEN_TIMES) {
			cout << "*";
		}
		else if (type == TOKEN_DIVIDE) {
			cout << "/";
		}
		else if (type == TOKEN_SIN) {
			cout << "sin(";
		}
		else if (type == TOKEN_COS) {
			cout << "cos(";
		}
		else if (type == TOKEN_EXP) {
			cout << "exp(";
		}
		else if (type == TOKEN_LOG) {
			cout << "log(";
		}
		cout << "> ";
	}
};
class Parser {
	string input;
	vector<Token> tokens;
	char getChar(unsigned int i) {
		if (i >= 0 && i < input.length()) {
			return input[i];
		}
		return '\0';
	}
public:
	Parser(string input) {
		this->input = input;
	}
	void tokenize() {
		unsigned int i = 0;
		tokens.push_back(Token(TOKEN_OPEN));
		while (i < input.length()) {
			if (getChar(i) == ' ') {
				i++;
			}
			else if ((getChar(i) >= '0' && getChar(i) <= '9') || getChar(i) == '.') {
				int j = 0;
				int pointJ = -1;
				double val = 0;
				bool number = true;
				while (number) {
					if ((getChar(i + j) >= '0' && getChar(i + j) <= '9')) {
						val *= 10;
						val += getChar(i + j) - '0';
						j++;
					}
					else if (getChar(i + j) == '.') {
						if (pointJ == -1) {
							pointJ = j;
						}
						else {
							cout << "Error: Invalid numeric value";
							return;
						}
						j++;
					}
					else {
						number = false;
					}
				}
				if (pointJ != -1) {
					for (int divide = j - 1 - pointJ; divide > 0; divide--) {
						val /= 10;
					}
				}
				tokens.push_back(Token(TOKEN_NUMBER, val));
				i += j;
			}
			else if (getChar(i) == '(') {
				tokens.push_back(Token(TOKEN_OPEN));
				i++;
			}
			else if (getChar(i) == ')') {
				tokens.push_back(Token(TOKEN_CLOSE));
				i++;
			}
			else if (getChar(i) == '+') {
				tokens.push_back(Token(TOKEN_PLUS));
				i++;
			}
			else if (getChar(i) == '-') {
				tokens.push_back(Token(TOKEN_MINUS));
				i++;
			}
			else if (getChar(i) == '*') {
				tokens.push_back(Token(TOKEN_TIMES));
				i++;
			}
			else if (getChar(i) == '/') {
				tokens.push_back(Token(TOKEN_DIVIDE));
				i++;
			}
			else if (getChar(i) == 'x' && getChar(i + 1) == '^' && getChar(i + 2) == '(') {
				tokens.push_back(Token(TOKEN_XN));
				i += 3;
			}
			else if (getChar(i) == 'x') {
				tokens.push_back(Token(TOKEN_X));
				i++;
			}
			else if (getChar(i) == 's' && getChar(i + 1) == 'i' && getChar(i + 2) == 'n' && getChar(i + 3) == '(') {
				tokens.push_back(Token(TOKEN_SIN));
				i += 4;
			}
			else if (getChar(i) == 'c' && getChar(i + 1) == 'o' && getChar(i + 2) == 's' && getChar(i + 3) == '(') {
				tokens.push_back(Token(TOKEN_COS));
				i += 4;
			}
			else if (getChar(i) == 'e' && getChar(i + 1) == 'x' && getChar(i + 2) == 'p' && getChar(i + 3) == '(') {
				tokens.push_back(Token(TOKEN_EXP));
				i += 4;
			}
			else if (getChar(i) == 'e' && getChar(i + 1) == '^' && getChar(i + 3) == '(') {
				tokens.push_back(Token(TOKEN_EXP));
				i += 3;
			}
			else if (getChar(i) == 'l' && getChar(i + 1) == 'o' && getChar(i + 2) == 'g' && getChar(i + 3) == '(') {
				tokens.push_back(Token(TOKEN_LOG));
				i += 4;
			}
			else {
				cout << "Error: Invalid token: '" << getChar(i) << "'\n";
				return;
			}
		}
		tokens.push_back(Token(TOKEN_CLOSE));
	}
	Atom* parse() {
		unsigned int i = 0;
		stack<Atom*> numbers;
		stack<Token> operators;
		while (i < tokens.size()) {
			if (tokens[i].getType() == TOKEN_NUMBER) {
				numbers.push(new Number(tokens[i].getValue()));
			}
			else if (tokens[i].getType() == TOKEN_X) {
				numbers.push(new X());
			}
			else {
				if (tokens[i].getType() == TOKEN_OPEN || tokens[i].getType() == TOKEN_SIN || tokens[i].getType() == TOKEN_COS
					|| tokens[i].getType() == TOKEN_EXP || tokens[i].getType() == TOKEN_LOG || tokens[i].getType() == TOKEN_XN) {
					operators.push(tokens[i]);
				}
				else if (tokens[i].getType() != TOKEN_CLOSE) {
					while (tokens[i].getPrecendence() < operators.top().getPrecendence()) {
						Token op = operators.top(); operators.pop();
						if (op.getType() == TOKEN_PLUS) {
							Atom* a = numbers.top(); numbers.pop();
							Atom* b = numbers.top(); numbers.pop();
							numbers.push(new Plus(b, a));
						}
						else if (op.getType() == TOKEN_MINUS) {
							Atom* a = numbers.top(); numbers.pop();
							Atom* b = numbers.top(); numbers.pop();
							numbers.push(new Minus(b, a));
						}
						else if (op.getType() == TOKEN_TIMES) {
							Atom* a = numbers.top(); numbers.pop();
							Atom* b = numbers.top(); numbers.pop();
							numbers.push(new Times(b, a));
						}
						else if (op.getType() == TOKEN_DIVIDE) {
							Atom* a = numbers.top(); numbers.pop();
							Atom* b = numbers.top(); numbers.pop();
							numbers.push(new Divide(b, a));
						}
					}
					operators.push(tokens[i]);
				}
				else { // tokens[i].getType() == TOKEN_CLOSE
					while (operators.size() > 0 && operators.top().getType() != TOKEN_OPEN && operators.top().getType() != TOKEN_SIN
						&& operators.top().getType() != TOKEN_COS && operators.top().getType() != TOKEN_EXP
						&& operators.top().getType() != TOKEN_LOG && operators.top().getType() != TOKEN_XN) {
						Token op = operators.top(); operators.pop();
						if (op.getType() == TOKEN_PLUS) {
							Atom* a = numbers.top(); numbers.pop();
							Atom* b = numbers.top(); numbers.pop();
							numbers.push(new Plus(b, a));
						}
						else if (op.getType() == TOKEN_MINUS) {
							Atom* a = numbers.top(); numbers.pop();
							Atom* b = numbers.top(); numbers.pop();
							numbers.push(new Minus(b, a));
						}
						else if (op.getType() == TOKEN_TIMES) {
							Atom* a = numbers.top(); numbers.pop();
							Atom* b = numbers.top(); numbers.pop();
							numbers.push(new Times(b, a));
						}
						else if (op.getType() == TOKEN_DIVIDE) {
							Atom* a = numbers.top(); numbers.pop();
							Atom* b = numbers.top(); numbers.pop();
							numbers.push(new Divide(b, a));
						}
					}
					Token op = operators.top(); operators.pop();
					if (op.getType() == TOKEN_SIN) {
						Atom* a = numbers.top(); numbers.pop();
						numbers.push(new Sin(a));
					}
					else if (op.getType() == TOKEN_COS) {
						Atom* a = numbers.top(); numbers.pop();
						numbers.push(new Cos(a));
					}
					else if (op.getType() == TOKEN_EXP) {
						Atom* a = numbers.top(); numbers.pop();
						numbers.push(new Exp(a));
					}
					else if (op.getType() == TOKEN_LOG) {
						Atom* a = numbers.top(); numbers.pop();
						numbers.push(new Log(a));
					}
					else if (op.getType() == TOKEN_XN) {
						Atom* a = numbers.top(); numbers.pop();
						numbers.push(new X((int)(a->eval(0))));
					}
				}
			}
			i++;
		}
		return numbers.top();
	}
};

/* PROGRAM */
int mains() {
	while (true) {
		string input;
		getline(cin, input);
		Parser parser(input);
		parser.tokenize();
		Atom* f = parser.parse();
		cout << "f(x)  = "; 
		f->print(); 
		cout << "\n";
		cout << "f'(x) = "; 
		f->derive()->print(); 
		cout << "\n";
		cout << "f''(x) = "; 
		f->derive()->derive()->print(); 
		cout << "\n";
		cout << "f'''(x) = ";
		f->derive()->derive()->derive()->print();
		cout << "\n";
		cout << "f''''(x) = ";
		f->derive()->derive()->derive()->derive()->print();
		cout << "\n\n";
	}

	/*
	// f(x) = sin(3 * x) + cos (sin(x) + 3)
	Atom* f_x = new Plus(new Sin(new Times(new Number(3), new X())), new Cos(new Plus(new Sin(), new Number(3))));

	// f(x) = e^(3 * sin(x)) - x^2
	//Atom* f = new Minus(new Exp(new Times(new Number(3), new Sin())), new X(2));

	// f(x) = e^(-x^2) - cos(x)
	//Atom* f = new Minus(new Exp(new Times(new Number(-1), new X(2))), new Cos());

	// f(x) = sen(x) / cos(x)
	Atom* f = new Log(new Divide(new Sin(), new Cos()));

	Atom* f_derive = f->derive();
	cout << "f(x)  = "; f->print(); cout << "\n";
	cout << "f'(x) = "; f_derive->print(); cout << "\n\n";

	double x = 1.5;
	double f_x = f->eval(x);
	double f_derive_x;

	int i = 0;
	while (abs(f_x) > 10e-15 && i++ < 20) {
		f_x = f->eval(x);
		f_derive_x = f_derive->eval(x);
		cout << "x = " << x << "\tf(x) = " << f_x << "\tf'(x) = " << f_derive_x << "\n";
		x = x - f_x / f_derive_x; //x = x - f(x)/f'(x)
	}
	cout.precision(15);
	cout << x << "\n";*/
}