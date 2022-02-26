import java.util.Scanner;
public class Change
{
   public static void main(String args[])
   {
      Scanner reader = new Scanner(System.in);
      int change = 0;
      float paid = 0;
      float cost = 0; //I used floats for less precision on decimals, so round off errors probrably wont occur (from what I tested they havent)
      int q = 0;
      int n = 0;
      int d = 0;
      int p = 0;
      int dollars = 0;
      System.out.println("How much will the item cost? (in dollars. like 1.02)"); // user inputs cost of item
      cost = reader.nextFloat();

      
      System.out.println("How much did the customer pay? (in dollars like 1.02, please enter a number equal to or greater than the cost)"); //inputs pay 
      paid = reader.nextFloat();
      
      paid*=100; //prevents round off errors
      cost*=100;
      
      change = (int)(paid - cost);
      int centcounter=0; 
      if(change/100>=1)
      {
         dollars = change/100;
         change -= dollars*100;
      }
      if(change/25>=1)
      {
         q=change/25;
         centcounter+=q*25;
         change -= q*25;
      }
      if(change/10>=1)
      {
         d = change/10;
         centcounter+=d*10;
         change-= d*10;
      }         
      if(change/5>=1)
      {
         n = change/5;
         centcounter+=n*5;
         change-= n*5;
      }  
      if(change>=1)
      {
         p = change;
         centcounter+=p;
         change-= p;
      }  
            
          System.out.println("*------------------------------------------------------------------------*");
          System.out.println("Your change is " + dollars + " dollars and " + centcounter + " cents");
          System.out.println("You get " + dollars + " dollars, " + q + " quarters, " + d + " dimes,  " +  n + " nickels " + " and " + p + " pennies as your change"); 
          System.out.println("*------------------------------------------------------------------------*");
         
   }

}