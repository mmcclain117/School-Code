#include <iostream>

using namespace std;

int main() {
	long Sum;
	long Total;
	_asm
	{
		mov Sum, 0;
		mov ecx, 100;
		mov eax, 1;
		mov Total, 1;
	L1:
		add Sum, ecx;
		loop L1;
	mov ecx, 10;	
	L2:
		mul ecx;
		cmp ecx, 1;
		loop L2
		mov Total, eax;
	}
	cout << "Sum of 1-10 is " << Sum << endl;
	cout << "Total for 10! is " << Total << endl;
	system("PAUSE");
	return 0;
}
