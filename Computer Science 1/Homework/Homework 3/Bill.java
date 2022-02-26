import java.util.Scanner;
public class Bill
{  
   public static void main(String args[])
   {
      Scanner reader = new Scanner(System.in);
      String name="";
      String name2="";
      String name3="";
      int quantity=0;
      int quantity2=0;
      int quantity3=0;
      double price=0;
      double price2=0;
      double price3=0;
      System.out.println("Input name of item 1");
      name = reader.nextLine();
      System.out.println("Input quantity of item 1");
      quantity = reader.nextInt();
      System.out.println("Input price of item 1");
      price=reader.nextDouble();
      
      String dummy = reader.nextLine();
      System.out.println("Input name of item 2");
      name2 = reader.nextLine();
      System.out.println("Input quantity of item 2");
      quantity2 = reader.nextInt();
      System.out.println("Input price of item 2");
      price2 = reader.nextDouble();
      
      dummy = reader.nextLine();
      System.out.println("Input name of item 3");
      name3 = reader.nextLine();
      System.out.println("Input quantity of item 3");
      quantity3 = reader.nextInt();
      System.out.println("Input price of item 3");
      price3=reader.nextDouble();
      
      
      double total = price*quantity;
      double total2 = price2*quantity2;
      double total3 = price3*quantity3;
      
      System.out.println("Your bill:");
      System.out.println("Item \t Quantity \t Price \t Total");
      System.out.printf("%s \t %d \t $%.2f \t $%.2f",name,quantity, price, total);
      System.out.println();
      System.out.printf("%s \t %d \t $%.2f \t $%.2f",name2,quantity2, price2, total2);
      System.out.println();
      System.out.printf("%s \t %d \t $%.2f \t $%.2f",name3,quantity3, price3, total3);
      System.out.println();
      double subtotal = total+total2+total3;
      System.out.println();
      System.out.printf("Subtotal \t \t \t $%.2f", subtotal);
      System.out.println();
      
      double salestax = subtotal*0.0625;
      System.out.printf("6.25 percent Sales Tax \t \t \t \t $%.2f", salestax);
      System.out.println();
      
      double finaltotal = subtotal+salestax;
      System.out.printf("Total \t \t \t $%.2f", finaltotal);

   
   }



}