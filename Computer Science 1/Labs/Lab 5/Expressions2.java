import java.util.Scanner;
class Expressions2
{
  public static void main(String[] args)
  {
      Scanner keyboard = new Scanner(System.in);
      int first_value, second_value;
      int max,min;
      System.out.println("Enter first value (an integer)");
      first_value = keyboard.nextInt();
      System.out.println("Enter second value (another integer)");
      second_value = keyboard.nextInt();
      if(first_value>second_value)
      {
         max = first_value;
         min = second_value;
      }
      else if(second_value>first_value)
      {
         max = second_value;
         min = first_value;
      }
      else
      {
         max = first_value;
         min = first_value;
      }
      System.out.println( "The maximum is " + max + " and minimum is " + min);
  }




}