import java.util.Scanner;
public class Integers
{
   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
      int numbers;
      int max=0;
      int min=0;
      int input=0;
      String quit="";
      do
      {
         System.out.print("Enter the number of integers you want to input: ");
         numbers = reader.nextInt();
         System.out.println();
      }while(numbers<=0);
      int count=0;
      String dummy = reader.nextLine();
      while(count<numbers)
      {
         System.out.print("Enter an integer: ");
         input = reader.nextInt();
         System.out.println();
         if(count==0)
         {
            max = input;
            min = input;
         }   
         if(input>=max)
            max = input;
         if(input<=min)
            min = input;
         
         count++;
         if(count!=numbers)
         {
            System.out.println("Do you want to quit? If so, Enter 'q' to quit");
            quit = reader.next();
            if(quit.equals("q")) 
               break;
         
         }
         
         
      }
      
         System.out.println("The maximum is " + max);
         System.out.println("The minimum is " + min);         
      
   }

}