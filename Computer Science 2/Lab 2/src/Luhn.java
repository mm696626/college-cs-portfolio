/**
This program checks if a 11 digit credit card is valid through the Luhn algorithm
@author  Matt McCullough 
@date 1/24/19
*/
import java.util.Scanner;
import java.util.Arrays;
public class Luhn {
	/**
	 * This is the main method where all of the other methods will be ran and tested
	 * 
	 */
	public static void main(String[] args) 
	{
		/**Array of 11 integers representing the digits of the card number*/
		int[] creditCard = new int[11];
		Scanner reader = new Scanner(System.in);
		for(int i=0; i<creditCard.length; i++)
		{
			System.out.print("Enter a number from 0 to 9: ");
			creditCard[i] = reader.nextInt();
			while(creditCard[i]<0 || creditCard[i]>9)
			{
				System.out.print("Enter a number from 0 to 9: ");
				creditCard[i] = reader.nextInt();
			}
		}
		System.out.println("Credit card digits are : " + Arrays.toString(creditCard));
		System.out.println("Validity of credit card : " + valid(creditCard));
		
	}
	/**
	 * @param a takes in an integer array representing the digits of a credit card number
	 * @return true if a valid card, false if not
	 */
	public static boolean valid(int[] a)
	{
		for(int i=0; i<a.length; i++)
		{
			if(i%2!=0)
			{
				a[i]*=2;
				if(a[i]>9)
				{
					int firstdigit= a[i]/10;
					int seconddigit=a[i]%10;
					a[i] = firstdigit + seconddigit;
				}
			}
		}
		int sum=0;
		for(int i=0; i<a.length; i++)
		{
			sum+=a[i];
		}
		if(sum%10==0)
			return true;
		else
			return false;
	}
	/*
	 * Sample output:
	 * Enter a number from 0 to 9: 7
	 * Enter a number from 0 to 9: 2
     * Enter a number from 0 to 9: 2
     * Enter a number from 0 to 9: 3
     * Enter a number from 0 to 9: 4
     * Enter a number from 0 to 9: 1 
     * Enter a number from 0 to 9: 2
     * Enter a number from 0 to 9: 3
     * Enter a number from 0 to 9: 5
     * Enter a number from 0 to 9: 2
     * Enter a number from 0 to 9: 8
     * Credit card digits are : [7, 2, 2, 3, 4, 1, 2, 3, 5, 2, 8]
     * Validity of credit card : true
	 */
}
