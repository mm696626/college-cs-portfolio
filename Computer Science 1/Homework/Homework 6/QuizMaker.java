import java.util.Scanner;
import java.util.Random;
public class QuizMaker
{
   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
      Random rng = new Random();
      int count=0;
      int num1 = 0;
      int num2 = 0;
      System.out.print("Enter your name: ");
      String name = reader.nextLine();
      System.out.println("Welcome " + name + " Please answer the following questions: ");
      num1 = rng.nextInt(10)+1;
      num2 = rng.nextInt(10)+1;
      System.out.print("What is " + num1 + " + " + num2 ": ");
      int ans = reader.nextInt();
      if((num1+num2)==ans)
      {
         System.out.println("Correct!");
         count++;
      } 
      else
      {
         System.out.println("The correct answer was " + ans);
      }
      num1 = rng.nextInt(10)+1;
      num2 = rng.nextInt(10)+1;
      System.out.print("What is " + num1 + " - " + num2 + ": ");
      ans = reader.nextInt();
      if((num1-num2)==ans)
      {
         System.out.println("Correct!");
         count++;
      } 
      else
      {
         System.out.println("The correct answer was " + ans);
      }

      num1 = rng.nextInt(10)+1;
      num2 = rng.nextInt(10)+1;
      System.out.print("What is " + num1 + " * " + num2 + ": ");
      ans = reader.nextInt();
      if((num1*num2)==ans)
      {
         System.out.println("Correct!");
         count++;
      } 
      else
      {
         System.out.println("The correct answer was " + ans);
      }
      num1 = rng.nextInt(10)+1;
      num2 = rng.nextInt(10)+1;
      System.out.print("What is " + num1 + " % " + num2 + ": ");
      ans = reader.nextInt();
      if((num1%num2)==ans)
      {
         System.out.println("Correct!");
         count++;
      } 
      else
      {
         System.out.println("The correct answer was " + ans);
      }
      double score = 0;
      score = (double)count/4;
      score*=100;
      
      System.out.println("You got " + score + " percent");
      
   
   }



}