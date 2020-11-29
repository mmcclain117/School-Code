#include <iostream>

using namespace std;

extern "C" long Average(long s, long a[]) {
	long sum = 0;
	_asm {
		xor edx, edx;
		mov ebx, s; // Array Counter
		mov esi, [a];
		mov ecx, ebx;
//		mov esi, DWORD PTR[a + 4]
		xor eax, eax;
		mov ecx, ebx; // Array Size
//		xor ebx, ebx; // Array Counter
//		xor esi, esi; // Address Counter
		jmp N1;
	N1:
		add eax, [esi];
		add esi, 4;
		Loop N1;
//		mov sum, eax;
//		mov edx, eax;
		mov sum, eax;
		mov ecx, ebx;
//		xor edx, edx;
		div ecx;
		mov sum, eax;
	}
	return sum;
};

int main() {
	long Array1[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	long Array2[11] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
	long Array3[12] = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24 };
	long sum2 = 0;
	for (int i = 0; i < 10; i++) {
		sum2 += Array1[i];
	}
	cout << sum2 << endl;
	cout << "Average of Array1 is " << Average(10, Array1) << endl;
	cout << "Average of Array2 is " << Average(11, Array2) << endl;
	cout << "Average of Array3 is " << Average(12, Array3) << endl;
	system("PAUSE");
	return 0;
}
