import java.util.Scanner;
import java.text.NumberFormat;
public class Resturant
{
   public static void main(String[] args)
   {
      NumberFormat money = NumberFormat.getCurrencyInstance();
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter total bill");
      double totalBill = reader.nextDouble();
      int numberInGroup=0;
      if(totalBill>=0)
      {
         System.out.println("Enter number of people in your group");
         numberInGroup=reader.nextInt();
      }
      
      double personOwes=0;
      
      if(totalBill>=0 && numberInGroup>0)
      {
         
         System.out.println("Enter the percentage tip");
         double tip = reader.nextDouble();
         if(tip<0)
         {
            System.out.println("Invalid Tip. Tip was set to 0%, you cruel monster!");
            tip=0;
         }
         personOwes = totalBill+((tip/100)*totalBill);
         personOwes /= numberInGroup;
      }
      if(numberInGroup<=0 || totalBill<0)
         System.out.println("Invalid input");
      else
         System.out.printf("Each person owes $%.2f",personOwes); 
     
      
      
   }


}