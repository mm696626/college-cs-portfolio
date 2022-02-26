/*
   Name:        your name
   Date:        today's date
   Title:       drawTriangle.java
   Description: A program to draw a right triangle, whose size is 
                specified by the user 
   Input:       the number of rows in the triangle
   Output:      the triangle
 */

import java.util.Scanner;
 
class DrawTriangle 
{
    public static void main ( String[] args ) 
    {
        Scanner in = new Scanner( System.in );
        int height;

        System.out.print( "Enter the height of the triangle: " );
        height = in.nextInt();
        //drawUpTriangle( height ); 
        //drawDownTriangle(height);
        drawArrow(height);
    } // end main

    public static void drawRow( int rowlength )  
    {
        int i;
          
        for (i = 1; i <= rowlength; i++)  
        {
            System.out.print("*");
        }
        System.out.println(); 
    } 

    public static void drawUpTriangle( int numrows )  
    {
        int row;
        for(row = 1; row<=numrows; row++)
        {
            drawRow(row);
        } 
        return;
    } 
    public static void drawDownTriangle( int numRows)
    {
       int row;
        for(row = numRows; row>0; row--)
        {
            drawRow(row);
        } 
        return;
    }
    public static void drawArrow(int size)
    {
      drawUpTriangle(size);
      drawDownTriangle(size-1);
    }

} 
