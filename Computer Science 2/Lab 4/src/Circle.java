/**
 * This creates a Circle class and is the child of the Point class
 * @author Matthew McCullough
 * @date 2/7/2019
 */
public class Circle extends Point
{
	private int radius;
	public Circle() /**default constructor*/
	{
		super();
		radius = 2;
	}
	/**
	 * constructor with 4 parameters
	 * uses super to access Point constructor (x, y, color) uses parameters x, y , and c
	 * @param x represents the value of x to be attached to the new object
	 * @param y represents the value of y to be attached to the new object
	 * @param c represents the value of color to be attached to the new object
	 * @param r represents the value of the radius to be attached to the new object
	 */
	public Circle(int x, int y, String c, int r) 
	{
		super(x,y,c);
		radius=r;
	}
	/**
	 * gets the radius of the calling object
	 * @return returns the value of the radius of the calling object
	 */
	public int getRadius()
	{
		return radius;
	}
	/**
	 * sets the radius of the calling object
	 * @param r (value to set the radius to) 
	 */
	public void setRadius(int r)
	{
		radius=r;
	}
	/**
	 * calculates the area of the circle
	 * @return returns the area of the circle
	 */
	public double calculateArea()
	{
		return Math.PI*Math.pow(radius, 2.0);
	}
	/**
	 * multiplies the radius by a scale given by parameters
	 * @param s the scale to multiply the radius by
	 */
	public void scale(int s)
	{
		radius*=s;
	}
	/**
	 * merges attributes of 2 circle (parameters x, y, and color, and the sum of the two objects radii)
	 * use method like this (calling object).merge((another circle))
	 * @param c is the other Circle to merge with 
	 * @return returns the new merged Circle
	 * 
	 */
	public Circle merge(Circle c)
	{
		return new Circle(c.getX(),c.getY(),c.getColor(),radius+c.radius);
	}
	/**
	 * Prints out general information about the Circle
	 * @return returns the information about the Circle
	 */
	public String toString()
	{
		return(super.toString() + " radius: " + radius);
	}
	/**
	 * Checks if two circles are the same
	 * @param Circle other is the other circle to be checked
	 * @return returns true if equal, false if not
	 */
	public boolean equals(Circle other)
	{
		if(super.equals(other) && radius == other.radius)
			return true;
		else
			return false;
	}
}
