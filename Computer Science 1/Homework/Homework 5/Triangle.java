import java.util.Scanner;

class Triangle 
{
     public static void main ( String[] args )
     {  
          Scanner keyboard = new Scanner( System.in );
          int  i, j;
          int  number_of_lines;

          System.out.println("Enter how big you'd like the triangle to be");
          number_of_lines = keyboard.nextInt();
             System.out.println();
          for (i=1; i <=number_of_lines; ++i) 
          {
               for (j = 1; j <= i; j++)
               {
                    System.out.print("*");
               }
               System.out.println();
          }
     }
}