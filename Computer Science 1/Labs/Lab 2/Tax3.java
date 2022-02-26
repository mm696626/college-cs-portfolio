/*
Name:        Matt McCullough
Date:        9/12/2018
Title:       Tax3.java
Description: Calculates the tax on an item
Input:       the cost of an item and the tax rate
Output:      The tax on the item and the item's total cost
*/
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
class Tax3
{
   public static void main (String args[])
   {
      Scanner keyboard = new Scanner(System.in);
      NumberFormat money = NumberFormat.getCurrencyInstance(Locale.CANADA);
      float price, taxrate, tax, total;
      System.out.println("Program to compute tax");
      System.out.println("Enter price of item:");
      price = keyboard.nextFloat();
      total = price;
      taxrate = 8;
      tax = taxrate / (float)100.0 * price;
      System.out.println("Provincial Tax on item is " + money.format(tax));
      total += tax;
      taxrate = 7;
      tax = taxrate / (float)100.0 * price;
      total += tax;
      System.out.println("Federal Tax on item is " + money.format(tax));
      
      System.out.println("Total price is " + money.format(total));
    }  //end main
 }  //end Tax3 class