import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class mathGame
{  
   public static void main(String args[])
   {
      Random rng = new Random();
      Scanner reader = new Scanner(System.in);
      int num1 = 0;
      int num2 = 0;
      int max = 10;
      int answer = -1;
      double answer2 =-1;
      int operator = 0;
      int guess = 0; 
      double guess2 = 0;
      int numCorrect=0;

      boolean isRight=true;
      while(isRight==true)
      {
    	  
         num1 = rng.nextInt(max)+1;
         num2 = rng.nextInt(max)+1;
         operator = rng.nextInt(4)+1;
         if(operator==1)
         {
            answer = num1+num2;
            System.out.println("What is " + num1 + " + " + num2); 
            guess=reader.nextInt();
         }
         if(operator==2)
         {
            answer = num1-num2;
            System.out.println("What is " + num1 + " - " + num2); 
            guess=reader.nextInt();
         }
          if(operator==3)
         {
            answer = num1*num2;
            System.out.println("What is " + num1 + " * " + num2); 
            guess=reader.nextInt();
         }
         if(operator==4)
         {
        	 DecimalFormat df = new DecimalFormat("#.00");
        	 System.out.println("What is " + num1 + " / " + num2 + " (Round to 2 decimal places)"); 
        	 answer2 = (double)num1/num2;
        	 answer2 = Double.parseDouble(df.format(answer2));
        	 guess2 = reader.nextDouble();
        	 guess2 = Double.parseDouble(df.format(guess2));
        	
         }
         if(answer==guess)
         {
        	 numCorrect++;
         }
         else if(answer2==guess2)
         {
        	 numCorrect++;
         }
         else if(answer2!=guess2)
         {
        	 isRight=false;
         }
         else if(answer!=guess)
         {
            isRight=false;
         }
      }
      	System.out.println("You got " + numCorrect + " correct");
   }


}