/**
 * This creates a Sphere class and is the child of the Circle class
 * @author Matthew McCullough
 * @date 2/7/2019
 */
public class Sphere extends Circle 
{
	public Sphere() /**default constructor*/
	{
		super();
	}
	/**
	 * constructor with 4 parameters
	 * uses super to access Circle constructor (x, y, color, radius) uses parameters x, y , c, and r
	 * @param x represents the value of x to be attached to the new object
	 * @param y represents the value of y to be attached to the new object
	 * @param c represents the value of color to be attached to the new object
	 * @param r represents the value of the radius to be attached to the new object
	 */
	public Sphere(int x, int y, String c, int r)
	{
		super(x,y,c,r);
	}
	/**
	 * calculates the area of the sphere
	 * @return returns the area of the sphere
	 */
	public double calculateArea()
	{
		return 4*Math.PI*Math.pow(getRadius(), 2.0);
	}
}
