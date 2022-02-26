import java.util.Scanner;
public class Driver {

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		Point p1 = new Point();
		System.out.println("Enter a color, followed 2 another integers");
		String c = reader.nextLine();
		Point p2 = new Point(reader.nextInt(),reader.nextInt(), c);
		p1.setY(4);
		System.out.println("The y coordinate of p1 is : " + p1.getY());
		
		p1.setX(3);
		System.out.println("The x coordinate of p1 is : " + p1.getX());
		
		
		if(p1.equals(p2))
			System.out.println("Points are equal");
		else
			System.out.println("They are not equal");
		p1.setColor("blue");
		System.out.println("The color of p1 is : " + p1.getColor());
		
		System.out.println(p2.toString());
		System.out.println("Before translate");
		System.out.println(p1.toString());
		p1.translate(5, 2);
		
		System.out.println("After translate");
		System.out.println(p1.toString());
		System.out.println(Point.countPoint + " points have been created");
		
		Circle c1 = new Circle();
		c1.setX(7);
		c1.setY(6);
		c1.setColor("orange");
		c1.setRadius(5);
		System.out.println(c1.toString());
		System.out.println("Enter an integer for the radius of c2");
		Circle c2 = new Circle(p2.getX(), p2.getY(), p2.getColor(), reader.nextInt());
		System.out.println(c2.toString());
		if(c1.equals(c2))
			System.out.println("Circles are equal");
		else
			System.out.println("They are not equal");
		Circle[] circleArray = new Circle[10];
		for(int i=0; i<circleArray.length; i++)
		{
			circleArray[i] = new Circle(i,i+5,"BLACK", i*10);
			System.out.println("CircleArray[" + (i+1) + "] " + circleArray[i].toString());
		}
		System.out.println("Array after multiplying radii by 20");
		for(int i=0; i<circleArray.length; i++)
		{
			circleArray[i].scale(20);
			System.out.println("CircleArray[" + (i+1) + "] " + circleArray[i].toString());
		}
		Circle c3 = c1.merge(c2);
		System.out.println(c3.toString());
		Sphere s1 = new Sphere(6, 5, "purple", 6);
		System.out.println("The area of s1 is: " + s1.calculateArea());
		/*
		 * Sample output:
		 * 
		 *  Enter a color, followed 2 another integers
			pink
			6
			4
			The y coordinate of p1 is : 4
			The x coordinate of p1 is : 3
			They are not equal
			The color of p1 is : blue
			(x,y) : 6,4 Color: pink
			Before translate
			(x,y) : 3,4 Color: blue
			After translate
			(x,y) : 8,6 Color: blue
			2 points have been created
			(x,y) : 7,6 Color: orange radius: 5
			Enter an integer for the radius of c2
			7
			(x,y) : 6,4 Color: pink radius: 7
			They are not equal
			CircleArray[1] (x,y) : 0,5 Color: BLACK radius: 0
			CircleArray[2] (x,y) : 1,6 Color: BLACK radius: 10
			CircleArray[3] (x,y) : 2,7 Color: BLACK radius: 20
			CircleArray[4] (x,y) : 3,8 Color: BLACK radius: 30
			CircleArray[5] (x,y) : 4,9 Color: BLACK radius: 40
			CircleArray[6] (x,y) : 5,10 Color: BLACK radius: 50
			CircleArray[7] (x,y) : 6,11 Color: BLACK radius: 60
			CircleArray[8] (x,y) : 7,12 Color: BLACK radius: 70
			CircleArray[9] (x,y) : 8,13 Color: BLACK radius: 80
			CircleArray[10] (x,y) : 9,14 Color: BLACK radius: 90
			Array after multiplying radii by 20
			CircleArray[1] (x,y) : 0,5 Color: BLACK radius: 0
			CircleArray[2] (x,y) : 1,6 Color: BLACK radius: 200
			CircleArray[3] (x,y) : 2,7 Color: BLACK radius: 400
			CircleArray[4] (x,y) : 3,8 Color: BLACK radius: 600
			CircleArray[5] (x,y) : 4,9 Color: BLACK radius: 800
			CircleArray[6] (x,y) : 5,10 Color: BLACK radius: 1000
			CircleArray[7] (x,y) : 6,11 Color: BLACK radius: 1200
			CircleArray[8] (x,y) : 7,12 Color: BLACK radius: 1400
			CircleArray[9] (x,y) : 8,13 Color: BLACK radius: 1600
			CircleArray[10] (x,y) : 9,14 Color: BLACK radius: 1800
			(x,y) : 6,4 Color: pink radius: 12
			The area of s1 is: 452.3893421169302
		 */
	}

}
