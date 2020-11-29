#include<iostream>

using namespace std;


int main() {
	int member[] = { 5,8,6,3,4,1,0,9,2,7 };
	int aSize = sizeof(member) / 4;
	int sorted[10];
	int lp; // Highest Point
	long lv; // Low Value
	int *p = sorted;
	int checkp;
	cout <<"SIZE: " << aSize << endl;
	_asm {
		mov eax, member;
		/*
		xor eax , eax; // Temperary Counter
		xor ebx, ebx; // 1st Array Counter
		xor esi, esi; // Address Counter
		movzx ecx, aSize; // 2nd Array Counter
		
		mov lv, -2;
//		mov esp, OFFSET sorted;
		push eax;
		mov ebx, eax;
	L1:
		mov eax, member[esi];
		push eax;
//		mov sorted[esp], eax;
//		mov sorted[4 * (ecx- 1)], member[esi];
		add esi, 4;
//		add edi, 4;
		LOOP L1;
		jmp L2;
	L2:
		movzx ecx, aSize; // Reset 2nd Counter
		mov esi, p;
//		mov esi, sorted[0];
		lea $sorted, [esp + 0];
//		xor esi, esi;
//		mov esi, OFFSET sorted;
		jmp L3;
	L3:
		pop eax;
		mov eax, sorted[esi];
		add esi, 4;
		LOOP L3;


	// Assign Low Value and Point
	// LOOP THROUGH ARRAY
		// CHECK NUMBERS LOW VALUE TO CURRENT
	// Assign the value
	// Reset the value in array
	// CHECK FOR END OF ARRAY
	// Reset For the LOOP




		/*
	COMPARE:
		mov eax, member[esi]; // Current point
		cmp lv, eax; 
		jg ASS; // Assign
		jmp INCRE;

	VALCH: // Value Check
		cmp ecx, 1;
		jle ENDS;
		
		sub ecx, 1;

	ASS:
		mov lv, eax; // Assign High point
		mov lp, esi; // Assign Lowest Point
		jmp INCRE;

	RESET:
		xor esi, esi;
		inc ebx;
		jmp COMPARE;

	ENDS: // Reseting Value
		xor eax, eax;
		xor ecx, ecx;
		xor esi, esi; 
	INCRE: // Increses Both Counter
		add esi, 4;
//		add eax, 1;
		jmp COMPARE;

/*
	COMPARE:
		mov eax, member[esi]; // Current point
		cmp ebx, ecx; 
		jge CHECK; // At the end
		cmp eax, member[esi + 4]; // 1st Number is smaller
		jl SWAP;
		jmp INCRE; */

/*	SWAP:
		mov edx, member[esi + 4];
		mov member[esi], edx;
		mov member[esi+4], eax;
		jmp INCRE; */
		/*
	CHECK:
		xor eax, eax; // Reset TMP VARIABLE


		xor eax, eax;
		mov checkp, 0;
		mov eax, member[(ecx - 1) * 1];
		mov tmp, eax;
		mov eax, 0;
		cmp ecx, 0;
		jl END; // Sorted
		mov eax, member[ecx -1];
		cmp eax, member[(ecx-1) *4];
		jge RESET;
		loop CHECK;
		jmp END;
		*/

	END: 
		xor eax, eax;
	}
	for (int i = 0; i < aSize; i++) {
		cout << member[i] << " ";
	}
	cout << endl;
	for (int i = 0; i < aSize; i++) {
		cout << sorted[i] << " ";
	}
	cout << endl;

	system("PAUSE");
	return 0;
}