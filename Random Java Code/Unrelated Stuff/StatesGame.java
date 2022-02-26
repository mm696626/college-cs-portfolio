import java.util.ArrayList;
import java.util.Scanner;
public class StatesGame {

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		int statesGuessed=0;
		boolean wrongGuess =false;
		boolean isGuessed=false;
		String[] correctStates = {"Alabama","Alaska","Arizona","Arkansas", "California", "Colorado", "Connecticut", "Delaware",
								  "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisana",
								  "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
								  "Nevada", "New Hampshire","New Jersey","New Mexico","New York","North Carolina", "North Dakota", "Ohio",
								  "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah",
								  "Vermont","Virginia","Washington","West Virginia", "Wisconsin", "Wyoming"};
		ArrayList<String> states = new ArrayList<String>();
		
		System.out.println("Guess the states without getting one wrong");
		
		while(wrongGuess==false)
		{
			isGuessed=false;
			System.out.println("You have guessed " + statesGuessed + "/50");
			if(statesGuessed<50)
			System.out.println("Guess a state");
			String guess = reader.nextLine();
			for(int i=0; i<correctStates.length; i++)
			{
				
				if(guess.equalsIgnoreCase(correctStates[i]))
				{
					isGuessed=true;
					statesGuessed++;
					correctStates[i] ="";
				}	
				
					
			}
			if(isGuessed==false)
				wrongGuess=true;
			
			
		}

	}

}
