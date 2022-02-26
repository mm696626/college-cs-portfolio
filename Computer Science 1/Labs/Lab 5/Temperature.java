import java.text.DecimalFormat;
public class Temperature
{
   public static void main(String args[])
   {
      final int START = 32;
      final int END = 95;
      int f;
      double c;
      int linecount=0;
      DecimalFormat twoPlaces = new DecimalFormat( "0.00" );
      System.out.println("\n Table of reasonable outside temperatures\n");
      System.out.println(" F \t C");
      for (f = START; f <= END; f++)
      {
         if(linecount%5==0 && f!=END)
         {
            System.out.println("------------");
         }
         c = (f - 32) * (5.0/9);  // conversion 
         System.out.println(f + " \t" + twoPlaces.format( c ) );
         linecount++;
      }
         System.out.println("------------");

   
   
   }

}