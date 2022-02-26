import java.util.Random;
public class GuessCombo {

	public static void main(String[] args) {
		int combo = 0;
		Random rng = new Random();
		combo = rng.nextInt(10000);
		if(combo<=999)
			combo+=1000;
		String comboGuess = "";
		String correctCombo = Integer.toString(combo);
		guessCombo(0, comboGuess, correctCombo, "", "", "", "", 0, 0,0,0);
		
	}
	
	public static void guessCombo(int guessCount, String guess, String combo, String d1, String d2, String d3, String d4, int c1, int c2, int c3, int c4)
	{
			Random rng = new Random();
			if(c1!=1)
				d1 = Integer.toString(rng.nextInt(9)+1);
			if(c2!=1)
				d2 = Integer.toString(rng.nextInt(10));
			if(c3!=1)
				d3 = Integer.toString(rng.nextInt(10));
			if(c4!=1)
				d4 = Integer.toString(rng.nextInt(10));
			
			
			if(d1.equals(combo.substring(0,1)) && c1!=1)
				c1 = 1;
			if(d2.equals(combo.substring(1,2))  && c2!=1)
				c2 = 1;
			if(d3.equals(combo.substring(2,3))  && c3!=1)
				c3 = 1;
			if(d4.equals(combo.substring(3))  && c4!=1)
				c4 = 1;
			guess = d1+d2+d3+d4;
			System.out.println("Guess this interval was " + guess + " while the combo is this: " + combo);
			if(guess.equals(combo))
			{
				guessCount++;
				System.out.println("Combo Guessed in " + guessCount + " guesses");
			}
			else
			{
				guessCount++;
				guessCombo(guessCount,guess,combo, d1, d2, d3, d4, c1, c2, c3, c4);
			}
			
	}
}
