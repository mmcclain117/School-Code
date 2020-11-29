#include <iostream>
#include <cctype>
#include <cstdlib>
#include <string>
#include <vector>
#include <list>
#include <algorithm>
#include <stack>
#include <cmath>

using namespace std;

/* This is for each Character that is there */
class Variable {
public:
	char id;
	int exp;
	Variable() { // required by <vector>;
	}
	Variable(char c, int i) {
		id = c; exp = i;
	}
	bool operator== (const Variable& v) const {
		return id == v.id  && exp == v.exp;
	}
	bool operator< (const Variable& v) const { // used by sort();
		return id < v.id;
	}
};

/* This is for each specific Monomial */
class Term {
public:
	Term() {
		coeff = 0;
	}
	int coeff; // Coeff of the Monomial
	vector<Variable> vars;
	bool operator== (const Term&) const;
	bool operator!= (const Term& term) const { // required by <list>
		return !(*this == term);
	}
	bool operator< (const Term&) const;
	bool operator> (const Term& term) const {  // required by <list>
		return *this != term && (*this < term);
	}
	int min(int n, int m) const {
		return (n < m) ? n : m;
	}

	bool contain(char c) {
		for (unsigned int i = 0; i < vars.size(); i++) {
			if (c == vars[i].id) {
				return true;
			}
		}
		return false;
	}

	/* Index of the derived character */
	int  derIndex(char c) {
		for (unsigned int i = 0; i < vars.size(); i++) {
			if (vars[i].id == c) {
				return i;
			}
		}
		return -1; // Not found
	}
};

/* The whole polynomial */
class Polynomial {
public:
	Polynomial() {
	}
	Polynomial operator+ (Polynomial&);
	Polynomial operator* (Polynomial&);
	Polynomial operator- (Polynomial&);
	Polynomial operator/ (Polynomial&); // Never created
	Polynomial derive(Polynomial&);

private:
	list<Term> terms;
	/* Inputting the Polynomial Term */
	friend istream& operator>> (istream& in, Polynomial& polyn) {
		char ch, sign, coeffUsed, id;
		int exp;
		Term term;
		in >> ch;
		while (true) {
			coeffUsed = 0;
			/* Filters out Everything but (A-Za-z0-9;+-) */
			if (!isalnum(ch) && ch != ';' && ch != '-' && ch != '+') {
				cout << ("Wrong character entered2") << endl << ch;
				//				break;
			}
			sign = 1;
			while (ch == '-' || ch == '+') { // first get sign(s) of Term
				if (ch == '-') {
					sign *= -1;
				}
				ch = in.get();
				if (isspace(ch)) { // Removes if there are spaces
					in >> ch;
				}
			}
			if (isdigit(ch)) {  // and then its coefficient;
				in.putback(ch);
				in >> term.coeff;
				ch = in.get();
				term.coeff *= sign;
				coeffUsed = 1;
			}
			else {// Coefficent is 1
				term.coeff = sign;
			}
			int i = 0;
			for (; isalnum(ch); i++) { // process this term:
				id = ch;                    // get a variable name
				ch = in.get();
				if (isdigit(ch)) {          // and an exponent (if any);
					in.putback(ch);
					in >> exp >> ch;
				}
				else {
					exp = 1;
				}
				term.vars.push_back(Variable(id, exp));
			}
			polyn.terms.push_back(term);    // and include it in the linked list;
			term.vars.resize(0);
			if (isspace(ch)) {
				in >> ch;
			}
			if (ch == ';') // At the escape character
				if (coeffUsed || i > 0) {
					break;
				}
				else {
					cout << "Term is missing" << endl;  // e.g., 2x - ; or just ';'
				}
			else if (ch != '-' && ch != '+') {          // e.g., 2x  4y;
				cout << "wrong character entered" << endl;
				break;
			}
		}
		for (list<Term>::iterator it = polyn.terms.begin(); it != polyn.terms.end(); it++) { //Sorts the Polynomials
			if (it->vars.size() > 1) {
				sort(it->vars.begin(), it->vars.end());
			}
		}
		return in;
	}

