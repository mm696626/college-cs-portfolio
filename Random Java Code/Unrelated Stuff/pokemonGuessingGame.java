import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
public class pokemonGuessingGame {

	public static void main(String[] args) {
		  Scanner inputStream=null;
		  System.out.println("Attempting to load Pokemon text file!");
		       try{
		          inputStream= new Scanner (new FileInputStream("pokemon.txt"));
		       }
		       catch (FileNotFoundException e)
		       {
		     
		         System.out.println("Text file not found!");
		         System.exit(0);
		          
		       }
		   Scanner reader = new Scanner(System.in);
		   System.out.println("File has been found!");
		   System.out.println();
		   int gen = 0;  
		   while(gen<1 || gen > 7)
		   {
			   System.out.println("What generation do you want the pokemon to come from (this is a range so if you put 2 it will give gens 1-2)");
			   gen = reader.nextInt();
		   }
		   int maxRange = 0;
		   if(gen == 1)
		   {
			   maxRange = 151;
		   }
		   if(gen == 2)
		   {
			   maxRange = 251;
		   }
		   if(gen == 3)
		   {
			   maxRange = 386;
		   }
		   if(gen == 4)
		   {
			   maxRange = 493;
		   }
		   if(gen == 5)
		   {
			   maxRange = 649;
		   }
		   if(gen == 6)
		   {
			   maxRange = 721;
		   }
		   if(gen == 7)
		   {
			   maxRange = 807;
		   }
		   
		   
		   
		   //actual game
		   int points = 0;
		   int timeToPass = 20000; //20 seconds
		   boolean gameActive = true;
		   Random rng = new Random();
		   while(gameActive)
		   {
			   Scanner inputStream2 = null;
			   try{
			          inputStream2 = new Scanner (new FileInputStream("pokemon.txt"));
			       }
			       catch (FileNotFoundException e)
			       {
			         System.exit(0);
			          
			       }
			   // get pokemon from file
			   String pokemon = "";
			   int pokemonNum = rng.nextInt(maxRange)+1;
			   
			   for(int i=0; i<pokemonNum; i++)
			   {
				   pokemon = inputStream2.nextLine();
			   }
			  
			   
			   reader.nextLine(); //catch enter keystroke
			   long startTime = System.currentTimeMillis();
			   System.out.println("What pokemon is pokedex number: " + pokemonNum + " and this pokemon's name starts with: " + pokemon.substring(0,1) + " and it ends with: " + pokemon.substring(pokemon.length()-1) + " you have " + (double)timeToPass/1000 + " seconds");
			   String guess = reader.nextLine();
			   
			   long endTime = System.currentTimeMillis();
			   
			   long time = endTime - startTime;
			   
			   if(guess.equalsIgnoreCase(pokemon) && time>timeToPass)
			   {
				   System.out.println("You got the pokemon, but the guess was in " + (double)time/1000 + " seconds and the time to guess was in " + (double)timeToPass/1000 + " seconds");
			   }
			   if(guess.equalsIgnoreCase(pokemon) && time<=timeToPass)
			   {
				   points++;
				   System.out.println("Guess was in " + (double)time/1000 + " seconds and the time to guess was in " + (double)timeToPass/1000 + " seconds");   
				   if(timeToPass>5000)
					   timeToPass-=1000; //1 second
				   System.out.println("Press Enter Key");
			   }
			  
			   else
			   {
				   gameActive = false;
				   System.out.println("The pokemon is: " + pokemon);
				   if(points!=1)
					   System.out.println("You got " + points + " points");
				   else
					   System.out.println("You got " + points + " point");
			   }
				  
		   }
		  
	}

}
