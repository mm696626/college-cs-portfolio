//main.cpp : This file contains the 'main' function.
// Program execution begins and ends here in main.
#include <stdio.h>

extern "C" {
	int tst(void);        //an external assembler function
	//int divZero(void);    //an external assembler function
};

int main(int argc, char* argv[]) {
	int result = tst();
	printf("average is %d \n", result);

	//divZero();

	return 0;
}