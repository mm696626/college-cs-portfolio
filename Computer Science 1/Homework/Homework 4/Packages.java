import java.util.Scanner;
import java.text.NumberFormat;
public class Packages
{
   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
      NumberFormat money = NumberFormat.getCurrencyInstance();
      int packagetype = 0; //0 for a, 1 for b, 2 for c
      int hours = 0;
      double costpermonth = 0;
      
      System.out.println("Enter the package you would like to purchase? Type 0 for A, 1 for B, and 2 for C");
      packagetype = reader.nextInt();
      if(packagetype>=0 && packagetype<3)
      {
         System.out.println("How many hours have you used");
         hours = reader.nextInt();
      }
      
      if(packagetype==0) //calculates monthly cost
      {
         costpermonth = 9.95;
         if(hours>10)
            costpermonth+=((hours-10)*2);
      }
      else if(packagetype==1)
      {
          costpermonth = 13.95;
         if(hours>20)
            costpermonth+=((hours-20));
      }
      else if(packagetype==2)
         costpermonth=19.95;
      
      
      
       if(packagetype==0) //calculates savings
      {
         double costB = 13.95;
         if(hours>20)
            costB+=((hours-20));
         double costC = 19.95;
         
         double savingsB = costpermonth - costB;
         double savingsC = costpermonth - costC;
         
         if(savingsB>0)
            System.out.println("Your savings with package B are " + money.format(savingsB));
         if(savingsC>0)
            System.out.println("Your savings with package C are " + money.format(savingsC));
      }
      else if(packagetype==1)
      {
         double costC = 19.95;
         double savingsC = costpermonth - costC;
         if(savingsC>0)
            System.out.println("Your savings with package C are " + money.format(savingsC));
      }
      if(packagetype>=0 && packagetype<3)
         System.out.println("Your monthly bill is " + money.format(costpermonth));
      else
         System.out.println("Invalid input");
   
   }



}