int main() {
	int a = 0;
	__asm {
		//		mult_by_shifting PROC
		//		; Multiplies EAX by 36 using SHL, LOOP_COUNT times.
		mov ecx, LOOP_COUNT;
	L1:
		push eax;
		mov ebx, eax;
		shl eax, 5;
		shl ebx, 2;
		add eax, ebx;
		pop eax;
		loop L1;
		ret;
		mult_by_shifting ENDP
			mult_by_MUL PROC;
		mov ecx, LOOP_COUNT;
	L1:
		push eax; save original EAX
			mov ebx, 36;
		mul ebx;
		pop eax; restore EAX;
		loop L1;
		ret;
		mult_by_MUL ENDP;
		.data
			LOOP_COUNT = 0FFFFFFFFh;
		.data
			intval DWORD 5
			startTime DWORD ?
			.code
			call GetMseconds; get start time
			mov startTime, eax
			mov eax, intval; multiply now
			call mult_by_shifting
			call GetMseconds; get stop time
			sub eax, startTime
			call WriteDec; display elapsed time	}	return 0;}