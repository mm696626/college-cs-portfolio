
/*
  Name:        Matt McCullough
  Date:        9/12/2018
  Title:       Operators.java
  Description: Adds, subtracts, multiplies, performs integer division
               and modulo division on 2 numbers the user enters
  Input:       2 integers
  Output:      The result of adding, subtracting, multiplying,
               dividing, and modularing the 2 numbers
*/

import java.util.Scanner;

class Operators 
{
    public static void main ( String[] args )
    {
        float first
        double second
        double result;
        Scanner keyboard = new Scanner( System.in );
        
        System.out.println( "Enter first number (an integer, please)" );
        first = keyboard.nextInt();
        System.out.println( "Enter second number (another integer, please)" );
        second = keyboard.nextInt();
        result = first + second;
        System.out.println( "The value of " + first + " + " + second
                           + " is " + result );
    
        result = first - second;
        System.out.println( "The value of " + first + " - " + second
                           + " is " + result );
      
        result = first * second;
        System.out.println( "The value of " + first + " * " + second
                           + " is " + result );
     
        result = first / second;
        System.out.println( "The value of " + first + " / " + second
                           + " is " + result );
     
        result = first % second;
        System.out.println( "The value of " + first + " mod " + second
                           + " is " + result );
    }  //end main
}  //end Operators class