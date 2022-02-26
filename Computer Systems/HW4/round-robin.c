//HW4 by Matt McCullough
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
int times[5]; //burst times
int quantum = 0;
char process[] = {'1', '2', '3', '4', '5'};
int turn = 0; //what threads turn it is

void findNextThread(int tid)     //choose the next thread to run
{
    int i;
    for(i = (tid + 1) % 5; times[i] == 0; i = (i + 1) % 5) //loop around all 5 threads and if back where we started (which is tid of the thread that just executed, then all threads times are 0)
        if(i == tid)    //if every thread has finished then return to exit threads and in main join threads
            return; //get out of method
    turn = i; //change what threads turn it is
}

void *run(void *tid)    
{
    int i = (int)tid;
    while(times[i] != 0)
    {
        while(turn != i)
        {    
	    //do nothing since thread is waiting till it is its turn
	}
	
        if(times[i] > quantum)
        {
            printf("P%c %d\n", process[i], quantum);
            sleep(1);   //sleep is to simulate running time (it's 1 second because we're not waiting the actual quantum time)
            times[i] -= quantum;
        }
        else if(times[i] > 0 && times[i] <= quantum)      //thread will finish as it's burst time will be 0
        {
            printf("P%c %d ==> Exiting \n", process[i], times[i]);
            sleep(1);
            times[i] = 0;
        }
        findNextThread(i);   
    }
    pthread_exit(0); //exit thread
}

int main(int argc, char **argv)
{
    pthread_t threads[5];
 
    if(argc != 7)
    {
	printf("wrong num of params\n");
	return -1;
    }
    
    if(atoi(argv[1])>0) //make sure quantum is positive (time to subtract shouldn't be 0 or negative)
    	quantum = atoi(argv[1]); //save quantum from param
    else
    {
       printf("Please enter a positive nonzero number for the quantum\n");
       return -1;
    }
    
    for(int i=0; i<5; i++)
    {
	//check if burst times are negative
	if(atoi(argv[i+2])<0)
	{
	     printf("burst times should not be negative\n");
	     return -1;
	}
	else
	{
	     times[i] = atoi(argv[i+2]);   //input the burst time of each thread
	}
    }
	
         
    for(int i = 0; i<5; i++)
    {
         pthread_create(&threads[i], NULL, run, (void *)i);    //Create threads to invoke the run method
    }
    
    //do after running to let threads finish
    for(int i=0; i<5; i++)
    {
         pthread_join(threads[i], 0);    //Join threads
    }
         
    return 0;
}

