public class Point
{
   private int x;
   private int y;
   private String color;
   public Point()
   {
      x = 0;
      y = 0;
      color = "black";
   }
   public Point(int x, int y, String c)
   {  
      this.x = x;
      this.y = y;
      color = c;
   }
   public Point(Point p)
   {
      x = p.x;
      y = p.y;
      color = p.color;
   }
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
   public String getColor()
   {
      return color;
   }
   public void setX(int x)
   {
      this.x = x;
   }
   public void setY(int y)
   {
      this.y = y;
   }
   public void setColor(String c)
   {
      color = c;
   }
   public int area()
   {
      return 0; //area of a point is 0
   }  
   public void translate(int dx, int dy)
   {
      x += dx;
      y += dy;
   }
   public String toString()
   {
      return("(x,y) : " + x + "," + y + " " + "Color: " + color); 
   }  
}