import java.util.Scanner;
public class Digits
{
   public static void main(String args[])
   {
      int number = 0;
      int digit1 = 0;
      int digit2 = 0;
      int digit3 = 0;
      int digit4 = 0;
      int digit5 = 0;      
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter a 5 digit number");
      number = reader.nextInt();
      
      digit5 = number%10;
      number /=10;
      digit4 = number%10;
      number /=10;
      digit3 = number%10;
      number /=10;
      digit2 = number%10;
      number /=10;
      digit1 = number%10;  
      System.out.println(digit1 + "   " + digit2 + "   " + digit3 + "   " + digit4 + "   " + digit5);
   
   }


}