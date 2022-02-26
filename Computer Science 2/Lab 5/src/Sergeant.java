/**
 * This is a class that extends Patrolman, but creates a new object, a Sergeant
 * @author Matthew McCullough
 * @date 2/14/2019
 */
public class Sergeant extends Patrolman{
	static double baseSgtPay = 4700;
	public Sergeant()
	{
		super();
	}
	/**
	 * Constructor with parameters
	 * @param f represents first name of officer
	 * @param l represents last name of officer
	 * @param y represents how long they have been in service
	 */
	public Sergeant(String f, String l, int y)
	{
		super(f,l,y);
	}
	/**
	 * @return returns the earnings of the Sergeant
	 */
	public double earnings() {
		return .82*baseSgtPay + 1.2*Math.sqrt(baseSgtPay) * getYearsOfService();
	}

	/**
	 * @return returns the benefit level of the Sergeant
	 */
	public int benefitLevel() {
		return super.benefitLevel()+2;
	}
}
