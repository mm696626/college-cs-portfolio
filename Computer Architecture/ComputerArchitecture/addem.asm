;----------------------------------------------------------------------------
; file:		addem.asm
; author:	Matt McCullough
; date:		11/5/2019
; description:  Adds numbers
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
		ret					  ;return to caller
tst		endp
		end					  ;required by Mr. Gates!
;----------------------------------------------------------------------------

