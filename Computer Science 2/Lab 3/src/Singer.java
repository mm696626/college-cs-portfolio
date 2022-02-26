/**
 * This class is a class that defines a singer (by first and last name)
 * @author Matthew McCullough
 * @date 1/31/2019
 */
import java.util.Scanner;
public class Singer 
{
	Scanner reader = new Scanner(System.in);
	private String fName; /**represents the singers first name*/
	private String lName; /**represents the singers last name*/
	static int countSinger; /**counts the number of singers that were created*/
	/**default constructor*/
	public Singer()
	{
		System.out.println("What is the singers first name");
		fName = reader.next();
		System.out.println("What is the singers last name");
		lName = reader.next();
		countSinger++;
	}
	/**constructor with parameters
	 * @param fn (represents a String to be the singers first name)
	 * @param ln (represents a String to be the singers last name)
	 */
	public Singer(String fn, String ln)
	{
		fName = fn;
		lName = ln;
		countSinger++;
	}
	/**copy constructor
	 * @param s (represents the Singer to be copied)
	 */
	public Singer(Singer s)
	{
		fName = s.fName;
		lName = s.lName;
		countSinger++;
	}
	/**gets the FirstName of the calling object
	 * @return gets the first name of the singer
	 */
	public String getFirstName()
	{
		return fName;
	}
	/**sets the FirstName of the calling object
	 * @param fn - a String that will be the singers first name
	 */
	public void setFirstName(String fn)
	{
		fName=fn;
	}
	/**gets the LastName of the calling object
	 * @return gets the last name of the singer
	 */
	public String getLastName()
	{
		return lName;
	}
	/**sets the LastName of the calling object
	 * @param ln - a String that will be the singers last name
	 */
	public void setLastName(String ln)
	{
		lName = ln;
	}
	/**
	 * Prints out general information about the Singer
	 * @return returns the information about the singer
	 */
	public String toString()
	{
		return("Singer name is: " + fName + " " + lName);
	}
	/**
	 * Checks if two singers are the same
	 * @param Singer other is the other singer to be checked
	 * @return returns true if equal, false if not
	 */
	public boolean equals(Singer other)
	{
		if(fName.equals(other.fName) && lName.equals(other.lName))
			return true;
		else
			return false;
	}
}
