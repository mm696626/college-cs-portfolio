//HW3 by Matt McCullough
#include <stdio.h>
#include <unistd.h>
#include <pthread.h>


void *area(void *r)
{
	//area code
    int radius = atoi(r);
    double area = 3.14 * radius * radius;
    printf("Area is: %f\n", area);
    pthread_exit(0); //exit thread
}

void *diameter(void *r)
{
	//area code
    int radius = atoi(r);
    int diameter = 2 * radius;
    printf("Diameter is %d\n", diameter);
    pthread_exit(0); //exit thread
}



void *circumference(void *r)
{
    int radius = atoi(r);
    double circumference = 2 * 3.14 * radius;
    printf("circumference is %f\n", circumference);
    pthread_exit(0); //exit thread
}

int main(int argc, char** argv)
{
  
  
  
  pthread_t thread1;
  pthread_t thread2;
  pthread_t thread3;
  
  
  if(argc != 2) //check for 2 arguments
  {
  	printf("wrong num of params\n");
  	return -1;
  }
  if(atoi(argv[1]) < 0) //check if argument is negative
  {
  	printf("r cannot be negative\n");
  	return -1;
  }
  
  pthread_create(&thread1, NULL, area, argv[1]); //create thread and run area code 
  pthread_join(thread1, NULL); //join thread with main
  
  pthread_create(&thread2, NULL, diameter, argv[1]); //repeat for other 2 threads
  pthread_join(thread2, NULL);
  
  pthread_create(&thread3, NULL, circumference, argv[1]);
  pthread_join(thread3, NULL);
  
  printf("This is everything you need to know\n");

    
  return 0;
}




