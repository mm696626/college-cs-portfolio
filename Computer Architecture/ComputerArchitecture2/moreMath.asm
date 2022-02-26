;----------------------------------------------------------------------------
; file:		moreMath.asm
; author:	Matt McCullough
; date:		11/6/2019
; description:  More operations with numbers
;----------------------------------------------------------------------------
		option		casemap:none	;case sensitive (like java)
;----------------------------------------------------------------------------
;symbol definitions
A		=			1o		  ;1 in octal
B		=			12o		  ;12 in octal
;----------------------------------------------------------------------------
		.data				  ;variable definitions
X		dword		0A1h	  ;variable x to A1 in hex
Y		dword		11001001b ;variable y to 11001001 in binary
sum		dword		0		  ;variable sum to save sum
;----------------------------------------------------------------------------
		.code				  ;executable instructions (procedures/functions)
tst		proc				  ;sample function called tst
		add sum,A			  ;add A to sum
		add sum,B			  ;add B to sum
		mov ebx,X			  ;move x to ebx, so addition dosen't fail
		mov ecx,Y			  ;move y to ecx, so addition dosen't fail
		add sum,ebx			  ;Add X's value to sum
		add sum,ecx			  ;add Y's value to sum
		mov	eax, sum		  ;set return value to sum
		mov edx,0			  ;set dividend
		mov ecx,4			  ;set divisor
		div ecx				  ;div eax by 4
		ret					  ;return to caller
tst		endp

divZero proc
		add sum,A			  ;add A to sum
		add sum,B			  ;add B to sum
		mov ebx,X			  ;move x to ebx, so addition dosen't fail
		mov ecx,Y			  ;move y to ecx, so addition dosen't fail
		add sum,ebx			  ;Add X's value to sum
		add sum,ecx			  ;add Y's value to sum
		mov	eax, sum		  ;set return value to sum
		mov edx,0			  ;set dividend
		mov ecx,0			  ;set divisor to 0
		div ecx				  ;divide by 0
		ret
divZero	endp
		end					  ;required by Mr. Gates!
;----------------------------------------------------------------------------