	/* Modifying the output on the polynomial */
	friend ostream& operator<< (ostream& out, const Polynomial& polyn) {
		int afterFirstTerm = 0;
		unsigned int i;
		for (list<Term>::const_iterator pol = polyn.terms.begin(); pol != polyn.terms.end(); pol++) {
			out.put(' ');
			if (pol->coeff < 0)             // For Negative Coefficents
				out.put('-');              // and between terms (if needed);
			else if (afterFirstTerm)        // Skiping the 1st Polynomial
				out.put('+');              // puts + in front of polynomial
			afterFirstTerm++;
			if (abs(pol->coeff) != 1)       // print a coefficient if it is not 1 or -1
				out << ' ' << abs(pol->coeff);
			else if (pol->vars.size() == 0) // the term has only a coefficient
				out << " 1";
			else
				out.put(' ');
			for (i = 1; i <= (pol->vars.size()); i++) {
				out << pol->vars[i - 1].id;       // print a variable name
				if (pol->vars[i - 1].exp != 1)    // Print exponent if not 1
					out << pol->vars[i - 1].exp;
			}
		}
		//		out << endl;
		out << " ";
		return out;
	}
};

// two terms are equal if all varibles are the same and
// corresponding variables are raised to the same powers;
// the first cell of the node containing a term is excluded
// from comparison, since it stores coefficient of the term;

/* The two terms are equal if variables and their powers are the same */
bool Term::operator== (const Term& term) const {
	int i;
	for (i = 0; i < min(vars.size(), term.vars.size()) &&
		vars[i] == term.vars[i]; i++);
	return i == vars.size() && vars.size() == term.vars.size();
}

/* Compares two terms */
bool Term::operator< (const Term& term2) const { // used by sort();
	if (vars.size() == 0) {
		return false;           // *this is just a coefficient;
	}
	else if (term2.vars.size() == 0) {
		return true;            // term2 is just a coefficient;
	}
	for (int i = 0; i < min(vars.size(), term2.vars.size()); i++) {
		if (vars[i].id < term2.vars[i].id) {
			return true;       // *this precedes term2;
		}
		else if (term2.vars[i].id < vars[i].id) {
			return false;      // term2 precedes *this;
		}
		else if (vars[i].exp < term2.vars[i].exp) {
			return true;       // *this precedes term2;
		}
		else if (term2.vars[i].exp < vars[i].exp) {
			return false;      // term2 precedes *this;
		}
	}
	return ((int)vars.size() - (int)term2.vars.size() < 0) ? true : false;
}

/* Addition Override */
Polynomial Polynomial::operator+ (Polynomial& polyn2) {
	Polynomial result;
	list<Term>::iterator p1, p2;
	bool erased;
	for (p1 = terms.begin(); p1 != terms.end(); p1++)  // Copies Poly 1 to Result
		result.terms.push_back(*p1);
	for (p1 = polyn2.terms.begin(); p1 != polyn2.terms.end(); p1++) // Copies Poly 2 to Result
		result.terms.push_back(*p1);
	for (p1 = result.terms.begin(); p1 != result.terms.end(); ) {
		for (p2 = p1, p2++, erased = false; p2 != result.terms.end(); p2++)
			if (*p1 == *p2) {  // 2 Terms but coefficent are equal
				p1->coeff += p2->coeff;
				result.terms.erase(p2);  // Erases Poly 2
				if (p1->coeff == 0)      // a redundant term; if the 
					result.terms.erase(p1);// coefficient in retained term 
				erased = true;             // is zero, erase the term as well;
				break;
			}
		if (erased)        // restart processing from the beginning
			p1 = result.terms.begin();  // if any node was erased;
		else p1++;
	}
	result.terms.sort();
	return result;
}

