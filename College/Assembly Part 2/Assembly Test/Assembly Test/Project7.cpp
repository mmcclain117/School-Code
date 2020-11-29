#include<iostream>
using namespace std;

int main() {
	int start = 53520; // Starting amount of money
	int end = 60000; // Ending amount of money
	int totals = 0;
	int months = 10; // Number of months
	__asm {
		xor eax, eax;
		xor edx, edx;
		mov ecx, months;
		mov eax, start;
		mov ebx, end;
		sub ebx, eax;
		xchg eax, ebx;
		mov ebx, 10;// How many Hairs
		div ebx;
		mov ebx, 6; // Number of Frogs
		div ebx;
		jmp E1;
	E1:
		cmp edx, 0;
		jg E1;
		jmp E3;
	E2:
		add eax, 1;
		xor edx, edx;
		jmp E3;
	E3:
		div ecx;
		cmp edx, 0;
		jg E4;
		jmp End;
	E4:
		add eax, 1;
		xor edx, edx;
		jmp End;
//	E2:
//		div ecx;
//		cmp edx, 0;
	End:
//		mov edx, eax;
//		div ecx; // Split to months
//		div ecx;
//		cmp edx, 0;
//		jg E2;
		mov totals, eax;
	}
	cout << "Number of Frogs per month are: " << totals << " to be done in " << months << endl;


	system("PAUSE");
	return 0;
}