import java.util.Random;
import java.util.Scanner;
public class RandomCharacters {

	public static void main(String[] args) 
	{
		Random rng = new Random();
		Scanner reader = new Scanner(System.in);
		String output="";
		int randomCharacters = 0;
		System.out.println("How many characters is your word");
		while(randomCharacters<=0 || randomCharacters>2000)
		{
			randomCharacters = reader.nextInt();
		}
		
		
		for(int i=0; i<randomCharacters; i++)
		{
			int random = rng.nextInt(26)+1;
			if(random == 1)
			{
				output+="a";
			}
			if(random == 2)
			{
				output+="b";
			}
			if(random == 3)
			{
				output+="c";
			}
			if(random == 4)
			{
				output+="d";
			}
			if(random == 5)
			{
				output+="e";
			}
			if(random == 6)
			{
				output+="f";
			}
			if(random == 7)
			{
				output+="g";
			}
			if(random == 8)
			{
				output+="h";
			}
			if(random == 9)
			{
				output+="i";
			}
			if(random == 10)
			{
				output+="j";
			}
			if(random == 11)
			{
				output+="k";
			}
			if(random == 12)
			{
				output+="l";
			}
			if(random == 13)
			{
				output+="m";
			}
			if(random == 14)
			{
				output+="n";
			}
			if(random == 15)
			{
				output+="o";
			}
			if(random == 16)
			{
				output+="p";
			}
			if(random == 17)
			{
				output+="q";
			}
			if(random == 18)
			{
				output+="r";
			}
			if(random == 19)
			{
				output+="s";
			}
			if(random == 20)
			{
				output+="t";
			}
			if(random == 21)
			{
				output+="u";
			}
			if(random == 22)
			{
				output+="v";
			}
			if(random == 23)
			{
				output+="w";
			}
			
			if(random == 24)
			{
				output+="x";
			}
			if(random == 25)
			{
				output+="y";
			}
			if(random == 26)
			{
				output+="z";
			}
		}
		
		System.out.println(output);
	}

}
