import java.util.Scanner;
public class Fibonacci
{
   public static void main(String[] args)
   {
      int limit=0;
      long num1=1;
      long num2=1;
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter number of times to do this");
      limit = reader.nextInt();
      System.out.print(num1 + " ");
      System.out.print(num2 + " ");
      int counter=0;
      while(counter<limit)
      {
         
         num1 = num1+num2;
         num2 = num1+num2;
         if(num1 <0 || num2 <0)
        	 break;
         System.out.print(num1 + " ");
         counter++;
         if(counter<limit)
            System.out.print(num2 + " ");
         
      }
         
         
      
   }
   
}
   


