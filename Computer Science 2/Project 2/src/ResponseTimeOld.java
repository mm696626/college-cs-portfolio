import java.util.Scanner;
import java.util.Random;
public class ResponseTimeOld {

	public static void main(String[] args) 
	{
		Random rng = new Random();
		int subject = rng.nextInt(4)+1;
		printInstructions(subject);
		Scanner reader = new Scanner(System.in);
		long startTime;
		long endTime;
		long reactionTime;
		long reactionTimeSum = 0;
		double averageReactionTime=0;
		int questionNumber=1;
		int numberCorrect=0;
		
		if(questionNumber==1 && subject==1)
		{
			int num1=rng.nextInt(101);
			int num2=rng.nextInt(101);
			int correctAnswer = num1+num2;
			System.out.println("What is " + num1 + " + " + num2 + "?");
			startTime = System.currentTimeMillis();
			int answer = reader.nextInt();
			endTime = System.currentTimeMillis();
			reactionTime = endTime - startTime;
			reactionTimeSum+= reactionTime;
			if(answer==correctAnswer)
			{
				System.out.println("Your answer is correct");
				numberCorrect++;
			}
			else
			{
				System.out.println("Incorrect answer, but you gave an answer nontheless");
			}
			System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
			
		}
		if(questionNumber==1 && subject==2)
		{
			
			String correctAnswer = "William Shakespeare";
			System.out.println("Who is the author of Macbeth? (Give a first and last name)");
			startTime = System.currentTimeMillis();
			String answer = reader.nextLine();
			endTime = System.currentTimeMillis();
			reactionTime = endTime - startTime;
			reactionTimeSum+= reactionTime;
			if(answer.equalsIgnoreCase(correctAnswer))
			{
				System.out.println("Your answer is correct");
				numberCorrect++;
			}
			else
			{
				System.out.println("Incorrect answer, but you gave an answer nontheless");
			}
			System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
			
		}
		if(questionNumber==1 && subject==3)
		{
			
			String correctAnswer = "Washington DC";
			System.out.println("What is the capital of the United States?");
			startTime = System.currentTimeMillis();
			String answer = reader.nextLine();
			endTime = System.currentTimeMillis();
			reactionTime = endTime - startTime;
			reactionTimeSum+= reactionTime;
			if(answer.equalsIgnoreCase(correctAnswer))
			{
				System.out.println("Your answer is correct");
				numberCorrect++;
			}
			else
			{
				System.out.println("Incorrect answer, but you gave an answer nontheless");
			}
			System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
			
		}
		if(questionNumber==1 && subject==4)
		{
			
			String correctAnswer = "Tom Kenny";
			System.out.println("Who is the voice of Spongebob? (First and last name)");
			startTime = System.currentTimeMillis();
			String answer = reader.nextLine();
			endTime = System.currentTimeMillis();
			reactionTime = endTime - startTime;
			reactionTimeSum+= reactionTime;
			if(answer.equalsIgnoreCase(correctAnswer))
			{
				System.out.println("Your answer is correct");
				numberCorrect++;
			}
			else
			{
				System.out.println("Incorrect answer, but you gave an answer nontheless");
			}
			System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
			
		}
		
		System.out.println("Time for question 2 - press enter to start if there is no question below"); //try to fix scanner bug
		System.out.println("--------------------------");
		System.out.println();
		String dummy = reader.nextLine();
		questionNumber++;
		subject = rng.nextInt(4)+1;
		printInstructions(subject);
		
		
		
		if(questionNumber==2 && subject==1)
		{
			int num1=rng.nextInt(101);
			int num2=rng.nextInt(101);
			int correctAnswer = num1-num2;
			System.out.println("What is " + num1 + " - " + num2 + "?");
			startTime = System.currentTimeMillis();
			int answer = reader.nextInt();
			endTime = System.currentTimeMillis();
			reactionTime = endTime - startTime;
			reactionTimeSum+= reactionTime;
			if(answer==correctAnswer)
			{
				System.out.println("Your answer is correct");
				numberCorrect++;
			}
			else
			{
				System.out.println("Incorrect answer, but you gave an answer nontheless");
			}
			System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
			
		}
		if(questionNumber==2 && subject==2)
		{
			
			String correctAnswer = "Simile";
			System.out.println("What is the term of a compariason using like or as?");
			startTime = System.currentTimeMillis();
			String answer = reader.nextLine();
			endTime = System.currentTimeMillis();
			reactionTime = endTime - startTime;
			reactionTimeSum+= reactionTime;
			if(answer.equalsIgnoreCase(correctAnswer))
			{
				System.out.println("Your answer is correct");
				numberCorrect++;
			}
			else
			{
				System.out.println("Incorrect answer, but you gave an answer nontheless");
			}
			System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
			
		}
		if(questionNumber==2 && subject==3)
		{
			
			String correctAnswer = "Abraham Lincoln";
			System.out.println("Who is the 16th president of the United States?");
			startTime = System.currentTimeMillis();
			String answer = reader.nextLine();
			endTime = System.currentTimeMillis();
			reactionTime = endTime - startTime;
			reactionTimeSum+= reactionTime;
			if(answer.equalsIgnoreCase(correctAnswer))
			{
				System.out.println("Your answer is correct");
				numberCorrect++;
			}
			else
			{
				System.out.println("Incorrect answer, but you gave an answer nontheless");
			}
			System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
			
		}
		if(questionNumber==2 && subject==4)
		{
			
			String correctAnswer = "1985";
			System.out.println("What year was Super Mario Bros. released");
			startTime = System.currentTimeMillis();
			String answer = reader.nextLine();
			endTime = System.currentTimeMillis();
			reactionTime = endTime - startTime;
			reactionTimeSum+= reactionTime;
			if(answer.equalsIgnoreCase(correctAnswer))
			{
				System.out.println("Your answer is correct");
				numberCorrect++;
			}
			else
			{
				System.out.println("Incorrect answer, but you gave an answer nontheless");
			}
			System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
			
		}
		
		System.out.println("Time for question 3 - press enter to start if there is no question below");
		dummy = reader.nextLine();
		questionNumber++;
		subject = rng.nextInt(4)+1;
		printInstructions(subject);
		System.out.println("--------------------------");
		System.out.println();
		
		if(questionNumber==3 && subject==1)
		{
			int num1=rng.nextInt(101);
			int num2=rng.nextInt(101);
			int correctAnswer = num1*num2;
			System.out.println("What is " + num1 + " * " + num2 + "?");
			startTime = System.currentTimeMillis();
			int answer = reader.nextInt();
			endTime = System.currentTimeMillis();
			reactionTime = endTime - startTime;
			reactionTimeSum+= reactionTime;
			if(answer==correctAnswer)
			{
				System.out.println("Your answer is correct");
				numberCorrect++;
			}
			else
			{
				System.out.println("Incorrect answer, but you gave an answer nontheless");
			}
			System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
			
		}
		if(questionNumber==3 && subject==2)
		{
			
			String correctAnswer = "Semicolon";
			System.out.println("What do you use to seperate an independent and a dependent clause?");
			startTime = System.currentTimeMillis();
			String answer = reader.nextLine();
			endTime = System.currentTimeMillis();
			reactionTime = endTime - startTime;
			reactionTimeSum+= reactionTime;
			if(answer.equalsIgnoreCase(correctAnswer))
			{
				System.out.println("Your answer is correct");
				numberCorrect++;
			}
			else
			{
				System.out.println("Incorrect answer, but you gave an answer nontheless");
			}
			System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
			
		}
		if(questionNumber==3 && subject==3)
		{
			
			String correctAnswer = "Thomas Jefferson";
			System.out.println("Who wrote the Declaration of Independence?");
			startTime = System.currentTimeMillis();
			String answer = reader.nextLine();
			endTime = System.currentTimeMillis();
			reactionTime = endTime - startTime;
			reactionTimeSum+= reactionTime;reactionTimeSum+= reactionTime;
			if(answer.equalsIgnoreCase(correctAnswer))
			{
				System.out.println("Your answer is correct");
				numberCorrect++;
			}
			else
			{
				System.out.println("Incorrect answer, but you gave an answer nontheless");
			}
			System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
			
		}
		if(questionNumber==3 && subject==4)
		{
			
			String correctAnswer = "Miami Dolphins";
			System.out.println("Who is the only football team to have a perfect season and win the Super Bowl (Give the city and the team e.x. Philadelphia Eagles)?");
			startTime = System.currentTimeMillis();
			String answer = reader.nextLine();
			endTime = System.currentTimeMillis();
			reactionTime = endTime - startTime;
			reactionTimeSum+= reactionTime;
			if(answer.equalsIgnoreCase(correctAnswer))
			{
				System.out.println("Your answer is correct");
				numberCorrect++;
			}
			else
			{
				System.out.println("Incorrect answer, but you gave an answer nontheless");
			}
			System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
			
		}
		System.out.println("Time for the final question - press enter to start if there is no question below"); //try to fix scanner bug
		System.out.println("--------------------------");
		System.out.println();
		dummy = reader.nextLine();
		questionNumber++;
		subject = rng.nextInt(4)+1;
		printInstructions(subject);
		
				if(questionNumber==4 && subject==1)
				{
					double num1=rng.nextInt(101);
					double num2=rng.nextInt(101);
					double correctAnswer = num1*num2;
					System.out.println("What is " + num1 + " / " + num2 + "?");
					startTime = System.currentTimeMillis();
					double answer = reader.nextDouble();
					endTime = System.currentTimeMillis();
					reactionTime = endTime - startTime;
					reactionTimeSum+= reactionTime;
					if(answer==correctAnswer)
					{
						System.out.println("Your answer is correct");
						numberCorrect++;
					}
					else
					{
						System.out.println("Incorrect answer, but you gave an answer nontheless");
					}
					System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
					
				}
				if(questionNumber==4 && subject==2)
				{
					
					String correctAnswer = "Juliet";
					System.out.println("Who said this: Wherefore art thou Romeo.");
					startTime = System.currentTimeMillis();
					String answer = reader.nextLine();
					endTime = System.currentTimeMillis();
					reactionTime = endTime - startTime;
					reactionTimeSum+= reactionTime;
					if(answer.equalsIgnoreCase(correctAnswer))
					{
						System.out.println("Your answer is correct");
						numberCorrect++;
					}
					else
					{
						System.out.println("Incorrect answer, but you gave an answer nontheless");
					}
					System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
					
				}
				if(questionNumber==4 && subject==3)
				{
					
					String correctAnswer = "Japan";
					System.out.println("What country was Pearl Harbor bombed by?");
					startTime = System.currentTimeMillis();
					String answer = reader.nextLine();
					endTime = System.currentTimeMillis();
					reactionTime = endTime - startTime;
					reactionTimeSum+= reactionTime;
					if(answer.equalsIgnoreCase(correctAnswer))
					{
						System.out.println("Your answer is correct");
						numberCorrect++;
					}
					else
					{
						System.out.println("Incorrect answer, but you gave an answer nontheless");
					}
					System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
					
				}
				if(questionNumber==4 && subject==4)
				{
					
					String correctAnswer = "Lady Gaga";
					System.out.println("Name the singer by the lyrics: Cant read my cant read my cant read my poker face");
					startTime = System.currentTimeMillis();
					String answer = reader.nextLine();
					endTime = System.currentTimeMillis();
					reactionTime = endTime - startTime;
					reactionTimeSum+= reactionTime;
					if(answer.equalsIgnoreCase(correctAnswer))
					{
						System.out.println("Your answer is correct");
						numberCorrect++;
					}
					else
					{
						System.out.println("Incorrect answer, but you gave an answer nontheless");
					}
					System.out.println("Your reaction time for question " + questionNumber + " is: " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds");
					
				}
				averageReactionTime = (double)reactionTimeSum/questionNumber;
				System.out.println("Your average reaction time is : " + averageReactionTime + " milliseconds or " + ((double)averageReactionTime/1000) + " seconds" + " with " + numberCorrect + " of 4 correct answers");

	}
		public static void printInstructions(int s)
		{
			if(s==1)
				System.out.println("Answer this math question");
			else if(s==2)
				System.out.println("Answer this english question");
			else if(s==3)
				System.out.println("Answer this history/geography question");
			else if(s==4)
				System.out.println("Answer this random trivia question");
		}
}
