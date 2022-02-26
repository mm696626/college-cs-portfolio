import java.util.Scanner;
import java.util.Random;
public class GuessingGame
{
   public static void main(String[] args)
   {
      Random rng = new Random();
      Scanner reader = new Scanner(System.in);
      int numberToGuess = rng.nextInt(5)+1;
      int guess=0;
      int tries=0;
      do
      {
         System.out.println("Guess a number from 1 to 5");
         guess = reader.nextInt();
         if(guess<numberToGuess)
         {
            tries++;
            System.out.println("Too Low!");
         }
         else if(guess>numberToGuess)
         {
            tries++;
            System.out.println("Too High!");
            
         }
         else
         {
            tries++;
            System.out.println("Right!");
         
         }
      
      
      
      }while(guess!=numberToGuess);
   
        System.out.println("You got it in " + tries + " tries");
   }



}