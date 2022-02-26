/**
 * @author Matthew McCullough
 * This class tests various array methods such as finding the average and calculating the smallest number
 */
import java.util.Random;
public class Methods
{
   public static void main(String[] args)
   { 
	  /**An array of numbers randomly generated from [0,1000]*/
	  int[] nums = new int[100];
      Random rng = new Random();
      for(int i=0; i<nums.length; i++)
      {
         nums[i] = rng.nextInt(1001);
      }
      /**An array of numbers reversed from array nums*/
      int[] newArray = reverse(nums);
      System.out.println("The average of array nums is: " + average(nums));
      System.out.println("The smallest number in the array is: " + min(nums));
      System.out.println("The first number in the array is : " + nums[0]);
      System.out.println("The last number in the array is : " + nums[nums.length-1]);
      System.out.println("After reverse");
      System.out.println("The first number in the reversed array is : " + newArray[0]);
      System.out.println("The last number in the reversed array is : " + newArray[nums.length-1]);
      /**An array of a shopping list*/
      String[] shoppingList = {"soda","corn","beans","chips","apples"};
      /**An array that the contents of array shoppingList are reversed*/
      String[] reverseList = reverse(shoppingList);
      System.out.println("The first number in the array is : " + shoppingList[0]);
      System.out.println("The last number in the array is : " + shoppingList[shoppingList.length-1]);
      
      System.out.println("After reverse");
      System.out.println("The first number in the array is : " + reverseList[0]);
      System.out.println("The last number in the array is : " + reverseList[reverseList.length-1]);
      
      System.out.println("The average of the even indexes is " + averageEvenIndexes(nums));

      
   }
   /**
    * @param takes in an array in which the average of all numbers inside is calculated
    * @return returns the average of the numbers in the array
    */
   public static double average(int[] a)
   {
      int sum=0;
      for(int i=0; i<a.length; i++)
      {
         sum+=a[i];
      }
      double average = (double)sum/a.length;
      return average;
   }
   /**
    * @param takes in an array in which the smallest number in the array is found
    * @return returns the smallest number in the array
    */
   public static int min(int[] a)
   {
      int min = a[0];
      for(int i=1; i<a.length; i++)
      {
         if(a[i]<min)
            min = a[i];
      }
      return min;
   }
   /**
    * @param takes in an integer array in which it will be reversed
    * @return returns a new array which consists of the old array being reversed i.e. (1,2,3) turning into (3,2,1)
    */
   public static int[] reverse(int[] a)
   {
      int counter=0;
      int[] newArray = new int[a.length];
      for(int i=a.length-1; i>=0; i--)
      {
         newArray[i] = a[counter];
         counter++;
      }
      return newArray;
   }
   /**
    * @param takes in an String array in which it will be reversed
    * @return returns a new String array which consists of the old array being reversed i.e. (a,b,c) turning into (c,b,a)
    */
   public static String[] reverse(String[] a)
   {
      int counter=0;
      String[] newArray = new String[a.length];
      for(int i=a.length-1; i>=0; i--)
      {
         newArray[i] = a[counter];
         counter++;
      }
      return newArray;
   }
   /**
    * @param takes in an integer array in which it will be reversed
    * @return returns the average of all numbers in an even index i.e. 0,2,4,6 e.t.c so (1,2,3) would average to 2
    */
   public static double averageEvenIndexes(int[] a)
   {
      int sum=0;
      int counter=0;
      for(int i=0; i<a.length; i++)
      {
         if(i%2==0)
         {
            sum+=a[i];
            counter++;
         }
      }
      double average = (double)sum/counter;
      return average;
      
   }

}