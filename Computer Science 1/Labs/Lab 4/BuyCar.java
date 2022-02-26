import java.util.Scanner;
import java.text.NumberFormat;
public class BuyCar
{
   public static void main(String[] args)
   {
      NumberFormat money = NumberFormat.getCurrencyInstance();
      final int TERMOFLOAN = 36;
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter amount of money you have to spend on car each month");
      double moneypermonth = reader.nextDouble();
      System.out.println("Enter the cost of Dream car");
      double dreamcar = reader.nextDouble();
      System.out.println("Enter the cost of PlanB car");
      double planB = reader.nextDouble();
      System.out.println("It seems you have " + money.format(moneypermonth) + " to spend on wither a " + money.format(dreamcar) + " or a " + money.format(planB) + " car");
      if((dreamcar/TERMOFLOAN)<=moneypermonth)
      {
         System.out.println("Congrats,You can get your Dream Car");
         System.out.println("You have " + money.format(moneypermonth - (dreamcar/TERMOFLOAN)) + " extra monthly to spend ");
      
      }
      else if((planB/TERMOFLOAN)<=moneypermonth)
      {
         System.out.println("Congrats,You can get Car B");
         System.out.println("You have " + money.format(moneypermonth - (planB/TERMOFLOAN)) + " extra monthly to spend ");
      }
      else
      {
          System.out.println("Get walking");
          System.out.println("You are " + money.format((planB/TERMOFLOAN) - moneypermonth) + " short");
      }

      
   
   }



}