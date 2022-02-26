/**
 * This creates a Point class
 * @author Matthew McCullough
 * @date 2/7/2019
 */


public class Point /**default constructor*/
	{ 
	private int x;
	private int y;
	private String color;
	public static int countPoint;
	public Point()
	{
		x=0;
		y=0;
		color="black";
		countPoint++;
	}

	/**constructor with 3 parameters
	 * @param x represents the value of x to be attached to the new object
	 * @param y represents the value of y to be attached to the new object
	 * @param c represents the value of color to be attached to the new object
	 */
	public Point(int x, int y, String c) 
	{
		this.x=x;
		this.y=y;
		color = c;
		countPoint++;
	}
	/**
	 * gets x of the calling object
	 * @return returns the value of x of the calling object
	 */
	public int getX()
	{
		return x;
	}
	/**
	 * gets y of the calling object
	 * @return returns the value of y of the calling object
	 */
	public int getY()
	{
		return y;
	}
	/**
	 * gets the color of the calling object
	 * @return returns the value of color of the calling object
	 */
	public String getColor()
	{
		return color;
	}
	/**
	 * sets x of the calling object
	 * @param x (number to set x to of the calling object)
	 */
	public void setX(int x)
	{
		this.x=x;
	}
	/**
	 * sets y of the calling object
	 * @param y (number to set y to of the calling object)
	 */
	public void setY(int y)
	{
		this.y=y;
	}
	/**
	 * sets the color of the calling object
	 * @param c (number to set color to of the calling object)
	 */
	public void setColor(String c)
	{
		color = c;
	}
	/**
	 * changes the x and y coordinates of the Point by an amount determined by parameters
	 * @param dx (number to change x of the calling object by)
	 * @param dy  (number to change y of the calling object by)
	 */
	public void translate(int dx, int dy)
	{
		x+=dx;
		y+=dy;
	}
	/**
	 * Prints out general information about the Point
	 * @return returns the information about the Point
	 */
	public String toString()
	{
		return("(x,y) : " + x + "," + y +  " Color: " + color);
	}
	/**
	 * Checks if two points are the same
	 * @param Point other is the other point to be checked
	 * @return returns true if equal, false if not
	 */
	public boolean equals(Point other)
	{
		if(x==other.x && y==other.y)
			return true;
		else
			return false;
	}
}
