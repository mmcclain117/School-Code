// HahnProblem8.cpp : Defines the entry point for the console application.
//

//#include "stdafx.h"
#include <iostream>
using namespace std;

void  main()
{

	int Grades[] = { 52, 77, 51, 89, 98, 74, 85, 92, 95, 86 };
	int Average;
	int count;
	int Highest;
	int sum = 0;
	for (int i = 0; i < 10; i++) {
		sum += Grades[i];
	}
	cout << sum << endl;

	_asm
	{
		mov esi, -4
		mov eax, 0
		mov ebx, 0
		mov ecx, 10
		L1:
		add esi, 4
			//		inc esi
			mov ebx, Grades[esi]
			add eax, ebx
			Loop L1

			L2 :
		mov sum, eax
			mov count, 10
			mov edx, 0
			div count
			mov Average, eax

			mov esi, -1
			mov eax, 0
			mov Highest, 0
			L3:
		inc esi
			movsx eax, Grades[esi]
			cmp eax, ebx
			jg L4
			cmp esi, 9
			jg L5
		L4:
		mov ebx, eax
			cmp esi, 9
			jne L3
			L5 :
		mov Highest, ebx
	}

	cout << Average << endl;
	cout << Highest << endl;
	system("pause");
	return 0;
}