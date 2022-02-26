import java.util.Scanner;
import java.text.DecimalFormat;

class Volume3 
{
     public static void main( String[] args ) 
     {
          Scanner in = new Scanner( System.in );
          DecimalFormat two_places = new DecimalFormat( "0.00" );
          double radius, volume, surfaceArea;
          double percentWater, percentLand;
          System.out.println("Enter the radius of the sphere:");
          radius = in.nextDouble();
          System.out.println("Enter the percent of water");
          percentWater = in.nextDouble();
          
          percentLand = 100-percentWater ;
          percentWater/=100;
          percentLand/=100;
          volume = calculateVolume( radius );
          surfaceArea = calculateSurfaceArea(radius);
          double waterSurfaceArea = surfaceArea * percentWater;
          double landSurfaceArea = surfaceArea * percentLand;
          

          System.out.println("A sphere of radius " + 
                              two_places.format( radius ) + 
                             " has a volume of " + 
                              two_places.format( volume ) );
          System.out.println("A sphere of radius " + 
                              two_places.format( radius ) + 
                             " has a surface area of " + 
                              two_places.format( surfaceArea ) );
          System.out.println("A sphere of radius " + 
                              two_places.format( radius ) + 
                             " has a surface area covered by water of " + 
                              two_places.format( waterSurfaceArea ) );
          System.out.println("A sphere of radius " + 
                              two_places.format( radius ) + 
                             " has a surface area covered by land of " + 
                              two_places.format( landSurfaceArea ) );                              

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