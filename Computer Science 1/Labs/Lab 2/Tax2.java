/*
Name:        Matt McCullough
Date:        9/12/2018
Title:       Tax2.java
Description: Calculates the tax on an item
Input:       the cost of an item and the tax rate
Output:      The tax on the item and the item's total cost
*/
import java.util.Scanner;
class Tax2
{
   public static void main (String args[])
   {
      Scanner keyboard = new Scanner(System.in);
      float price, taxrate, tax, total;
      System.out.println("Program to compute tax");
      System.out.println("Enter price of item:");
      price = keyboard.nextFloat();
      System.out.println("Enter tax rate in percent:");
      taxrate = keyboard.nextFloat();
      tax = taxrate / (float)100.0 * price;
      total = price + tax;
      System.out.println("Tax on item is " + tax);
      System.out.println("Total price is " + total);
    }  //end main
 }  //end Tax2 class