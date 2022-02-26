/*
    Name:
    Date:
    Title:       Twenty.java
    Description: A program that does not work correctly.
                 I had wanted it to have me enter my age, and tell me how
                 old I would be in 20 years.  But, it has 2 (or more) errors.
                 What are they?
    Input:       an age (integer)
    Output:      my age in 20 years (another integer
*/
import java.util.Scanner;
class Twenty
{
   public static void main (String[] args)
   {
        Scanner keyboard = new Scanner( System.in );
        int  age, old+age; //variable name not working as its trying to make a variable called old+age and + isnt allowed in variable names
     
        System.out.println( "How old are you?" );
        age = keyboard.nextInt();
     
        old+age = age + 20;
      
        System.out.println( "In 20 years you will be " + old+age + " years old." ); //println error with + as the vairable isnt intialized (error above)
    } // end main
} // end class




}