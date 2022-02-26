import java.util.*;
public class DiceSimulator
{
   public static void main(String args[])
   {
      Random rng = new Random();
      Scanner reader = new Scanner(System.in);
      int rolls = 0;
      int maxroll = 0;
      while(maxroll<=0)
      {
         System.out.print("Enter highest number on dice: ");
         maxroll = reader.nextInt();

      }
      while(rolls<=0)
      {
         System.out.print("Enter number of rolls to perform: ");
         rolls = reader.nextInt();
      }
      int[] nums = new int[rolls];
      for(int x=0; x<nums.length; x++)
      {
         int num = rng.nextInt(maxroll)+1;
         nums[x] = num;
      
      }
      int[] counter = new int[maxroll];
      int count=1;
      int countnums=0;
      while(count<=maxroll)
      {
         countnums=0;
         for(int x=0; x<nums.length; x++)
         {
            if(nums[x] == count)
            {
               countnums++;
            }
         
         }
         counter[count-1] = countnums;
         count++;
      }
      for(int y=0; y<counter.length; y++)
      {
         System.out.printf("You rolled a %d on a %d sided die %.2f percent of the time", (y+1), maxroll, (((double)counter[y]/rolls)*100));
         System.out.println(); 
      }
   }

}