/**
 * @author Matthew McCullough
 * @date 1/27/19
 * This class tests the various methods and constructors used by the Shoe object
 */
import java.util.Scanner;
public class YouveGotShoes {

	public static void main(String[] args) 
	{
		/**This scanner object allows input from the user when nescessary*/
		Scanner reader = new Scanner(System.in);
		/**The Shoe objects that are used to help test*/
		Shoe s1 = new Shoe("Nike", "Air Force", 50, 920286, 40);
		Shoe s2 = new Shoe("Reebok", "Classics", 100, 639244, 40);
		Shoe s3 = new Shoe("Asics", "GEL-Nimbus", 40, 290569, 40);
		System.out.println("What is the price of the fourth shoe?");
		Shoe s4 = new Shoe("Nike", "Air Jordan", reader.nextDouble(), 700559);
		System.out.println("Shoe info before changes");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		s4.like();
		s3.like(5);
		s2.like(-1);
		s1.setPrice(29.99);
		s2.setPrice(s2.getPrice()*.8);
		s3.setPrice(s3.getPrice()*.8);
		s4.setPrice(s4.getPrice()*.8);
		
		System.out.println("After changes");
		System.out.println();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println("Summary");
		System.out.println("Total price : " + (s1.getPrice() + s2.getPrice() + s3.getPrice() + s4.getPrice()));
		double averageLikes = (double)(s1.getLikes() + s2.getLikes() + s3.getLikes() + s4.getLikes())/4;
		System.out.println("Average likes " + averageLikes);
	}
	/*Sample output
	 * What is the price of the fourth shoe?
	59.99
	Shoe info before changes
	Air Force by Nike , SKU: 920286 $ 50.0 40 Likes
	Classics by Reebok , SKU: 639244 $ 100.0 40 Likes
	GEL-Nimbus by Asics , SKU: 290569 $ 40.0 40 Likes
	Air Jordan by Nike , SKU: 700559 $ 59.99 0 Likes
	After changes
	
	Air Force by Nike , SKU: 920286 $ 29.99 40 Likes
	Classics by Reebok , SKU: 639244 $ 80.0 39 Likes
	GEL-Nimbus by Asics , SKU: 290569 $ 32.0 45 Likes
	Air Jordan by Nike , SKU: 700559 $ 47.992000000000004 1 Likes
	Summary
	Total price : 189.98200000000003
	Average likes 31.25

	 */
}
