import java.util.Scanner;
import java.util.Random;
public class CoinFlip
{
   public static void main(String args[])
   {
      Scanner keyboard = new Scanner(System.in);
      Random randGen = new Random();
      System.out.println("Enter 0 for heads or 1 for tails");
      int guess = keyboard.nextInt();
      int coin = randGen.nextInt(2);
      if(coin==0 && guess==0)
         System.out.println("Yes it's heads!");
      else if(coin==0 && guess==1)
         System.out.println("Sorry it's heads");
      else if(coin==1 && guess==1)
         System.out.println("Yes it's heads!");
      else
         System.out.println("Sorry it's tails");
   
   
   }



}