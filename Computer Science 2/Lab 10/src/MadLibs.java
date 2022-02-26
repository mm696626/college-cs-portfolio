/**
 * @author Matthew McCullough
 * @date 4/12/2019
 * This program re-creates the word game Mad Libs
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
public class MadLibs {

	public static void main(String[] args) {
		Scanner inputStream=null;
        Scanner reader = new Scanner(System.in);
        PrintWriter outputStream=null;
      
       try {
          inputStream= new Scanner ( new FileInputStream("madlibs.txt"));
          outputStream = new PrintWriter( new FileOutputStream("result.txt"));
       }
       catch (FileNotFoundException e) {
          System.out.println("Problem opening files");
          System.exit(0);
       }
       while (inputStream.hasNextLine()) {
    	   String line = inputStream.nextLine(); /**find < for start and > for end and replace the substring with the input (reads in a line of input) */
    	   String newLine = ""; /**new line to output */
    	   int index = 0;/** index for command (start of replacement) */
    	   int index2 = 0;  /** end of replacement */
    	   boolean firstReplace = true; /** if first replace do something (first set) if not edit existing replaced string */
    	   boolean change = false; /**is there a change, or not print new line or original line */
    	   String replace = ""; /** string to give command and is used to check if something needs to be replaced */
    	   
    	   /** go through line to check for things to replace */
    	   for(int i=0; i<line.length(); i++)
    	   {
    		   replace="";
    		   if(line.charAt(i) == '<')
    		   {
    			   index=i;
    		   }
    		   if(line.charAt(i) == '>')
    		   {
    			   index2=i; 
    			   replace = line.substring(index+1,index2);
    		   }
    		   if(replace!="")
    		   {
    			   change = true;
    	    	   System.out.print("Please type a " + replace + ": ");
    	    	   String input = reader.nextLine();
    	    	   
    	    	   if(firstReplace == true)
    	    	   {
    	    		   if(index == 0)
        	    		   newLine= input + line.substring(index2+1);
        	    	   if(index2 == line.length()-1)
        	    		   newLine= line.substring(0,index) + input;
        	    	   else
        	    	   {
        	    		   newLine= line.substring(0,index) + input + line.substring(index2+1);
        	    	   }
        	    	   firstReplace = false;
    	    	   }
    	    	   else
    	    	   {
    	    		   int count  = 0; /** checks if more than one replacement is done to avoid overwriting later inputs */
    	    		   for(int j=0; j<newLine.length(); j++)
    	    		   {
    	    			   if(newLine.charAt(j) == '<')
    	        		   {
    	    				   index=j;
    	        		   }
    	        			   
    	        		  
    	        		   if(newLine.charAt(j) == '>' && count==0)
    	        		   {
    	        			   index2=j;
    	        			   if(index2 == newLine.length()-1)
    	        			   {
    	        				   newLine= newLine.substring(0,index) + input;
    	        				   count++;
    	        			   }
    	        	    		  
    	        	    	   else
    	        	    	   {
    	        	    		   newLine= newLine.substring(0,index) + input + newLine.substring(index2+1);
    	        	    		   count++;
    	        	    	   }
    	        		   }
    	    		   }
    	    	   }
    	    	   index=0; /**reset index trackers*/
        		   index2=0;
    		   }
    			   
    	   }
    	   if(change==true)
    		   outputStream.println(newLine);
    	   else
    		   outputStream.println(line);
       }
       inputStream.close();
       outputStream.close();
	}

}
