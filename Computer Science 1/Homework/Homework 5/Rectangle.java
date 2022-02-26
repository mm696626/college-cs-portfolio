import java.util.Scanner;

class Rectangle 
{
     public static void main ( String[] args )
     { 
          Scanner keyboard = new Scanner( System.in );
          int     length;
          int     width;
          int     count,count2;
          char    response;
          String  strResponse;

          do {
               System.out.print("Enter length of rectangle: ");
               length = keyboard.nextInt();
               System.out.println();
               System.out.print("Enter width of rectangle: ");
               width = keyboard.nextInt();
               System.out.println();
               for(count=1; count <=width; count++)
               {
                  for (count2=1; count2 <=length; count2++) 
                  {
                       System.out.print("*");
                  }
                   System.out.println();
               }
                            
               System.out.print("\nAnother rectangle? (y/n): ");
               strResponse = keyboard.next();
               response = strResponse.charAt( 0 );
               while(response!= 'n' && response != 'N' && response != 'Y' && response !='y')
               {
                  System.out.print("\nAnother rectangle? (y/n): ");
                  strResponse = keyboard.next();
                  response = strResponse.charAt( 0 );
               }
          } while (response != 'n' && response != 'N');
     } 
}