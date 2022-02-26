/**
 * This is a class that extends Policeman, but creates a new object, a Patrolman
 * @author Matthew McCullough
 * @date 2/14/2019
 */
public class Patrolman extends Policeman{
	static double basePatrolPay = 3600;
	public Patrolman()  /**default constructor*/
	{
		super();
	}
	/**
	 * Constructor with parameters
	 * @param f represents first name of officer
	 * @param l represents last name of officer
	 * @param y represents how long they have been in service
	 */
	public Patrolman(String f, String l, int y)
	{
		super(f,l,y);
	}
	/**
	 * @return returns the earnings of the Patrolman
	 */
	public double earnings() {
		return .85*basePatrolPay + .06 * Math.sqrt(basePatrolPay) * getYearsOfService();
	}

	/**
	 * @return returns the benefit level of the Patrolman
	 */
	public int benefitLevel() {
		return 1;
	}
	/**
	 * gives some general information about the patrolman
	 * @return returns a String of the information about the Patrolman (uses Policeman's toString)
	 */
	public String toString()
	{
		return(this.getClass().getSimpleName() + super.toString() + "\n" + "Earnings: " + String.format("%.2f", this.earnings()) + "\n" + "Benefit Level: " + this.benefitLevel());
	}

}
