/**
 * 
 * @author Matthew McCullough
 * @date 1/27/19
 * This class defines a new object, a Shoe in which the 
 * manufacturer, name, price, SKU number, and likes are being accounted for
 */
public class Shoe 
{

	private String manufacturer;
	private String name;
	private double price;
	private int SKU;
	private int likes;
	/**constructor that takes the parameters m, n, p, s, and l which represent the 5 characteristics(instance variables)*/
	public Shoe(String m, String n, double p, int s, int l)
	{
		manufacturer = m;
		name = n;
		price =p;
		SKU = s;
		likes = l;
	}
	/**constructor that takes the parameters m, n, p, s, but dosen't take a parameter for the number of likes, but instead sets it to 0*/
	public Shoe(String m, String n, double p, int s)
	{
		manufacturer = m;
		name = n;
		price =p;
		SKU = s;
		likes=0;
	}
	 /**
	    * @return returns a String of the objects(the shoe) attributes 
	    */
	public String toString()
	{
		return(name + " by " + manufacturer + " , " + "SKU: " + SKU + " $ " + price +  " " + likes + " Likes");
	}
	/**
	    * This method sets the price of the calling object
	    * @param p is the parameter (double) in which the objects price is set to
	    */
	public void setPrice(double p)
	{
		price = p;
	}
	/**
	    * This method gets the price of the calling object
	    * @return returns the price of the calling object
	    */
	public double getPrice()
	{
		return price;
	}
	/**
	    * This method gets the number of likes of the calling object
	    * @return returns the number of likes of the calling object
	    */
	public int getLikes()
	{
		return likes;
	}
	/**
	    * This method increases the number of likes of the calling object by 1
	    */
	public void like()
	{
		likes++;
	}
	/**
	    * This method increases the number of likes of the calling object by a amount defined by the parameter
	    * @param l is the number of likes to increase/decrease by
	    */
	public void like(int l)
	{
		likes+=l;
	}
	
}
