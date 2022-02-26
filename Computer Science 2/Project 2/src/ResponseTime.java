/**
 * This program aims to get response times for various math questions
 * @author Matthew McCullough
 * @date 2/10/2019
 */
import java.util.Random;
import java.util.Scanner;
public class ResponseTime {

	public static void main(String[] args) 
	{
		Random rng = new Random();
		Scanner reader = new Scanner(System.in);
		long startTime; /** time started to answer*/
		long endTime;	/** time when they give an answer*/
		long reactionTime; /** given a reaction time */
		long reactionTimeSum = 0; /**sum of reaction times to calculate average*/
		double averageReactionTime=0; /**average of reaction times*/
		
		//variable correctAnswer which is used all over is used to store the correct answer when each problem is generated
		int num1=rng.nextInt(101);
		int num2=rng.nextInt(101);
		int correctAnswer = num1+num2; 
		int answer = correctAnswer-1; 
		//did the above line of code before every question as a fail-safe in case the 2 numbers just so happened to conflict which the previous question's answer (e.x. the answer to problem 1 is 40 and you typed 40 so it would skip question 2 if the answer to it so happened to be 40)
		startTime = System.currentTimeMillis();
		while(correctAnswer!=answer)
		{
			System.out.println("What is " + num1 + " + " + num2 + "?");
			answer=reader.nextInt();
			if(answer!=correctAnswer)
				System.out.println("Try Again");
		}
		endTime = System.currentTimeMillis();
		reactionTime = endTime - startTime;
		System.out.println("It took you " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds to get the answer correct");
		reactionTimeSum+= reactionTime;
		
		
		/**subtraction problem*/
		num1 = rng.nextInt(101);
		num2 = rng.nextInt(101);
		correctAnswer = num1-num2;
		answer = correctAnswer-1;
		startTime = System.currentTimeMillis();
		while(correctAnswer!=answer)
		{
			System.out.println("What is " + num1 + " - " + num2 + "?");
			answer=reader.nextInt();
			if(answer!=correctAnswer)
				System.out.println("Try Again");
		}
		
		endTime = System.currentTimeMillis();
		reactionTime = endTime - startTime;
		System.out.println("It took you " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds to get the answer correct");
		reactionTimeSum+= reactionTime;
		
		
		/**multiplication problem*/
		num1 = rng.nextInt(21);
		num2 = rng.nextInt(21);
		correctAnswer = num1*num2;
		answer = correctAnswer-1;
		startTime = System.currentTimeMillis();
		while(correctAnswer!=answer)
		{
			System.out.println("What is " + num1 + " * " + num2 + "?");
			answer = reader.nextInt();
			if(answer!=correctAnswer)
				System.out.println("Try Again");
		}
		endTime = System.currentTimeMillis();
		reactionTime = endTime - startTime;
		System.out.println("It took you " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds to get the answer correct");
		reactionTimeSum+= reactionTime;
		
			
		/**remainder problem*/
		num1 = rng.nextInt(21);
		num2 = rng.nextInt(21);
		correctAnswer = num1%num2;
		answer = correctAnswer-1;
		startTime = System.currentTimeMillis();
		while(correctAnswer!=answer)
		{
			System.out.println("What is " + num1 + " % " + num2 + "?");
			System.out.println("This means what is the remainder");
			answer = reader.nextInt();
			if(answer!=correctAnswer)
				System.out.println("Try Again");
		}
		endTime = System.currentTimeMillis();
		reactionTime = endTime - startTime;
		System.out.println("It took you " + reactionTime + " milliseconds or " + ((double)reactionTime/1000) + " seconds to get the answer correct");
		reactionTimeSum+= reactionTime;
		
			
		/**calculate average*/
		averageReactionTime = (double)reactionTimeSum/4;
		System.out.println("Your average reaction time is : " + averageReactionTime + " milliseconds or " + ((double)averageReactionTime/1000) + " seconds");
		/*
		 * Comments:
		 * Student 1 forgot remainder/didn't know what it was at first, but otherwise was pretty good
		 * Student 2 had general trouble with the math questions, so reaction was slow
		 * Student 3 had trouble on subtraction, but was good everywhere else 
		 * Student 4 got the math questions right away aside from addition, so reaction was quite fast
		 * Student 5 got addition, and subtraction right away, but multiplication (blanked for a few seconds) and finding the remainder was quite the struggle 
		 *
		 */
	}
	

}
