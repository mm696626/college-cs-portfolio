/**
 * This class defines a basketball player(type BBall)
 * @author Matthew McCullough
 * @date 3/6/2019
 */
public class BBall implements Comparable<BBall>
{	
	private int number;
	private String lastName;
	private String firstName;
	private int made2;
	private int att2;
	private int made3;
	private int att3;
	private int made1;
	private int att1;
	/**
	 * Constructor
	 * @param n number on jersey
	 * @param l last name
	 * @param f first name
	 * @param m2 how many two point shots were made
	 * @param a2 how many two point shots were attempted
	 * @param m3 how many three point shots were made
	 * @param a3 how many three point shots were attempted
	 * @param m1 how many foul shots were made
	 * @param a1 how many foul shots were attempted
	 */
	public BBall(int n, String l, String f, int m2, int a2, int m3, int a3, int m1, int a1)
	{
		number = n;
		lastName = l;
		firstName = f;
		made2 = m2;
		att2 = a2;
		try { /**exception handling if made2 is greater than att2*/
			if(made2>att2)
				throw new IllegalStatisticException("Made2 is greater than att2");
		}
		catch(IllegalStatisticException i) {
			System.out.println(i);
			made2=0;
			att2=0;
		}
		
		made3 = m3;
		att3 = a3;
		made1 = m1;
		att1 = a1;
	}
	/**
	 * gets number 
	 * @return returns number
	 */
	public int getNumber()
	{
		return number;
	}
	/**
	 * gets last name 
	 * @return returns last name
	 */
	public String getLastName()
	{
		return lastName;
	}
	/**
	 * gets first name
	 * @return returns first name
	 */
	public String getFirstName()
	{
		return firstName;
	}
	/**
	 * gets made2 
	 * @return returns made2
	 */
	public int getMade2()
	{
		return made2;
	}
	/**
	 * gets att2 
	 * @return returns att2
	 */
	public int getAtt2()
	{
		return att2;
	}
	/**
	 * gets made3 
	 * @return returns made3
	 */
	public int getMade3()
	{
		return made3;
	}
	/**
	 * gets att3 
	 * @return returns att3
	 */
	public int getAtt3()
	{
		return att3;
	}
	/**
	 * gets made1 
	 * @return returns made1
	 */
	public int getMade1()
	{
		return made1;
	}
	/**
	 * gets att1 
	 * @return returns att1
	 */
	public int getAtt1()
	{
		return att1;
	}
	/**
	 * sets number to an integer
	 * @param n integer to set number to 
	 */
	public void setNumber(int n)
	{
		number=n;
	}
	/**
	 * sets last name to a String
	 * @param l String to set last name to 
	 */
	public void setLastName(String l)
	{
		lastName = l;
	}
	/**
	 * sets first name to a String
	 * @param f String to set first name to 
	 */
	public void setFirstName(String f)
	{
		firstName = f;
	}
	/**
	 * sets made2 to an integer
	 * @param m2 integer to set made2 to 
	 */
	public void setMade2(int m2)
	{
		made2 = m2;
	}
	/**
	 * sets att2 to an integer
	 * @param a2 integer to set att2 to 
	 */
	public void setAtt2(int a2)
	{
		att2 = a2;
	}
	/**
	 * sets made3 to an integer
	 * @param m3 integer to set made3 to 
	 */
	public void setMade3(int m3)
	{
		made3 = m3;
	}
	/**
	 * sets att3 to an integer
	 * @param a3 integer to set att3 to 
	 */
	public void setAtt3(int a3)
	{
		att3 = a3;
	}
	/**
	 * sets made1 to an integer
	 * @param m1 integer to set made1 to 
	 */
	public void setMade1(int m1)
	{
		made1 = m1;
	}
	/**
	 * sets att1 to an integer
	 * @param a1 integer to set att1 to 
	 */
	public void setAtt1(int a1)
	{
		att1 = a1;
	}
	/**
	 * prints general information about the basketball player
	 * @return returns a String with general information
	 */
	public String toString()
	{
		double made2percent;
		if(att2>0)
			made2percent=(double)made2/att2;
		else
			made2percent=0;
		
		double made3percent;
		if(att3>0)
			made3percent=(double)made3/att3;
		else
			made3percent=0;
		double made1percent;
		if(att1>0)
			made1percent=(double)made1/att1;
		else
			made1percent=0;
		return(firstName + " " + lastName + "\n Two point percent: " + made2percent + "\n Three point percent: " + made3percent + "\n Foul shot percent: " + made1percent);
	}
	/**
	 * Compares two BBall objects
	 * @return -1 if calling object made more baskets than other
	 * 			1 if calling object made less baskets
	 * 			0 if equal 
	 */
	public int compareTo(BBall other)
	{
		if(this.made2 + this.made3+this.made1 > other.made2+other.made3+other.made1)
		      return -1;
		else if(other.made2+other.made3+other.made1 > this.made2 + this.made3+this.made1)
			  return 1;
		else
			  return 0;
	}
	

	
	

	
	
}
