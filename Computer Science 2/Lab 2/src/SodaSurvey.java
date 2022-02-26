/**
 * This program is practice for 2d arrays by using data from a soda survey
 * @author Matthew McCullough
 * @date 1/30/2019
 */
public class SodaSurvey {
	/**
	 * This is the main method where all of the other methods will be ran and tested
	 * 
	 */
	public static void main(String[] args) 
	{
		/**array of scores from soda survey, rows are people, cols are each soda*/
		int[][] scores = { {3, 4, 5, 2, 1, 4, 3, 2, 4, 4}, 
		{2, 4, 3, 4, 3, 3, 2, 1, 2, 2}, 
		{3, 5, 4, 5, 5, 3, 2, 5, 5, 5},
		{1, 1, 1, 3, 1, 2, 1, 3, 2, 4} };
		int counter=0;
		System.out.println("Averages:");
		for(int i=0; i<scores.length; i++)
		{
			int sum=0; 
			double average = 0;
			for(int j=0; j<scores[0].length; j++)
			{
				sum+=scores[i][j];
			}
			average = (double)sum/scores[0].length;
			counter++;
			System.out.println("Drink " + counter + " : " + average);
		}
		System.out.println();
		counter=0;
		for(int i=0; i<scores[0].length; i++)
		{
			int sum=0; 
			double average = 0;
			for(int j=0; j<scores.length; j++)
			{
				sum+=scores[j][i];
			}
			average = (double)sum/scores.length;
			counter++;
			System.out.println("Person " + counter + " : " + average);
		}
		
	}
		/*
		 * Sample output:
		 * Averages:
		   Drink 1 : 3.2
		   Drink 2 : 2.6
		   Drink 3 : 4.2
		   Drink 4 : 1.9
		   
		   Person 1 : 2.25
		   Person 2 : 3.5
		   Person 3 : 3.25
		   Person 4 : 3.5
		   Person 5 : 2.5
		   Person 6 : 3.0
		   Person 7 : 2.0
		   Person 8 : 2.75
		   Person 9 : 3.25
		   Person 10 : 3.75
		 */
}
