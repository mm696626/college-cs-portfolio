public class Triangle
{
   private int side1;
   private int side2;
   private int side3;
   public Triangle()
   {
      side1=0;
      side2=0;
      side3=0;
   }
   public int getSide1()
   {
      return side1;
   }
   public int getSide2()
   {
      return side2;
   }
   public int getSide3()
   {
      return side3;
   }
   public void setSide1(int s1)
   {
      side1 = s1;
   }
   public void setSide2(int s2)
   {
      side2 = s2;
   }
   public void setSide3(int s3)
   {
      side3 = s3;
   }
   public String getType()
   {
      if ((side1==side2)&&(side1==side3))
         return "equilateral" ;
      if (side1==side2)
         return "isosceles" ;
      if (side2==side3)
         return "isosceles" ;
      if (side1==side3)
         return "isosceles" ;
      if ((side1!=side2)&&(side1!=side3))
         return "scalene" ;
      else
         return null;
   }
   public int getPerim()
   {
      return(side1+side2+side3);
   }
}