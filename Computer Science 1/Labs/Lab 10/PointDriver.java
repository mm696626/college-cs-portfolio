public class PointDriver
{
   public static void main(String[] args)
   {
      Point p1 = new Point();
      Point p2 = new Point(7,2,"Red");
      Point p3 = new Point(p2);
      System.out.println("The x cordinate of p1 is: " + p1.getX());
      System.out.println("The y cordinate of p2 is: " + p2.getX());
      System.out.println("The color of p3 is: " + p3.getColor()); 
      p2.setX(2);
      System.out.println("p2 X cordinate set to " + p2.getX());
      p3.setY(8);
      System.out.println("p3 Y cordinate set to " + p3.getY());
      p1.setColor("Blue");   
      System.out.println("p1 color set to " + p1.getColor());  
      System.out.println("The area of point 1 is " + p1.area());
      p1.translate(2,5);
      System.out.println(p1);
   }
}