#include <iostream>

using namespace std;

int main() {
	unsigned long i1; // Add 3
	unsigned long i2; // Multiply by 3
	unsigned long i3; // Counter
	unsigned long i4; // i1 % i3
	long l1 = 1;
	long l2 = 1;
	long l3 = 0;
	long l4 = 0;
	bool go = true;
	while (go) {
		l1 += 3;
		l2 *= 3;
		l3 += 1;
		if (l1 > 100) {
			go = false;
		}
		else if (l3 > 15 && l2 > 999999) {
			go = false;
		}
	}
	l4 = l2 % l1;
	cout << l1 << " " << l2 << " " << l3 << " " << l4 << endl;
	_asm {
		mov ebx, 3; Constant
		mov eax, 1;
		mov edx, 1;
		mov ecx, 0;
		mov i1, eax;
		mov i2, edx;
		mov i3, ecx;
		mov i4, 0;
	L1: inc ecx;
		add i1, ebx;
		mul ebx;
		// Terminate if
		//  i1 > 100 || cx > 15 && i2 > 999999
		cmp i1, 100;
		jle L2;
		jmp D1;
	L2:
		cmp cx, 15;
		jle L1;
		cmp i1, 999999;
		jg D1;
	D1:
		mov i2, eax;
		mov i3, ecx;
		div i1;
		mov i4, edx;
	}
	cout << "results are " << (unsigned long)i1 << ", "
		<< (unsigned long)i2 << ", "
		<< (unsigned long)i3 << ", "
		<< (unsigned long)i4 << endl;
	system("PAUSE");
	return 0;
}
