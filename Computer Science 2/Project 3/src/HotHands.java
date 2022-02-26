/**
 * This program is to simulate something called the "Hot Hands" experiment in which it counts how many times a coin is flipped heads/tails 4 and 5 times in a row
 * @author Matthew McCullough
 * @date 2/12/2019
 */
import java.util.Random;
import java.io.*;
public class HotHands {

	public static void main(String[] args) throws IOException
	{
		Random rng = new Random();
		PrintWriter os = new PrintWriter(new FileOutputStream("output.txt"));
		int coinFlip=0;
		int fourInARow=0;
		int fiveInARow=0;
		int headCounter=0;
		double ratio=0;
		double totalRatio=0;
		final int coinFlips=100; //number of coin flips (100 is default number of coin flips)
		final int trials = 5000; //number of trials (5000 is default number of trials)
		for(int i=0; i<trials; i++) 
		{
			fourInARow=0;
			fiveInARow=0;
			String[] flips = new String[coinFlips]; 
			for(int j=0; j<flips.length; j++)
			{
				coinFlip=rng.nextInt(2);
				if(coinFlip==0) //heads
					headCounter++;
				if(coinFlip==1) //tails
					headCounter=0;
				if(headCounter>=4) //check for 4 heads in a row
					fourInARow++;
				if(headCounter>=5) //check for 5 heads in a row
					fiveInARow++;
			}
			if(fiveInARow==0 && fourInARow==0) //if there were no 4 or 5 head runs
				os.println("Trial " + (i+1)  + " **Did not produce any hhhh runs**");
				
			else //if there were any good trials, add to the ratio here
			{ 
				ratio = (double)fiveInARow/fourInARow;
				totalRatio+=ratio;
				os.println("Trial " + (i+1)  + " hhhh: " + fourInARow + " hhhhh: " + fiveInARow + " Ratio : " + ratio);
			}
				
			
		}
		os.println("Total Ratio: " + ((double)totalRatio/trials));
		os.close();
		
		

	}

}
