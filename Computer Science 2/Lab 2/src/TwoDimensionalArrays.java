/**
 * This program is practice for 2d arrays by printing data
 * @author Matthew McCullough
 * @date 1/30/2019
 */
public class TwoDimensionalArrays {

	/**
	 * This is the main method where all of the other methods will be ran and tested
	 * 
	 */
	 public static void main(String[] args) 
     {
       twoDArray();
     }
	 public static void twoDArray(){
	       int[][] table = new int[5][10];
	       // Load the table with values
	       for (int row=0; row < table.length; row++){
	         for (int col=0; col < table[row].length; col++)
	            table[row][col] = row * 10 + col;
	       }
	     // Print the table
	     int counter=0;
	     System.out.println("# | 0 1 2 3 4 5 6 7 8 9");
	     System.out.println("--+--------------------");
	     for (int row=0; row < table.length; row++)
	     {
	    	 System.out.print(counter + " | ");
	    	 counter++;
	         for (int col=0; col < table[row].length; col++)
	              System.out.print (table[row][col] + " ");
	             System.out.println();
	     }
	}
	 /*
	  * Sample output:
	  * # | 0 1 2 3 4 5 6 7 8 9
		--+--------------------
		0 | 0 1 2 3 4 5 6 7 8 9 
		1 | 10 11 12 13 14 15 16 17 18 19 
		2 | 20 21 22 23 24 25 26 27 28 29 
		3 | 30 31 32 33 34 35 36 37 38 39 
		4 | 40 41 42 43 44 45 46 47 48 49 
	  */
}