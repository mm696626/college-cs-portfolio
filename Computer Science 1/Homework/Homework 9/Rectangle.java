public class Rectangle
{
   private int length;
   private int width;
   public Rectangle()
   {
      length = 1;
      width = 1;
   }
   public Rectangle(int l, int w)
   {
      length = l;
      width = w;
   }
   public Rectangle(Rectangle r)
   {
      length = r.length;
      width = r.width;
   }  
   public void setLength(int l)
   {
      length = l;
   }
   public void setWidth(int w)
   {
      width = w;
   }
   public int getLength()
   {
      return length;
   }
   public int getWidth()
   {
      return width;
   }
   public int area()
   {
      return length * width;
   }
   public Rectangle merge(Rectangle r)
   {
      return new Rectangle((length+r.length),(width+r.width));
   }
   public String toString()
   {
      return("Rectangle Length: " + length + " Rectangle Width: " + width);
   }
   public static int totalArea(Rectangle[] r)
   {
      int total = 0;
      for(int x=0; x<r.length; x++)
      {
         total+= r[x].area();
      }
      return total;
   }


}