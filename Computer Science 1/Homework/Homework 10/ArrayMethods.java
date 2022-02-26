import java.util.Scanner;
public class ArrayMethods
{
   public static void main(String[] args)
   {
      int[] array = createArray();
      findMax(array);
      findMin(array);
      average(array);
      divisibleBy5(array);
      printArray(array);
      printArrayBackwards(array);
      smallestTwoNums(array);
   }

   public static int[] createArray()
   {
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter length of array");
      int length = reader.nextInt();
      int[] nums = new int[length];
      for(int i=0; i<nums.length; i++)
      {
         System.out.println("Enter value");
         nums[i] = reader.nextInt();  
      }
      return nums;
   }
   public static int findMax(int[] a)
   {
      int max = a[0];
      for(int i=1; i<a.length; i++)
      {
         if(a[i]>max)
            max = a[i];
      }
      System.out.println("The max is " + max);
      return max;
   }
   public static int findMin(int[] a)
   {
      int min = a[0];
      for(int i=1; i<a.length; i++)
      {
         if(a[i]<min)
            min = a[i];
      }
      System.out.println("The min is " + min);
      return min;
   }
   public static double average(int[] a)
   {
      int sum = 0;
      double average = 0;
      for(int i=0; i<a.length; i++)
      {
         sum+=a[i];
      }
      average = (double)sum/a.length;
      System.out.println("The average is " + average);
      return average;
   }
   public static int divisibleBy5(int[] a)
   {
      int count = 0;
      for(int i=0; i<a.length; i++)
      {
         if(a[i]%5==0)
            count++;
      }
      System.out.println("The number of numbers divisible by 5 is " + count);
      return count;
   }
   public static void printArray(int[] a)
   {
      for(int i=0; i<a.length; i++)
      {
         System.out.print(a[i] + " ");
      }
      System.out.println();
   }
   public static void printArrayBackwards(int[] a)
   {
      for(int i=a.length-1; i>=0; i--)
      {
         System.out.print(a[i] + " ");
      }
      System.out.println();
   }
   public static void smallestTwoNums(int[] a)
   {
      int smallest = findMin(a);
      int smallest2 = findMax(a);
      for(int i=0; i<a.length; i++)
      {
         if(a[i]<smallest)
            smallest = a[i];
         if(a[i]<smallest2 && a[i]!=smallest)
            smallest2=a[i];  
      }
      System.out.println("The smallest two integers are " + smallest + " and " + smallest2);
   }
}