import java.util.Scanner;
public class Gambling
{
   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
      int purse = 20;
      int bet=0;
      int numberbet=0;
      Dice dice1 = new Dice();
      Dice dice2 = new Dice();
      while(purse>0)
      {
         bet = 0;
         numberbet=0;
         while(bet>purse || bet<=0)
         {
            System.out.print("Enter the amount you want to bet: ");
            bet = reader.nextInt();
            if(bet>purse || bet<=0)
               System.out.println("Invalid bet");
         }
         System.out.println();
         while(numberbet<2 || numberbet>12)
         {
            System.out.print("Enter the number to bet on: ");
            numberbet = reader.nextInt();
            if(numberbet<2 || numberbet>12)
               System.out.println("Invalid number");
         
         }
         dice1.roll();
         dice2.roll();
         System.out.print("The dice are " + dice1.getDiceValue() + " and " + dice2.getDiceValue());
         if(dice1.getDiceValue()+dice2.getDiceValue() == numberbet)
         {
            purse += bet;
            System.out.print(" You Won! You have " + purse + " dollars");
         }
         else
         {
            purse-=bet;
            System.out.print(" You Lost! You have " + purse + " dollars");
         }
         System.out.println();
      }
         System.out.println("Go Home");
   }


}