#include <stdio.h>
//HW6 by Matt McCullough
int main(void){

	int x;
	for(int i=0; i<4; i++)
	{
		printf("Enter an integer: ");
	    	scanf("%d", &x);
		int squared = squareIt(x);
		int cubed = cubeIt(x);
		printf("%d + %d is: %d\n", squared, cubed, (squared+cubed));
	}
	return 0;
}
