/**
 * @author Matthew McCullough
 * @date 3/28/2019
 * This program shows a bunch of recursive methods to do tasks like converting a number into binary
 */
public class Recursion {

	public static void main(String[] args) {
		 System.out.println(investmentValue(1000, .1, 1));
		 System.out.println(investmentValue(1000, .1, 2));
		 System.out.println(investmentValue(1000, .1, 3));
		 System.out.println(changePi("xpix"));
		 System.out.println(changePi("pipi"));
		 System.out.println(changePi("pip"));
		 System.out.println("Binary for 156 is: " + writeBinary(156));
		 System.out.println("Binary for 600 is: " + writeBinary(600));
		 System.out.println("Binary for 8000 is: " + writeBinary(8000));
		 System.out.println("Binary for 199 is: " + writeBinary(199));
		 System.out.println("Binary for 12 is: " + writeBinary(12));
		 System.out.println("Number of pins with 5 rows: " + numberOfPins(5));
		 System.out.println("Number of pins with 10 rows: " + numberOfPins(10));
		 System.out.println("Number of pins with 14 rows: " + numberOfPins(14));
		 System.out.println("Number of handshakes with 1 person: " + handShake(1));
		 System.out.println("Number of handshakes with 2 people: " + handShake(2));
		 System.out.println("Number of handshakes with 3 people: " + handShake(3));
		 System.out.println("Number of handshakes with 4 people: " + handShake(4));
		 System.out.println("Number of handshakes with 5 people: " + handShake(5));
		 
	}
	/**
	 * Calculates money with interest rate
	 * @param amount Amount of money
	 * @param interest interest rate per year (if you want 10 percent, enter .1)
	 * @param numYears Number of years
	 * @return
	 */
	public static  double investmentValue(double amount, double interest, int numYears)
	{
		if(numYears==0)
			return amount;
		else
			return investmentValue(amount*(1+interest), interest, numYears-1);
		
	}
	/**
	 * Changes all occurrences of pi in a string to 3.14
	 * @param str String to change
	 * @return returns changed string
	 */
	public static String changePi(String str)
	{
		if(str.length()==0 || str.length()==1)
			return str;
		else
		{
			if(str.charAt(0) == 'p' && str.charAt(1) == 'i')
			{
				return "3.14" + changePi(str.substring(2));
			}
			else
			{
				return "x" + changePi(str.substring(1));
			}
		}
	}
	/**
	 * Converts a number to binary
	 * @param num number to convert to binary
	 * @return returns the binary number as a String
	 */
	public static String writeBinary(int num) {

	    String binary = "";
	    

	    if (num<1)
	        return binary;
	    else
	    {
	    	if(num%2==0)
		    	binary="0";
		    else
		    	binary="1";
	    	return writeBinary(num/2) + binary;
	    }
	}
	/** 
	 * Calculates number of pins in a number of rows
	 * @param rows Number of rows of pins (pyramid, ex. think bowling)
	 * @return number of pins
	 */
	public static int numberOfPins(int rows)
	{	
		if(rows==0)
			return rows;
		else
		{
			return numberOfPins(rows-1) + rows;
		}
	}
	/**
	 * Calculates number of handshakes across a number of people
	 * @param n number of people
	 * @return number of handshakes
	 */
	public static int handShake(int n)
	{
		if(n==1)
			return 0;
		else
			return handShake(n-1) + (n-1);
		
	}
}
