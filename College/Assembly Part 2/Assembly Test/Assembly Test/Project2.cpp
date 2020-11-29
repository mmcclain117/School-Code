#include <iostream>
using namespace std;

int main() {
	unsigned char c1;
	unsigned char c2;
	unsigned char c3;
	unsigned char c4;
	unsigned long i1(0xaabbccee);
	_asm {
		mov eax, i1;
		mov c3, ah;
		mov c4, al;
		shr eax, 16;
		mov c1, ah;
		mov c2, al;
	}
	cout.flags(ios::hex);

	cout << "results are " << (unsigned int)c1 << ", " << (unsigned int)c2 << ", " << (unsigned int)c3 << ", " << (unsigned int)c4 << endl;
	system("PAUSE");
	return 0;
}