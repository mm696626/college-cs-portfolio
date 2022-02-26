/**
 * @author Matthew McCullough
 * @date 4/12/2019
 * This program does several things about calculating population of cities using HashMaps and text file reading
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Collections;

public class CityPopulation {
    public static void main(String [ ] args) {
       
        Scanner inputStream=null;
        Scanner reader = new Scanner(System.in);
        PrintWriter outputStream=null;
      
       try {
          inputStream= new Scanner ( new FileInputStream("city_pop.txt"));
          outputStream = new PrintWriter( new FileOutputStream("count.txt"));
       }
       catch (FileNotFoundException e) {
          System.out.println("Problem opening files");
          System.exit(0);
       }
       
       	HashMap<String, Double> cities = new HashMap<String,Double>();
        Double population = null;
        String city;
          
          while(inputStream.hasNext()){
        	  city = inputStream.next();
        	  population = inputStream.nextDouble();
        	  cities.put(city,population);
            }
          double sum = 0;
          for(String name :cities.keySet())
          {
        	  String key = name.toString();
        	  Double val = cities.get(name);
        	  sum+=val;
        	  outputStream.println( key + " :"+ val);
          }
          System.out.printf("Sum of Population: %f", sum);
          System.out.println();
          boolean isValid = false;
          String input = "";
          while(isValid == false)
          {
        	  System.out.print("Enter a city name: ");
        	  input = reader.next();
        	  for(String name :cities.keySet())
              {
        		 String key = name.toString();
        		 Double val = cities.get(name);
            	 if(input.equals(key))
            	 {
            		 System.out.println("The population of " + input + " is: " + val);
            		 isValid=true;
            	 }
            		
              }
          }
      		HashMap<String, Double> cities10Percent = new HashMap<String,Double>();
      		outputStream.println("Adjusted Populations (increased by 10 percent)");
      		 for(String name :cities.keySet())
             {
           	  String key = name.toString();
           	  Double val = cities.get(name) * 1.1;
           	  cities10Percent.put(key, val);
           	  if(key.equalsIgnoreCase("Philadelphia") || key.equalsIgnoreCase("Dallas") || key.equalsIgnoreCase("SanAntonio"))
           		  outputStream.println( key + " :"+ val);
             }
           
              
       
       inputStream.close();
       outputStream.close();
       }
}
