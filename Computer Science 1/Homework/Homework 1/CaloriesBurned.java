/*
  Name:        Matt McCullough
  Date:        September 3, 2018
  Title:       CaloriesBurned.java
  Description: Calculates and outputs total calories burned for a 150-pound person
  Input:       MET (metabolic equivalents) Data
  Output:      total calories
*/
public class CaloriesBurned {

	public static void main(String[] args) 
	{
		double weight = 150; // 1 pound is ~0.453592 kg
		
		
		weight = weight * 0.453592; //convert to kg
		double calories = 0;
		int MET = 0;
		MET = 10; //calories for running 6 MPH (about 10 METS)
		//calories per minute formula
		calories = 0.0175 * MET * weight;
		calories = calories*30; //30 minutes of running formula calculates per minute
		System.out.println("Calories for running 6 MPH for 30 Minutes: " + calories + " calories");
		
		
		MET = 8; //calories for playing basketball (about 8 METS)
		//calories per minute formula
		calories = 0.0175 * MET * weight;
		calories = calories*30; //30 minutes of basketball formula calculates per minute
		System.out.println("Calories for playing basketball for 30 Minutes: " + calories + " calories");

		
		MET = 1; //calories for sleeping(about 1 MET)
		//calories per minute formula
		calories = 0.0175 * MET * weight;
		calories = calories*30; //30 minutes of basketball formula calculates per minute
		System.out.println("Calories for sleeping for 30 Minutes: " + calories + " calories");
		

	}

}
