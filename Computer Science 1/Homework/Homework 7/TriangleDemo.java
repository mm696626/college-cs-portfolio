public class TriangleDemo
{
   public static void main(String[] args)
   {
      Triangle tr1= new Triangle ();
      Triangle tr2= new Triangle ();
      tr1.setSide1(1);
      tr1.setSide2(4);
      tr1.setSide3(9);
      System.out.println("Triangle 1 : side 1 : " + tr1.getSide1() + " side 2: " +tr1.getSide2()+ " side3 : " + tr1.getSide3());
      tr2.setSide1(3);
      tr2.setSide2(3);
      tr2.setSide3(3);
      System.out.println("Triangle 2 : side 1 : " + tr2.getSide1() + " side 2: " +tr2.getSide2()+ " side3 : " + tr2.getSide3());
      String tr1Type = tr1.getType();
      if (tr1Type.equals("equilateral"))
         System.out.println("Triangle 1 is equilateral");
      else if(tr1Type.equals("isosceles"))
         System.out.println("Triangle 1 is isosceles");
      else if(tr1Type.equals("scalene"))
         System.out.println("Triangle 1 is scalene");
      String tr2Type = tr2.getType();
      if (tr2Type.equals("equilateral"))
         System.out.println("Triangle 2 is equilateral");
      else if(tr2Type.equals("isosceles"))
         System.out.println("Triangle 2 is isosceles");
      else if(tr2Type.equals("scalene"))
         System.out.println("Triangle 2 is scalene");      
      System.out.println("The perimeter of triangle 1 is " + tr1.getPerim());
      System.out.println("The perimeter of triangle 2 is " + tr2.getPerim());
      /*
      Triangle 1 : side 1 : 1 side 2: 4 side3 : 9
      Triangle 2 : side 1 : 3 side 2: 3 side3 : 3
      Triangle 1 is scalene
      Triangle 2 is equilateral
      The perimeter of triangle 1 is 14
      The perimeter of triangle 2 is 9
      */
    }


}