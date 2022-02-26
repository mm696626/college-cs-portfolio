import java.util.Scanner;
class Expressions1
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
      max = first_value > second_value ? first_value : second_value;
      min = first_value < second_value ? first_value : second_value;
      System.out.println( "The maximum is " + max + " and minimum is " + min);
  }




}