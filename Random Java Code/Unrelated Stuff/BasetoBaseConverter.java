import java.util.Scanner;
import java.util.ArrayList;
public class BasetoBaseConverter {

	public static void main(String[] args) 
	{
		String num = "";
		boolean invalidNumber = false;
		Scanner reader = new Scanner(System.in);
		System.out.println("What number do you want to convert?");
		int number = reader.nextInt();
		System.out.println("What base is the number do you want to convert?");
		int numbase = reader.nextInt();
		System.out.println("What base do you want to convert to?");
		int base = reader.nextInt();
		ArrayList<Integer> digits = new ArrayList<Integer>();
		if(numbase!=10)
		{
			int temp = number;
			while (temp > 0) {
			    digits.add(temp % 10);
			    temp = temp / 10;
			}
			for(int i=0; i<digits.size(); i++)
			{
				if(digits.get(i)>=numbase)
				{
					invalidNumber = true;
					break;
				}
				if(i==0)
					number = (int) (digits.get(i) * Math.pow(numbase, i));
				else
					number += (int) (digits.get(i) * Math.pow(numbase, i));
			}
		}
		
		
		if(invalidNumber == true)
		{
			System.out.println("Invalid number, conversion is not done");
		}
		else
		{
			String number2 = convertToBase(num, number, base);
			StringBuilder s = new StringBuilder();
			s.append(number2);
			System.out.println("Your converted number is: " + s.reverse());
		}
		
	}

	
	public static String convertToBase(String s, int n, int b)
	{
		
		if((n/b)<=0)
		{
			return s + (n%b);
		}
		
		else
		{
			s += (n%b);
			return convertToBase(s, (n/b), b);
		}
	}
}