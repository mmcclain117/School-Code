#include <iostream>
#include "UBArray.h"
using namespace std;

template<typename DATA, typename INDEX>
void Display(const UBArray<DATA, INDEX> & A, INDEX c) {
	cout << A[c] << endl;
}
template<typename DATA, typename INDEX>
void Display(const UBArray<DATA, INDEX> & A, string c) //Since string is not a primitive data type, it needs its own overload for the display function
		{
	cout << A[c] << endl;
}

void main() {
	char c;
	UBArray<int, char> A1;

	cout << "UBArray 1 (data type: int, index type: char)" << endl;
	cout << A1.Size() << endl;
	cout << A1.GetFirst() << endl;
	cout << A1.GetLast() << endl;
	cout << A1.GetNext() << endl;
	cout << A1.GetPrev() << endl;
	A1['c'] = 143;
	A1['a'] = 14;
	A1['b'] = -99;
	A1.At('d') = 144;
	A1.At('e') = 147;
	A1.At('f') = -999;
	for (c = 'a'; c <= 'f'; c++)
		cout << A1[c] << endl;
	cout << A1.Size() << endl;
	cout << A1.GetNext() << endl;
	cout << A1.GetNext() << endl;
	cout << A1.GetPrev() << endl;
	cout << A1.GetPrev() << endl;
	cout << A1.GetLast() << endl;
	cout << A1.GetNext() << endl;
	cout << A1.GetPrev() << endl;
	Display(A1, 'g');
	Display(A1, 'f');
	Display(A1, 'b');
	Display(A1, 'a');
	Display(A1, 'd');
	A1.Remove('a');
	cout << A1.Size() << endl;
	Display(A1, 'a');
	A1.Remove('f');
	cout << A1.Size() << endl;
	Display(A1, 'f');
	A1.Remove('d');
	cout << A1.Size() << endl;
	Display(A1, 'd');

	cout << endl;

	UBArray<char, string> A2; //One interesting thing about my error codes is that they do not print out correctly if the UBArray data type is not a numerical type.
	//Fortunately the program continues to run normally without any screwups.

	cout << "UBArray 2 (data type: char, index type: string)" << endl;
	cout << A2.Size() << endl;
	cout << A2.GetFirst() << endl;
	cout << A2.GetLast() << endl;
	cout << A2.GetNext() << endl;
	cout << A2.GetPrev() << endl;
	A2["c"] = 'a';
	A2["a"] = 'c';
	A2["b"] = 'f';
	A2.At("d") = 'i';
	A2.At("e") = 'z';
	A2.At("f") = 'x';
	cout << A2.Size() << endl;
	cout << A2["a"] << endl;
	Display(A2, "f");
	cout << A2.GetFirst() << endl;
	cout << A2.GetLast() << endl;
	cout << A2.GetNext() << endl;
	cout << A2.GetPrev() << endl;
}
