/*
    Name:  Matt McCullough
    Date:  9/5/18
    Title: Time.java
    Description:
           Calculates the time it takes to travel a certain distance,
           given a fixed speed.
           Input:  the distance and the speed
           Output: the time it takes to travel the given distance. Note that
           the formula used is the one from Newtonian physics:
               Time = Distance / Speed

*/

import java.util.Scanner;

class Time 
{

    public static void main ( String[] args )
 	{
       
	    //gather inputs
        Scanner  keyboard = new Scanner( System.in );
        float    distance, speed, time;

        System.out.println( "Please enter distance (in miles)" );
        distance = keyboard.nextFloat();
        System.out.println( "Please enter speed (in MPH)" );
        speed = keyboard.nextFloat();

        //perform calculation
        time = distance / speed;

        //report results
        System.out.println( "The time taken to travel " + distance +
            " miles going at " + speed + " MPH is " + time + " hours " );

    } //end main

} //end Time class