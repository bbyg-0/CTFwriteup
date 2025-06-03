;parameter 1:0x4
;parameter 2:0x2d
asm2:
	<+0>:	push   ebp	;push pointer ebp ke stack
	<+1>:	mov    ebp,esp	;peep nilai ke esp
	<+3>:	sub    esp,0x10 ;menurunkan pointer stack sebesar 16 byte / mengalokasikan 16 byte
				; untuk 4 variabel lokal 

	<+6>:	mov    eax,DWORD PTR [ebp+0xc]	;eax = parameter2 = 0x2d
	<+9>:	mov    DWORD PTR [ebp-0x4],eax	;locvar1 = 0x2d

	<+12>:	mov    eax,DWORD PTR [ebp+0x8]	;eax = parameter1 = 0x4
	<+15>:	mov    DWORD PTR [ebp-0x8],eax	;locvar2 = 0x4

	<+18>:	jmp    0x50c <asm2+31>
	<+20>:	add    DWORD PTR [ebp-0x4],0x1	;locvar1 += 1 => 0x2e; 
	<+24>:	add    DWORD PTR [ebp-0x8],0xd1	;locvar2 += 209 => 0xd5; 

	<+31>:	cmp    DWORD PTR [ebp-0x8],0x5fa1 ;cmp locvar2(0x4), 24481
						;0x4 : 0x5fa1
	<+38>:	jle    0x501 <asm2+20>		;jle = jump if less or equal
	<+40>:	mov    eax,DWORD PTR [ebp-0x4]	;eax = locvar1 = 0x2d
	<+43>:	leave  
	<+44>:	ret    

