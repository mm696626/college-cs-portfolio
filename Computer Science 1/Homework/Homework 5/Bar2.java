import java.util.Scanner;

class Bar2 
{
     public static void main ( String[] args )
     { 
          Scanner keyboard = new Scanner( System.in );
          int     length;
          int     count;
          char    response;
          String  strResponse;

          do {
               System.out.print("Enter length of bar: ");
               length = keyboard.nextInt();
               System.out.println();
               for (count=1; count <=length; count++) 
               {
                    System.out.print("*");
               }
               System.out.println();
               
               System.out.print("\nAnother bar? (y/n): ");
               strResponse = keyboard.next();
               response = strResponse.charAt( 0 );
               while(response!= 'n' && response != 'N' && response != 'Y' && response !='y')
               {
                  System.out.print("\nAnother bar? (y/n): ");
                  strResponse = keyboard.next();
                  response = strResponse.charAt( 0 );
               }
          } while (response != 'n' && response != 'N');
     } 
}