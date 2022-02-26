import java.util.*;
public class lotteryNumbers
{
   public static void main(String[] args)
   {
      Random rng = new Random();
      Scanner reader = new Scanner(System.in);
      int[] lotteryNumbers = new int[5];
      for(int i=0; i<lotteryNumbers.length; i++)
      {
         lotteryNumbers[i] = rng.nextInt(10);
      }
      int[] user = new int[5];
      System.out.println("Welcome to play lottery...");
      
      for(int i=0; i<user.length; i++)
      {
         System.out.println("Enter lottery number (from 0 to 9)");
         user[i] = reader.nextInt();
      }
      System.out.println("The lottery number is:");
      for(int i=0; i<lotteryNumbers.length; i++)
      {
         System.out.print(lotteryNumbers[i] + " ");
      }
      System.out.println();
      System.out.println("Your number is:");
      for(int i=0; i<user.length; i++)
      {
         System.out.print(user[i] + " ");
      }
      int count=0;
      for(int i=0; i<lotteryNumbers.length; i++)
      {
         for(int j=0; j<lotteryNumbers.length; j++)
         {
            if(lotteryNumbers[i]==user[j])
            {
               count++;
               user[j]=-1;
            } 
                           
         }
         
      }
      System.out.println();
      System.out.println("There are " + count + " matching digits");
   }


}