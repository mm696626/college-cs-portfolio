/*
   Name:        your name
   Date:        today's date
   Title:       volume.java
   Description: A program to calculate the volume of a sphere, given
                the radius
                The mathematical formula is: 4/3 * Pi * r^3
   Input:       the radius (a double)
   Output:      the volume of the sphere
 */

import java.util.Scanner;
import java.text.DecimalFormat;

class Volume 
{
     public static void main( String[] args ) 
     {
          Scanner in = new Scanner( System.in );
             DecimalFormat two_places = new DecimalFormat( "0.00" );
          double radius, volume;

          System.out.println("Enter the radius of the sphere:");
          radius = in.nextDouble();

          volume = calculateVolume( radius );

          System.out.println("A sphere of radius " + 
                              two_places.format( radius ) + 
                             " has a volume of " + 
                              two_places.format( volume ) );

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

} // end Volume class