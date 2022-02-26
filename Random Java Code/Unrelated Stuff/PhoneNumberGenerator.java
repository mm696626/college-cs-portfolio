import java.util.Random;
public class PhoneNumberGenerator {

	public static void main(String[] args)
	{
		Random rng = new Random();
		int numbersToGenerate = 12;
		
		for(int i=0; i<numbersToGenerate; i++)
		{
			String number = "";
			for(int j=0; j<10; j++)
			{
				number += rng.nextInt(10);
			}
			
			System.out.println(number.substring(0,3) + "-" + number.substring(3, 6) + "-" + number.substring(6));

		}
		
	}
}