/* Subraction Override */
Polynomial Polynomial::operator- (Polynomial& polyn2) {
	Polynomial result;
	list<Term>::iterator p1, p2;
	bool erased;
	for (p1 = terms.begin(); p1 != terms.end(); p1++)  // Copies Poly 1 to Result
		result.terms.push_back(*p1);
	for (p1 = polyn2.terms.begin(); p1 != polyn2.terms.end(); p1++) { // Copies Poly 2 to Result
		result.terms.push_back(*p1);
	}
	for (p1 = result.terms.begin(); p1 != result.terms.end(); ) {
		for (p2 = p1, p2++, erased = false; p2 != result.terms.end(); p2++)
			if (*p1 == *p2) {  // 2 Terms but coefficent are equal
				p1->coeff += (-1 * p2->coeff);
				result.terms.erase(p2);  // Erases Poly 2
				if (p1->coeff == 0)      // a redundant term; if the 
					result.terms.erase(p1);// coefficient in retained term 
				erased = true;             // is zero, erase the term as well;
				break;
			}
		if (erased)        // restart processing from the beginning
			p1 = result.terms.begin();  // if any node was erased;
		else p1++;
	}
	result.terms.sort();
	return result;
}

/* Multiplication Override */
Polynomial Polynomial::operator* (Polynomial& polyn2) {
	Polynomial result;
	Polynomial equationResult;
	list<Term>::iterator p1, p2;
	for (p1 = terms.begin(); p1 != terms.end(); p1++) {// Copies Poly 1 to Result
		result.terms.push_back(*p1);
	}
	for (p1 = result.terms.begin(); p1 != result.terms.end(); p1++) {// 1st Equation
		vector<Variable> p3vars;
		for (p2 = polyn2.terms.begin(); p2 != polyn2.terms.end(); p2++) { // 2nd Equation
			vector<Variable> p1vars = p1->vars; // 1st Variables 
			vector<Variable> p2vars = p2->vars; // 2nd Variables
			Term t;
			t.coeff = p1->coeff * p2->coeff;
			/*adding everything to the last thing */
			for (unsigned int a = 0; a < p2vars.size(); a++) {
				p3vars.push_back(p2vars[a]);
			}
			for (unsigned int a = 0; a < p1vars.size(); a++) {
				bool added = false;
				for (unsigned int i = 0; i < p3vars.size(); i++) {
					if (p3vars[i].id == p1vars[a].id) {
						p3vars[i].exp += p1vars[a].exp;
						added = true;
					}
				}
				if (!added) {
					p3vars.push_back(p1vars[a]);
				}
			}
			t.vars = p3vars;
			equationResult.terms.push_front(t);
			p3vars.clear();
		}
	}
	/* Popping off the 2nd Equiation */
	for (unsigned int i = 0; i < polyn2.terms.size(); i++) {
		//		result.terms.pop_back();
	}
	equationResult.terms.sort();
	return equationResult;
}

/* Check to see if this is used */
Polynomial Polynomial::derive(Polynomial& polyn2) {
	/* It is getting the derivative of the whole equation */
	Polynomial result;
	Polynomial ends;
	list<Term>::iterator p1, p2;
	for (p1 = polyn2.terms.begin(); p1 != polyn2.terms.end(); p1++) { // Copies Poly 1 to Result
		result.terms.push_back(*p1);
	}
	for (p1 = result.terms.begin(); p1 != result.terms.end();) {
		int jud = p1->vars.size(); // Judgement Size
		if (jud == 0) {
			p1->coeff = 0;
			p1++;
		}
		else if (jud == 1) { // Only 1 Variable
			if (p1->vars.at(0).id == 'x') { // Just take the answer of
				p1->coeff *= p1->vars.at(0).exp;
				p1->vars.at(0).exp -= 1;
				ends.terms.push_back(*p1);
				p1++;
			}
			else { // Get rid of
				p1->coeff = 0;
				p1->vars.clear();
				p1++;
			}
		}
		else if (jud > 1) { // More than 1 variable
			int der = p1->derIndex('x');
			if (p1->contain('x')) { // Check for Variable
				// Multiplication
				p1->coeff *= p1->vars.at(der).exp;
				p1->vars.at(der).exp -= 1;
				p1++;
				// Division
			}
			else {
				p1->vars.clear();
				p1->coeff = 0;
			}
		}
	}
	return ends;
}


