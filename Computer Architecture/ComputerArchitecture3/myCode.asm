;----------------------------------------------------------------------------
; file: myCode.asm
; author:	Matt McCullough
; date:		11/26/2019
; description:  Translate Java code to MASM
;----------------------------------------------------------------------------
	option	casemap:none	;case sensitive names (like java)

	public	init		;make func/proc in this module available outside of this module
	public	calc		; "

	extern	xsp:sdword	;make outside var available inside
	extern	i0:sdword	; "
	extern	i1:sdword	; "
	extern	i2:sdword	; "
	extern	i3:sdword	; "
	extern	i4:sdword	; "
	extern	i5:sdword	; "
	extern	s0:sdword	; "
	extern	a0:sdword	; "
;----------------------------------------------------------------------------
	.data			;data segment
	;none needed (using/sharing C data directly)
;----------------------------------------------------------------------------
	.code			;code segment

init	proc
		mov xsp,100000 
		mov i0, 0
		mov i1, 1
		mov i2, 2
		mov i3, 3
		mov i4, 4
		mov i5, 0
		mov s0, 92
		mov a0, 0a0h

		ret
init	endp
;----------------------------------------------------------------------------
calc	proc
		mov eax,i2              ;move i2 to eax
		mov i1,eax				;set i1 to i2
		mov eax,i3				; move i3 to eax
		add i1,eax				;add i3 to i1
		mov eax,i4				; move i4 to eax
		sub i1,eax				;subtract i4 from i1

		mov eax,i2				;move i2 to eax
		mov i3,eax				;move i2 to i3
		mov eax,i1				; move i1 to ebx
		sub eax,54321			; subtract 54321 from eax
		mov edx,0				;set dividend
		mov ecx,eax				;set divisor
		idiv ecx				;div eax by ecx

		sub xsp,16				;subtract 16 from xsp

		mov i0,2147				;set i0 to 2147
		sub i0, 03648h			;subtract 0x3648 from i0

		mov edx,s0				;move s0 to edx
		imul edx,-1				;multiply s0 by -1
		mov i3,edx				;move edx to i3 (s0 *-1)

		mov eax,i1				;move i1 to eax
		mul a0					;multiply eax by a0
		mov i1,eax				;move answer to i1

		mov eax,ebx				;move ebx to eax
		mov ebx,0				;move 0 to ebx


		mov ebx,i2				;put i2 in ebx
		add ebx,56				;add 56 to i2
		mov edx,0				;set dividend
		mov ecx,i3				;set divisor
		idiv ecx				;div eax by ecx
		mov i2,eax				;move answer to i2 (0)


		

		mov ecx,i3				;set divisor
		idiv ecx				;div eax by ecx

		mov edx,0	            ;move 0 to edx
		mov ecx,i3				;set divisor
		idiv ecx				;div eax by ecx



		mov eax,i1				;move i1 to eax
			
		mov i5,eax				;move eax to i5 (as the answer of the division is i1)
		add eax,1				;add 1 to i1 (as its done after setting i5)
		mov i1,eax				;move new value to i1


		mov eax,i4				;move i4 to eax
		mov ebx,8				;move multiplication number to ebx
		mul ebx					;multiply eax by 8
		mov i4,eax				;put answer in i4
		ret						;return calculations
calc	endp
		end						;Bill Gates said so