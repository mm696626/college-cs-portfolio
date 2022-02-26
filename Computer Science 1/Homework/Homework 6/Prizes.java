import java.util.Random;
public class Prizes
{
   final static int RANGE = 30;
   public static void main(String[] args)
   {
      Random rng = new Random();
      int num1 = rng.nextInt(RANGE)+1;
      int num2 = rng.nextInt(RANGE)+1;
      int num3 = rng.nextInt(RANGE)+1; 
      while(num1==num2 || num2==num3 || num1==num3)
      {
        num1 = rng.nextInt(RANGE)+1;
        num2 = rng.nextInt(RANGE)+1;
        num3 = rng.nextInt(RANGE)+1;
      }   
      System.out.println("The winners are: " + num1 + ", " + num2 + ", and " + num3);  
   }


}