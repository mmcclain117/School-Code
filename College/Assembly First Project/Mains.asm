
;.386
;.model flat,stdcall
;.stack 4096
ExitProcess PROTO, dwExitCode:DWORD

.data
sum DWORD 0
msg     byte    'Hello, World', 10
msg DB 'thisisamessage$'
prompt BYTE "ENTER your name: ", 0
StringToPrint:
.string

.code 
main PROC
mov eax, 5  
add eax, 6
mov sum, eax
mov edx, OFFSET prompt
push " "
;call msg
;call printf
call ReadConsoleInput msg
; print a byte to stdout
;mov eax, 4           ; the system interprets 4 as "write"
;mov ebx, 1           ; standard output (print to terminal)
;mov ecx, variable    ; pointer to the value being passed
;mov edx, 1           ; length of output (in bytes)
;int 0x80             ; call the kernel
; call PrintChar
INVOKE ExitProcess,0
main endp
end main