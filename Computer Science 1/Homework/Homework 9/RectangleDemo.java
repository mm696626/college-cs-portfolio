public class RectangleDemo
{
   public static void main(String[] args)
   {
      Rectangle r = new Rectangle();
      Rectangle r2 = new Rectangle(5,8);
      Rectangle r3 = new Rectangle(r2);
      Rectangle[] rectangles = new Rectangle[4];
      System.out.println("The length of r is " + r.getLength());
      r3.setWidth(3);
      System.out.println("The width of r3 is " + r3.getWidth());
      r2.setLength(2);
      System.out.println("The new length of r2 is " + r2.getLength());
      System.out.println("The area of r2 is " + r2.area());
      rectangles[0] = r;
      rectangles[1] = r2;
      rectangles[2] = r3;
      Rectangle r4 = r2.merge(r3);
      System.out.println(r4);
      rectangles[3] = r4;
      System.out.println(r4); //toString() test
      System.out.println("The total area of the 4 rectangles is " + Rectangle.totalArea(rectangles));
     
   }

}