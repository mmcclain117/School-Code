.data
intarray DWORD 10000h, 20000h
.code
	mov edi, OFFSET intarray
	mov ecx, Lengthof intarray
	mov eax, 0