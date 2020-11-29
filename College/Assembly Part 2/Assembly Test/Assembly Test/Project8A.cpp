std::round(float) :

	push rbp

	mov rbp, rsp

	sub rsp, 16

	movss DWORD PTR[rbp - 4], xmm0

	mov eax, DWORD PTR[rbp - 4]

	mov DWORD PTR[rbp - 8], eax

	movss xmm0, DWORD PTR[rbp - 8]

	call roundf

	leave

	ret

	Average(long, long*) :

	push rbp

	mov rbp, rsp

	sub rsp, 64

	mov QWORD PTR[rbp - 40], rdi

	mov QWORD PTR[rbp - 48], rsi

	mov QWORD PTR[rbp - 8], 0

	mov DWORD PTR[rbp - 12], 0

	.L5:

mov eax, DWORD PTR[rbp - 12]

cdqe

cmp QWORD PTR[rbp - 40], rax

jle.L4

mov eax, DWORD PTR[rbp - 12]

cdqe

lea rdx, [0 + rax * 8]

mov rax, QWORD PTR[rbp - 48]

add rax, rdx

mov rax, QWORD PTR[rax]

add QWORD PTR[rbp - 8], rax

add DWORD PTR[rbp - 12], 1

jmp.L5

.L4:

cvtsi2ss xmm0, QWORD PTR[rbp - 8]

cvtsi2ss xmm1, QWORD PTR[rbp - 40]

divss xmm0, xmm1

movss DWORD PTR[rbp - 16], xmm0

mov eax, DWORD PTR[rbp - 16]

mov DWORD PTR[rbp - 52], eax

movss xmm0, DWORD PTR[rbp - 52]

call std::round(float)

movd eax, xmm0

mov DWORD PTR[rbp - 20], eax

movss xmm0, DWORD PTR[rbp - 20]

cvttss2si rax, xmm0

leave

ret