/**
 * @author Matthew McCullough
 * @date 3/21/2019
 * This is a Passenger class for use to calculate Titanic statistics
 */

public class Passenger {
	private int status;
	private boolean child;
	private String sex;
	private boolean survivor;
	/**
	 * Constructor
	 * @param s status of passenger (an integer: 1, 2, 3, or 4, representing 1st, 2nd, 3rd class or crew)
	 * @param c if the passenger is a child
	 * @param se sex of the passenger (it is binary)
	 * @param su if they survived or not
	 */
	public Passenger(int s, boolean c, String se, boolean su)
	{	
		try{
			status = s;
		    if (status < 1 || status > 4)
		        throw new OutOfRangeException("ERROR");
		}
		catch (OutOfRangeException o)
		{
		    System.out.println(o + " Your status is less than 1 or greater than 4");   
		    status=1;
		}
		child = c;
		try{
			sex = se;
		    if (!((sex.equals("male")) || (sex.equals("female"))))
		        throw new OutOfRangeException("ERROR");
		}
		catch (OutOfRangeException o)
		{
		    System.out.println(o + " the sex is not female or male");   
		    sex = "male";
		}
		survivor = su;
	}
	/**
	 * gets status of passenger
	 * @return returns status
	 */
	public int getStatus()
	{
		return status;
	}
	/**
	 * gets if the passenger is a child
	 * @return boolean represents if they are a child
	 */
	public boolean getChild()
	{
		return child;
	}
	/**
	 * gets sex of the passenger
	 * @return returns the sex of the passenger
	 */
	public String getSex()
	{
		return sex;
	}
	/**
	 * gets survival status of the passenger
	 * @return if the passenger survived or not
	 */
	public boolean getSurvivor()
	{
		return survivor;
	}
	/**
	 * sets status to an integer
	 * @param s what to set status to
	 */
	public void setStatus(int s)
	{
		status = s;
	}
	/**
	 * sets child to a boolean
	 * @param c what to set child to
	 */
	public void setChild(boolean c)
	{
		child = c;
	}
	/**
	 * sets sex to a String
	 * @param s what to set sex to
	 */
	public void setSex(String s)
	{
		sex = s;
	}
	/**
	 * sets survivor to an boolean
	 * @param s what to set survivor to
	 */
	public void setSurvivor(boolean s)
	{
		survivor = s;
	}
	/**
	 * prints general information
	 * @return returns general information about the passenger
	 */
	public String toString()
	{
		return("Status: " + status + " Child: " + child + " Sex: " + sex + " Survivor: " + survivor);
	}
	
}
