import java.util.Scanner;
public class Backwards
{
   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter a two digit integer");
      int num = reader.nextInt();
      
      int digit1=0;
      int digit2=0;
      digit1 = num%10;
      num/=10;
      digit2 = num;
      
      System.out.println(digit1 + "" + digit2);
   }


} 