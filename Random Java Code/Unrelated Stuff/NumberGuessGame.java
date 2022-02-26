import java.util.Random;
import java.util.Scanner;
public class NumberGuessGame {

	public static void main(String[] args)
	{	
		int mode = 0;
		
		Random rng = new Random();
		int numberToGuess = rng.nextInt(100)+1;
		int guess = -1;
		int numberOfGuesses = 0;
		int guessesLeft = 1;
		Scanner reader = new Scanner(System.in);
		System.out.println("What mode do you want to play 1- unlimited guesses 2- limited guesses");
		mode = reader.nextInt();
		
		if(mode==2)
			guessesLeft = rng.nextInt(10)+1;
		while(numberToGuess!=guess)
		{
			System.out.print("Guess a number from 1 to 100: ");
			guess = reader.nextInt();
			if(guess < 1 || guess > 100)
			{
				System.out.println("Guess is out of range");
				numberOfGuesses++;
			}
			else if(guess>numberToGuess)
			{
				System.out.println("Too High");
				numberOfGuesses++;
			}
			else if(guess<numberToGuess)
			{
				System.out.println("Too Low");
				numberOfGuesses++;
			}
			else if(guess==numberToGuess)
			{
				numberOfGuesses++;
				if(numberOfGuesses==1)
					System.out.println("You got it in 1 guess");
				else
					System.out.println("You got it in " + numberOfGuesses + " guesses");
				break;
			}
			
			if(mode == 2)
			{
				guessesLeft--;
				
				if(guessesLeft == 1)
				{
					System.out.println("You have 1 guess left");
				}
				else
				{
					System.out.println("You have " + guessesLeft + " guesses left");
				}
			}
			
			if(guessesLeft == 0)
			{
				System.out.println("Sorry you lost. The number was: " + numberToGuess);
				break;
			}
		}

		
		

	}

}
