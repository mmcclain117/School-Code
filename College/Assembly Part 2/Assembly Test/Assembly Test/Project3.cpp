#include <iostream>

using namespace std;
// AX (accumulator) is preferred for arithmetic, logic, and data transfer operations
// BX (base register) serves as an address register
// CX (count register) frequently serves as a loop counter
// DX (data register) is used in multiplication and division

int main()
{
	long Var1 = 6;
	long Var2 = 10;
	long Var3 = 15;
	long Var4 = 21;
	long Var5 = 22;
	long Sum;
	long Result;
	long Remainder;

	const unsigned short c1 = 6;
	const unsigned short c2 = 10;
	const unsigned short c3 = 21;
	const unsigned short c4 = 15;
	const unsigned short c5 = 22;
	unsigned short temp = 0;

	_asm
	{
		add eax, Var2;
		add eax, Var1;
		add eax, Var2;
		add eax, Var3;
		add eax, Var4;
		add eax, Var5;
		mov Sum, eax;
		// Doing the Equation (c1+c2)*(c3-c4)/(c5+c1)
		// Turns into a1 * a2 / a3
		mov eax, 0;
		mov edx, 0;
		mov ax, c1;
		add ax, c2; // a1 (16)
		mov bx, c3;
		sub bx, c4; // a2 (6)
		mul bx; // a1 (96)
		mov bx, c5;
		add bx, c1; // a3 (28)
		mov cx, bx;
		mov bx, ax; // Total
		div cx;
		mov Result, eax;
		movzx eax, ah;
		mov Remainder, edx;
	}
	cout << "Sum is        " << Sum << endl;
	cout << "Result is     " << Result << endl;
	cout << "Remainder is  " << Remainder << endl;
	system("PAUSE");
	return 0;
}
