import java.util.Scanner;

class Triangle3 
{
     public static void main ( String[] args )
     {  
          Scanner keyboard = new Scanner( System.in );
          int  i, j;
          int  number_of_lines=0;
          while(number_of_lines<=0 || number_of_lines%2==0)
          {
            System.out.println("Enter how big you'd like the triangle to be. Odd numbers only");
            number_of_lines = keyboard.nextInt();
          }
          System.out.println();
          
          for (i=1; i <=(number_of_lines/2)+1; ++i) 
          {
               for (j = 1; j <= i; j++)
               {
                    System.out.print("*");
               }
               System.out.println();
          }
          
           for (i=(number_of_lines/2); i >0; --i) 
          {
               for (j = 1; j <= i; j++)
               {
                    System.out.print("*");
               }
               System.out.println();
          }

     }
}