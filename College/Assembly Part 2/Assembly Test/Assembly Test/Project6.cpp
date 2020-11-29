#include <iostream>

using namespace std;
/* Instructions 
	MemberLvl	1,3,3,4,2,4,0,1,4,2,1,4,2,2,3
	1,2,3,4 with 4 being the highest level
	OfficerLst	0,13,0,0,2,12,0,1,0,3,2,1,11,0,1
	Secretary is denoted by 1; treasurer is denoted by 2; president denoted by 3
	The members currently holding office are denoted by adding 10 to the officer number
	MemberLvl 4 & Officer List && Not greater than 4 (They currently Hold office)
*/

int main() {
	int a; // Final Place
	int member[] = { 1,3,3,4,2,4,0,1,4,2,1,4,2,2,3 }; // Member Level
	int officer[] = { 0, 13, 0, 0, 2, 12, 0, 1, 0, 3, 2, 1, 11, 0, 1 }; // Officer List
	__asm
	{
		xor eax, eax;
		mov ecx, 15; // Array Size
		xor ebx, ebx; // Array Counter
		xor esi, esi; // Address Counter
		jmp COMPARE;
	INCRE: // Increses Both Counter
		add esi, 4;
		add ebx, 1;
		jmp COMPARE;
	COMPARE:
		mov eax, member[esi];
		cmp eax, 4; // Highest Rank
		je OFFICE;
		cmp ebx, 15; // End of Array
		jl INCRE;
		jmp END;
	OFFICE:
		cmp officer[esi], 0; // Office = 0;
		je INCRE;
		cmp officer[esi], 4; // Currently In office
		jge INCRE;
		jmp END; // Fit Requirement
	END:
		mov a, ebx; // Assign to index of qualified
	}
	cout << "results are " << a << endl;
	cout << "Who is the " << (officer[a] == 1 ? "Secretary" : officer[a] == 2 ? "Treasury" : "President") << endl;
	system("PAUSE");
	return 0;
}

