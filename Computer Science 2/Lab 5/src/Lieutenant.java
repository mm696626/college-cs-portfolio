/**
 * This is a class that extends Sergeant, but creates a new object, a Lieutenant
 * @author Matthew McCullough
 * @date 2/14/2019
 */
public class Lieutenant extends Sergeant{
	static double baseLieutenantPay = 5900;
	public Lieutenant()
	{
		super();
	}
	/**
	 * Constructor with parameters
	 * @param f represents first name of officer
	 * @param l represents last name of officer
	 * @param y represents how long they have been in service
	 */
	public Lieutenant(String f, String l, int y)
	{
		super(f,l,y);
	}
	/**
	 * @return returns the earnings of the Sergeant
	 */
	public double earnings() {
		return .8*baseLieutenantPay + 1.3*Math.sqrt(baseLieutenantPay) * getYearsOfService();
	}

	/**
	 * @return returns the benefit level of the Lieutenant
	 */
	public int benefitLevel() {
		return super.benefitLevel()+3;
	}
	

}
