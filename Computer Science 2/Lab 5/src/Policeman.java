/**
 * This is an abstract class outlining the details of a Policeman, use this as a base for other classes
 * @author Matthew McCullough
 * @date 2/14/2019
 */
public abstract class Policeman {
	private String firstName;
	private String lastName;
	private int yearsOfService;
	public Policeman() /**default constructor*/
	{
		firstName = "John";
		lastName = "Cena";
		yearsOfService = 12;
	}
	/**
	 * Constructor with parameters
	 * @param f represents first name of officer
	 * @param l represents last name of officer
	 * @param y represents how long they have been in service
	 */
	public Policeman(String f, String l, int y) 
	{
		firstName = f;
		lastName = l;
		yearsOfService = y;
	}
	/**
	 * @return gets the first name of the police officer
	 */
	public String getFirstName()
	{
		return firstName;
	}
	/**
	 * @return gets the last name of the police officer
	 */
	public String getLastName()
	{
		return lastName;
	}
	/**
	 * @return gets the years of service of the police officer
	 */
	public int getYearsOfService()
	{
		return yearsOfService;
	}
	/**
	 * sets the first name of the police officer
	 * @param f what the first name will be set to
	 */
	public void setFirstName(String f)
	{
		firstName = f;
	}
	/**
	 * sets the last name of the police officer
	 * @param l what the last name will be set to
	 */
	public void setLastName(String l)
	{
		lastName = l;
	}
	/**
	 * sets the number of years of service of the police officer
	 * @param y what the number of years will be set to
	 */
	public void setYearsOfService(int y)
	{
		yearsOfService = y;
	}
	/**
	 * gives some general information about the police officer or child classes (which will be using this)
	 * @return returns a String of the information about the Policeman
	 */
	public String toString()
	{
		return(" " + firstName + " " + lastName + "\n" + "Years of Service: " + yearsOfService);
	}
	public abstract double earnings(); /** abstract method which child classes will inherit detailing the earnings they get*/
	public abstract int benefitLevel(); /** abstract method which child classes will inherit detailing their benefit level*/
}
