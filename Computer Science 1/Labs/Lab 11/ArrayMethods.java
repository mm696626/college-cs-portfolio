import java.util.Scanner;
public class ArrayMethods
{
   public static void main(String[] args)
   {
      int[] nums = {0,1,2,3,4,5,6,7,8,9,10};
      printArray(nums);
      int[] numsReversed = newArrayReversed(nums);
      printArray(numsReversed);
      System.out.println("The intial of Matt is " + intial("Matt"));
      System.out.println("The sum of the even values in the array is " + sumEvens(nums));
      System.out.println("The sum of the values in odd indexes is " + sumOddIndexArray(nums));
      
   }

   
   public static void printArray(int[] a)
   {
      for(int i=0; i<a.length; i++)
      {
         System.out.print(a[i] + " ");
      }
      System.out.println();
   }
   public static int[] newArrayReversed(int[] a)
   {
      int count=0;
      int[] newArray = new int[a.length];
      for(int i=a.length-1; i>=0; i--)
      {
         newArray[count] = a[i];
         count++;
      }     
      return newArray;
   }
   public static char intial(String s)
   {
      return s.charAt(0);
   }
   public static int sumEvens(int[] a)
   {
      int sum=0;
      for(int i=0; i<a.length; i++)
      {
         if(a[i]%2==0)
            sum+=a[i];
      }
      return sum;
   }
   public static int sumOddIndexArray(int[] a)
   {
      int sum=0;
      for(int i=0; i<a.length; i++)
      {
         if(i%2!=0)
            sum+=a[i];
      }
      return sum;
   }
}