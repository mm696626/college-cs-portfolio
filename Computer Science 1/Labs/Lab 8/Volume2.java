import java.util.Scanner;
import java.text.DecimalFormat;

class Volume2 
{
     public static void main( String[] args ) 
     {
          Scanner in = new Scanner( System.in );
             DecimalFormat two_places = new DecimalFormat( "0.00" );
          double radius, volume, surfaceArea;

          System.out.println("Enter the radius of the sphere:");
          radius = in.nextDouble();

          volume = calculateVolume( radius );
          surfaceArea = calculateSurfaceArea( radius);

          System.out.println("A sphere of radius " + 
                              two_places.format( radius ) + 
                             " has a volume of " + 
                              two_places.format( volume ) );
          System.out.println("A sphere of radius " + 
                              two_places.format( radius ) + 
                             " has a surface area of " + 
                              two_places.format( surfaceArea ) );

          return;
     } // end main


     // ***********************************************
     //
     // method calculateVolume
     //
     // method calculates the volume of a sphere using the
     //   formula   4/3*Pi*r^3
     //
     //  input: a radius (a double)
     //  output: the volume (a double)
     //
     // ************************************************
     public static double calculateVolume( double r ) 
     {
          double returnval;
          returnval = 4.0/3.0 * Math.PI * Math.pow( r, 3 );
          return returnval;
     }  // end calculateVolume method
     public static double calculateSurfaceArea( double r)
     {
          double surfaceArea;
          surfaceArea = 4.0 * Math.PI * Math.pow(r, 2.0);
          return surfaceArea;
      
     }
} // end Volume class