/* https://github.com/victorbreder/math-expression-derivative/blob/master/deriver.cpp */

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
enum TokenType {
	TOKEN_NUMBER, TOKEN_X, TOKEN_XN, TOKEN_OPEN, TOKEN_CLOSE, TOKEN_PLUS, TOKEN_MINUS, TOKEN_TIMES, TOKEN_DIVIDE, TOKEN_SIN, TOKEN_COS, TOKEN_EXP, TOKEN_LOG
};

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
		switch (type) {
		case TOKEN_NUMBER:
			cout << value;
			break;
		case TOKEN_X:
			cout << "x";
			break;
		case TOKEN_OPEN:
			cout << "(";
			break;
		case TOKEN_CLOSE:
			cout << ")";
			break;
		case TOKEN_PLUS:
			cout << "+";
			break;
		case TOKEN_MINUS:
			cout << "-";
			break;
		case TOKEN_TIMES:
			cout << "*";
			break;
		case TOKEN_DIVIDE:
			cout << "/";
			break;
		case TOKEN_SIN:
			cout << "sin(";
			break;
		case TOKEN_COS:
			cout << "cos(";
			break;
		case TOKEN_EXP:
			cout << "exp(";
			break;
		case TOKEN_LOG:
			cout << "log(";
			break;
		default:
			break;
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

struct Poly {
	int coeff; // Coefficent
	int x; // X exponent
	int y; // Y exponent
	Poly(int a, int b, int c) {
		coeff = a;
		x = b;
		y = c;
	}
	string toString() {
		string s = to_string(coeff) + " " + to_string(x) + " " + to_string(y) + "/n";
		return s;
	}
};

/* f'g */
Poly rule1(Poly a) {
	Poly tmp(a.coeff * a.x, a.x - 1, a.y);
	return tmp;

}

/* anx^n-1 */
Poly rule4(Poly a) {
	Poly tmp(a.coeff * a.x, a.x - 1, a.y);
	return tmp;
}

/* fg'-f'g / g^2 */
Poly rule3(Poly a) {
	int ys = a.y > 0 ? a.y : a.y * -1;
	Poly co = rule4(a);
	Poly q(co.coeff, co.x, -ys * ys);
	return q;
}

/* (f)'+ (g)' */
Poly rule2(Poly a) {
	return a;
}

string form(Poly a) {
	string s = "";
	if (a.coeff < 0) {
		s = "";
	}
	else {
		s = "+";
	}
	s += to_string(a.coeff);
	if (a.x != 0) { // There is an X
		s += "x";
		if (a.x != 1) { // Not exponental power 1
			s += "^" + to_string(a.x);
		}
	}
	if (a.y != 0) { // There is an Y
		if (a.y < 0) { // Negative
			s += "/y";
		}
		else { // Positive
			s += "y";
		}
		if (a.y == -1 || a.y == 1) { // it doenst need an exponent
		}
		else {
			s += "^" + to_string(a.y);
		}
	}
	return s;
}


int main() {
	// Input Examples
	// 2xy+x2-y2+2x;x3+2x+x2+x3+x4+xyz5;
	// x2+2x-1;x3-x+y+5;
	// x2+x+1;x+2;
	/* Setup Menu */
	int selection;
	cout << "Here is the very sensative Program that Took forever to make.\n";
	while (true) {
		cout << "MENU\n----------------------\n";
		cout << "0. EXIT\n";
		cout << "1. Adding Polynomials\n";
		cout << "2. Subtracting Polynomials\n";
		cout << "3. Multiplying Polynomials\n";
		cout << "4. Dividing Polynomails\n";
		cout << "5. Adding and Subtracting\n";
		cout << "6. Adding and Multiplying\n";
		cout << "7. Adding and Subtracting and Multiplying\n";
		cout << "8. Subtracting and Multiplying\n";
		cout << "9. Simple Derivative\n";
		cout << "10. Multiple Simple Derivatives\n";
		cout << "11. Expanded Derivative\n";
		cout << "12. Multiple Expanded Derivatives\n";
		cout << "13. ERROR LIST\n";
		Polynomial polyn1, polyn2;
		cin >> selection;
		if (selection == 0) {
			cout << "My work here is done\nHave a nice day\n";
			break;
		}
		else if (selection >= 1 && selection <= 8) { // Basic Settings
			cout << "An example of this is: x2+2x-1;x3-x+y+5;\n";
			switch (selection) {
			case 1: // Adding
				cout << "Enter two polynomials, each ended with a semicolon:\n";
				cin >> polyn1 >> polyn2;
				cout << polyn1 << " + " << polyn2 << " = " << polyn1 + polyn2 << endl;
				break;
			case 2: // Subtracting
				cout << "Enter two polynomials, each ended with a semicolon:\n";
				cin >> polyn1 >> polyn2;
				cout << polyn1 << " - " << polyn2 << " = " << polyn1 - polyn2 << endl;
				break;
			case 3:  // Multiplying
				cout << "Enter two polynomials, each ended with a semicolon:\n";
				cin >> polyn1 >> polyn2;
				cout << polyn1 << " * " << polyn2 << " = " << polyn1 * polyn2 << endl;
				break; // Need to check
			case 4: // Dividing
				cout << "Enter two polynomials, each ended with a semicolon:\n";
				cin >> polyn1 >> polyn2;
				cout << "LOL. I can't really do that. Sorry, bit not really. Goodbye\n";
				//			cout << polyn1 << " / " << polyn2 << " = " << polyn1 + polyn2 << endl;
				break;
			case 5: // Adding and Subtracting
				cout << "Enter two polynomials, each ended with a semicolon:\n";
				cin >> polyn1 >> polyn2;
				cout << polyn1 << " + " << polyn2 << " = " << polyn1 + polyn2 << endl;
				cout << polyn1 << " - " << polyn2 << " = " << polyn1 - polyn2 << endl;
				break;
			case 6: // Addition and Multiplication
				cout << "Enter two polynomials, each ended with a semicolon:\n";
				cin >> polyn1 >> polyn2;
				cout << polyn1 << " + " << polyn2 << " = " << polyn1 + polyn2 << endl;
				cout << polyn1 << " * " << polyn2 << " = " << polyn1 * polyn2 << endl;
				break;
			case 7: // Addition, Subtraction, and Multiplication
				cout << "Enter two polynomials, each ended with a semicolon:\n";
				cin >> polyn1 >> polyn2;
				cout << polyn1 << " + " << polyn2 << " = " << polyn1 + polyn2 << endl;
				cout << polyn1 << " - " << polyn2 << " = " << polyn1 - polyn2 << endl;
				cout << polyn1 << " * " << polyn2 << " = " << polyn1 * polyn2 << endl;
				break;
			case 8: // Subtracting and Multiplication
				cout << "Enter two polynomials, each ended with a semicolon:\n";
				cin >> polyn1 >> polyn2;
				cout << polyn1 << " - " << polyn2 << " = " << polyn1 - polyn2 << endl;
				cout << polyn1 << " * " << polyn2 << " = " << polyn1 * polyn2 << endl;
				break;
			default:
				cout << "Well Shit your not suppose to be here. \n";
				break;
			}
		}
		else if (selection == 9 || selection == 10) {
			cout << "So this one is a little simple and DOES NOT include Advance things\n";
			cout << "This includes Multiplication, Division, Addition, and subtraction of variables x and y\n";
			cout << "Make sure it follows the format ( EQUATION)';\n";
			cout << "An example is (5x3+6x/y-10x2y+100)';\n";
			cout << "This yields the output: "; // Input the output here
			stack <Poly> eq;
			stack <Poly> end;
			cout << "Enter a polynomial and end with semicolon" << endl;
			string equa;
			cin >> equa;
			//		string equa = "(5x3+6x/y-10x2y+100)';";
			cout << equa << endl;
			if (selection == 10) { // Selecttion of 10
				cout << "I can't really do that due to variable restrictions. I do not dissapoint though so I will do a single derivative of the equation";
			}
			string yExp = ""; // Y Exponent
			string coeff = "";
			string xExp = "";
			Poly op(0, 0, 0); // Open Parenthases
			Poly cl(0, -1, -1); // Closed Parenthases
			Poly de(-1, -1, -1); // Derive the equation
			bool yNeg = false; // Y in the denominator
			for (int i = 0; i < equa.length(); i++) {
				/* Take care of the negative part */
				if (equa[i] == '+') {
					if (yExp == "") {
						yExp = "0";
					}
					//			cout << coeff << " " << xe << " " << ye << endl;
					Poly tmp(stoi(coeff), stoi(xExp), stoi(yExp));
					eq.push(tmp);
					coeff = "";
					xExp = "";
					yExp = "";
				}
				else if (equa[i] == '-') {
					if (yExp == "") {
						yExp = "0";
					}
					Poly tmp(stoi(coeff), stoi(xExp), stoi(yExp));
					eq.push(tmp);
					coeff = "-";
					xExp = "";
					yExp = "";
				}
				else if (equa[i] == '(') {
					eq.push(op);
				}
				else if (equa[i] == ')') {
					eq.push(cl);
				}
				else if (equa[i] == '\'') {
					eq.push(de);
				}
				else if (equa[i] == '/') { // Dividing by y
					yNeg = true;
				}
				else { // Didn't get anywhere
					if (isdigit(equa[i])) {
						coeff += equa[i];
					}
					else if (equa[i] == 'x') {
						i++;
						while (isdigit(equa[i])) {
							xExp += equa[i];
							i++;
						}
						if (xExp == "") {
							xExp = "1";
						}
						i--; // Once it reaches a non exponent x number
					}
					else if (equa[i] == 'y') {
						i++;
						while (isdigit(equa[i])) {
							yExp += equa[i];
							i++;
						}
						if (yExp == "") {
							yExp = "1";
						}
						if (yNeg) {
							yExp = "-" + yExp;
							yNeg = false;
						}
						i--; // Once it reaches a non exponent x number
					}
				}
			}
			string resultString = ""; // The final output
			bool close = false; // It is stil going back
			while (eq.size() > 0) {
				Poly tmper = eq.top();
				if (tmper.coeff == -1 && tmper.x == -1 && tmper.y == -1) { // It is derivative
					cout << "Dang it we have to do the derivative" << endl;
				}
				else if (tmper.coeff == 0 && tmper.x == -1 && tmper.y == -1) { // Closed Parnethatses
					close = true;
					cout << "That is closed my fiend" << endl;
				}
				else if (tmper.coeff == 0 && tmper.x == 0 && tmper.y == 0) { // Open Parnethatses
					cout << "That is open my friend" << endl;
				}
				else {
					if (tmper.x != 0) {
						if (tmper.y < 0) { // Division
							Poly tmp = rule3(tmper);
							resultString = form(tmp) + resultString;
						}
						else if (tmper.y > 0) {// Multiplication
							Poly tmp = rule1(tmper);
							resultString = form(tmp) + resultString;
						}
						else {
							Poly tmp = rule4(tmper);
							resultString = form(tmp) + resultString;
						}
					}
				}
				eq.pop();
				string s = to_string(tmper.coeff) + " " + to_string(tmper.x) + " " + to_string(tmper.y) + "\n";
			}
			if (resultString[0] == '+') {
				resultString[0] = ' ';
			}
			cout << "Final " << resultString << endl;
		}
		else if (selection == 11 || selection == 12) { // Derivative
			cout << "So this one has a couple of rules to it. I'll give you some examples.\n";
			cout << "Entering Logrithems: sin(x), cos(x), tan(x)\n";
			cout << "Other Avaliable: exp(x)\n";
			cout << "Some Examples Input\Output: \n"; // ADD EXAMPLES HERE
			cout << "\t - 1/x+x*x-3 (+,-,*,/)\n";
			cout << "\t\t - f(x)  = ((1) / (x) + ((x * x) - 3))\n";
			cout << "\t\t - f'(x) = (((-1 * 1)) / ((x * x)) + (x + x))\n";
			cout << "\t - sin(x)*cos(x) (Trig Functions)\n";
			cout << "\t\t - f(x)  = (sin(x) * cos(x))\n";
			cout << "\t\t - f'(x) = ((cos(x) * cos(x)) + (sin(x) * (-1 * sin(x))))\n";
			cout << "\t - log(x) (Logrithms)\n";
			cout << "\t\t - f(x) = log(x)\n";
			cout << "\t\t - f'(x) = (1)/(x)\n";
			cout << "\t - exp(3*cos(x)) (e^ function)\n";
			cout << "\t\t - f(x)  = e^((3 * cos(x)))\n";
			cout << "\t\t - f'(x) = ((3 * (-1 * sin(x))) * e^((3 * cos(x))))\n";
			cout << "\t - 3*x^(3)+4*x+6 (^ must follow by (). Small Coding Fix)\n";
			cout << "\t\t - f(x)  = ((3 * x^3) + ((4 * x) + 6))\n";
			cout << "\t\t - f'(x) = ((3 * (3 * x^2)) + 4)\n";
			cout << "Enter the polynomial: ";
			if (selection == 11) {
				string input;
				cin >> input;
				Parser parser(input);
				parser.tokenize();
				Atom* f = parser.parse();
				cout << "f(x)  = ";
				f->print();
				cout << endl;
				cout << "f'(x) = ";
				f->derive()->print();
				cout << endl;
			}
			else if (selection == 12) {
				string input;
				cin >> input;
				Parser parser(input);
				parser.tokenize();
				Atom* f = parser.parse();
				int time = 0;
				cout << "How many derivatives do you want? ";
				cin >> time;
				bool zeroed = false;
				cout << "f(x)  = "; // Original Equation
				f->print();
				cout << endl;
				for (int i = 0; i < time; i++) { // Goinging to the nth derivative
					if (zeroed) {
						cout << "It will be zero from here on out so there is no point in me printing it over and over again\n";
						break;
					}
					cout << "f";
					for (int o = 0; o <= i; o++) {
						cout << "'"; // The number derivative
					}
					cout << "(x) = ";
					f = f->derive();
					f->print();
					cout << "\n";
					zeroed = f == f->derive();
				}
			}
		}
		else if (selection == 13) {
			cout << "Here are some errors that have been detected in each section. Please select a selection you would like\n";
			cout << "1. Adding Polynomials\n";
			cout << "2. Subtracting Polynomials\n";
			cout << "3. Multiplying Polynomials\n";
			cout << "4. Dividing Polynomails\n";
			cout << "5. Simple Derivative\n";
			cout << "6. Multiple Simple Derivatives\n";
			cout << "7. Expanded Derivative\n";
			cout << "8. Multiple Expanded Derivatives\n";
			cout << "9. ALL\n";
			int helper;
			cin >> helper;
			if (helper > 0 && helper < 5) {
				cout << "There is nothing detectively wrong with the program\n";
			}
			else if (helper == 5) {
				cout << "There is a problem when putting a complex fuction. For example anything besides variables and numbers\n";
				cout << "It doesn't simplify past a certain point.\n";
			}
			else if (helper == 6) {
				cout << "Same as 5\n";
			}
			else if (helper == 7 || helper == 8) {
				cout << "There is a problem with the simplification. It doesn't simpify.\n";
				cout << "It can't do the normal function of division";
			}
			else if (helper == 9) {
				cout << "Addition, Subtraction, Multiplication, and Division\n\tNothing Wrong";
				cout << "Simple Derivative\n\tCan only do Variables, Numbers (No Trig, Log or Exp)\n";
				cout << "Expanded Derivatives\n\tCan't do Complex equations (Division), but can do Tri, Log, and Exp\n";
			}
			else {
				cout << "Yeah I don't have an answer for that one.\n";
			}
		}
		else {
			cout << "That sucks that isn't a value. Better luck Next time.\n PROGRAM TERMINATED\n";
			break;
		}
	}
	system("PAUSE");
	return 0;
}

