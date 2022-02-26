import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class PokemonRandomGenerator {

	public static void main(String[] args)
	{
		Random rng = new Random();
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
	   
	   
	   System.out.println("How many random pokemon?");
	   int pokemonToGenerate = reader.nextInt(); //number of random pokemon
	   
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
	   
	   int pokemonGenerated = 0;
	   while(pokemonGenerated<pokemonToGenerate)
	   {
		   Scanner inputStream2 = null;
		   try{
		          inputStream2 = new Scanner (new FileInputStream("pokemon.txt"));
		       }
		       catch (FileNotFoundException e)
		       {
		         System.exit(0);
		          
		       }
		   String pokemon = "";
		   int pokemonNum = rng.nextInt(maxRange)+1;
		   for(int i=0; i<pokemonNum; i++)
		   {
			   pokemon = inputStream2.nextLine();
		   }
		   System.out.println(pokemon);
		   inputStream2.close();
		   pokemonGenerated++;
	   }
	}
}
