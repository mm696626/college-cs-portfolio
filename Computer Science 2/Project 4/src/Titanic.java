import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class Titanic {
	public static void main(String[] args)
	{
		 Scanner inputStream=null;
		 PrintWriter outputStream=null;
	  
	       try{
	          inputStream= new Scanner (new FileInputStream("titanic.txt"));
	          outputStream = new PrintWriter( new FileOutputStream("output.txt"));
	       }
	       catch (FileNotFoundException e) {
	         System.out.println("Problem opening files");
	          System.exit(0);
	       }
	       ArrayList<Passenger> people = new ArrayList<Passenger>();
	       while (inputStream.hasNextLine()) {
	    	   int status = inputStream.nextInt(); //boolean checking thing use parseBoolean() on String and use that boolean
	    	   String test = inputStream.next();
	    	   boolean isChild;
	    	   if((test.equals("true") || test.equals("false")))
					isChild = Boolean.parseBoolean(test);
					else
					{
						System.out.println("ERROR NOT A BOOLEAN");
						isChild=false;
					}
	    	   String sex = inputStream.next();
	    	   boolean survivor = inputStream.nextBoolean();
	    	   Passenger p = new Passenger(status,isChild,sex,survivor);
	    	   outputStream.println(p);
	           people.add(p);
	          }
	       int children=0;
	       int males=0;
	       int survivors=0;
	       double percentChild=0;
	       double percentAdult=0;
	       double percentMale=0;
	       double percentFemale=0;
	       double survivorPercent=0;
	       for(int i=0; i<people.size(); i++)
	       {
	    	   if(people.get(i).getChild()==true)
	    		   children++;
	    	   if(people.get(i).getSex().equals("male"))
				   males++;
	    	   if(people.get(i).getSurvivor()==true)
	    		   survivors++;
	       }
	       percentChild = (double)children/people.size();
	       percentChild*=100;
	       percentAdult = 100 - percentChild;
	       percentMale = (double)males/people.size();
	       percentMale*=100;
	       percentFemale = 100-percentMale;
	       survivorPercent=(double)survivors/people.size();
	       survivorPercent*=100;
	       outputStream.println("Percent Children: " + percentChild + " Percent Adult: " + percentAdult + " Percent Male: " + percentMale + " Percent Female: " + percentFemale + " Survivor Percent: " + survivorPercent);
	       inputStream.close();
	       outputStream.close();
	        
	}
}
