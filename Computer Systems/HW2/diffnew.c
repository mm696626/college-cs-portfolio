// HW2 by Matt McCullough

#include <stdio.h>
#include <string.h>

int main(int argc, char** argv)
{
	
	int ch, ch2;
	FILE *file1;
	FILE *file2;
	
	if(argc !=4) //if not 4 arguments, being program name the 2 files and the mode (c and w are valid) end program
	{
	   printf("wrong number of arguments");
	   return -1;
	}

	file1 = fopen(argv[1],"r");
	file2 = fopen(argv[2], "r");
	if(file1 == NULL || file2 == NULL){ //if either file does not exist end program

		printf("no file exists");
		return -1;
	}
	if(strcmp(argv[3], "c") == 0) //if c for last argument compare characters
	{
	  int diff = 0;
	while(ch != EOF || ch2 != EOF) //while one is not at end keep going
	{
	  if(ch == EOF || ch2 == EOF) //if one is at end of file, assume rest of chars are different and add the remaining characters
	  	diff++;
	  	
	  if(ch != EOF) 
	  	ch = getc(file1);
	  if(ch2 != EOF)
	  	ch2 = getc(file2);
	  
	  if(ch != ch2 && (ch != EOF && ch2 != EOF)) //if different add 1
	       diff++;
	  
	}
	printf("%d different characters", diff);
	printf("\n");
	
	}
	else if(strcmp(argv[3], "w") == 0) //if 2 for last argument compare characters
	{
	   int wordsdiff = 0;
	   char word1[256];
	   char word2[256];
	   while(fscanf(file1, "%s", word1) != EOF && fscanf(file2, "%s", word2) != EOF) //while both aren't at end of file, get words from files and compare
	   {
	   	
		 if(strcmp(word1, word2) != 0) //if different add 1
		       {
		    	  wordsdiff++;
		       }	
	   }
	   while(fscanf(file1, "%s", word1) != EOF || fscanf(file2, "%s", word2) != EOF) //if one is at end of file, assume rest of words are different and add the remaining words
	   	{
		    wordsdiff++;
		}
	   
	   printf("%d different words", wordsdiff);
	   printf("\n");
	}
	else //if c or w isn't entered
	{
	   printf("Invalid mode, enter c or w as the final parameter");
	   printf("\n");
	   return -1;
	}
	

}	
