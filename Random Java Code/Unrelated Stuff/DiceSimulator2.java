import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class DiceSimulator2 {

	public static void main(String[] args) throws IOException
	{
		Random rng = new Random();
		PrintWriter os = new PrintWriter(new FileOutputStream("output.txt"));
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
	        os.printf("You rolled a %d on a %d sided die %d rolls out of " + rolls, (y+1), maxroll, counter[y]);
	        os.println(); 
	      }
		os.close();
		

	}

}
