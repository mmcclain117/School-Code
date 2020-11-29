#include <iostream>
using namespace std;

int main() {
	const unsigned char c1(0x11);
	const unsigned char c2(0x22);
	const unsigned char c3(0x33);
	const unsigned char c4(0x44);
	unsigned long i1(0);
	_asm {
		mov eax, 0;
		mov ah, c1;
		mov al, c2;
		shl eax, 16;
		mov ah, c3;
		mov al, c4;
		mov i1, eax;
	}
	cout << "result is " << hex << i1 << endl;
	cout << "Expected output 11223344" << endl;
	system("PAUSE");
	return 0;
}
