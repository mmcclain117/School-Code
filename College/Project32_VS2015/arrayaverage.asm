
INCLUDE Irvine32.inc

.data

	numbers DWORD 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20

.code
main PROC
	mov esi, OFFSET numbers;
	mov ecx, LENGTHOF numbers;
	xor edx, edx;
	mov ebx, ecx;
	call Average;

	exit;
main ENDP

Average PROC
	mov eax, 0;
L1:
	add eax, [esi];
	add esi, 4;
	loop L1;
	div ebx;
	ret;
Average ENDP

END main