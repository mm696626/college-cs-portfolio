import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Statistics {

	public static void main(String[] args) {
		
		Scanner inputStream=null;
		  
		       try{
		          inputStream= new Scanner (new FileInputStream("data.txt"));
		       }
		       catch (FileNotFoundException e)
		       {
		     
		         System.out.println("No data found");
		        
		         System.exit(0);
		       }
		       
		int dataCounter = inputStream.nextInt(); //first line is number of trials/data points
		
		
		double[] data = new double[dataCounter]; //add data
		
		double sum = 0;
		for(int i=0; i<dataCounter; i++)
		{
			data[i] = inputStream.nextDouble();
			sum+=data[i];
		}
		
		double average = sum/dataCounter;
		
		double stdevSum = 0;
		
		for(int i=0; i<dataCounter; i++)
		{
			stdevSum += Math.pow((data[i]-average), 2.0);
		}
		
		double stdev = Math.pow(stdevSum/(dataCounter-1), .5);
		
		
		int numDecimalPlaces = 5;
		String format = "0.";
		for(int i=0; i<numDecimalPlaces; i++)
		{
			format+="0";
		}
		
		DecimalFormat df = new DecimalFormat(format);
		
		
		
		for(int i=0; i<data.length; i++)
		{
			System.out.println("Trial " + (i+1) + ": " + data[i]);
			System.out.println("Li - average :" + df.format((data[i]-average)));
			System.out.println("Li - average squared : "  + df.format(Math.pow((data[i]-average), 2)));
		}
		System.out.println("Average: " + df.format(average));
		System.out.println("Standard Deviation Summation: " + df.format(stdevSum));
		System.out.println("Standard Deviation: " + df.format(stdev));
		
		System.out.println("Make sure to round to correct number of sig figs");
		
		
		
	  

	}

}
