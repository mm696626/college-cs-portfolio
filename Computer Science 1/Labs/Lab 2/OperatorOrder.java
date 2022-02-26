import java.util.Scanner;
class OperatorOrder
{  
   public static void main(String args[])
   {
      double a,b,c;
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter a value for a");
      a = reader.nextInt();
      System.out.println("Enter a value for b");
      b = reader.nextInt();
      System.out.println("Enter a value for c");
      c = reader.nextInt();
      System.out.println("Solving 2a^2 + 4a - 29");
      double answer1 = 2*a*a + 4*a - 29;
      System.out.println("The answer is " + answer1);
      System.out.println("Solving 4c+ac/3b");
      double answer2 = (4*c+a*c)/(3*b);
      System.out.println(answer2);
   }



}