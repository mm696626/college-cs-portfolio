//HW3 by Matt McCullough
#include <stdio.h>
#include <unistd.h>
#include <stdbool.h>



/* Function to check if x is power of 2*/
bool isPowerOfTwo(int n)
{
  if (n == 0)
    return 0;
  while (n != 1)
  {
      if (n%2 != 0)
         return 0;
      n = n/2;
  }
  return 1;
}


int main(int argc, char** argv)
{
  
  if(argc != 2) //check for 2 arguments
  {
  	printf("wrong num of params\n");
  	return -1;
  }
 
  int pageSize = atoi(argv[1]); //get page size from command line
  
  if(isPowerOfTwo(pageSize) == 0) //check if it is not a power of 2, then invalid page size
  {
  	printf("Invalid page size\n");
	return -1;
  }
  else
  {
  	int address = 0;
	printf("Enter an decimal address: ");
	scanf("%d", &address);
	
	printf("Page number is: %d\n", (address/pageSize));
	printf("Offset is: %d\n", (address%pageSize));
	
  }
   
  return 0;
}




