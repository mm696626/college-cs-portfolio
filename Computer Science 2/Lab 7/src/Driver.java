import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
public class Driver {
    public static void main(String [] args){
    
       Scanner inputStream=null;
       PrintWriter outputStream=null;
       ArrayList<BBall> players = new ArrayList<BBall>();
       try{
          inputStream= new Scanner(new FileInputStream("basketball_2019.txt"));
          outputStream = new PrintWriter(new FileOutputStream("output.txt"));
       }
       catch (FileNotFoundException e) {
          System.out.println("Problem opening files");
          System.exit(0);
       }
          
       
        while (inputStream.hasNextLine()) {
        	
        	int num = inputStream.nextInt();
        	String lName = inputStream.next();
            String fName = inputStream.next();
            int made2 = inputStream.nextInt();
            int att2 = inputStream.nextInt();
            int made3 = inputStream.nextInt();
            int att3 = inputStream.nextInt();
            int made1 = inputStream.nextInt();
            int att1 = inputStream.nextInt();
            BBall p = new BBall(num,lName,fName,made2,att2,made3,att3,made1,att1);
            players.add(p);
            
            
         }
        Collections.sort(players);
        for(int i=0; i<players.size(); i++)
        {
        	outputStream.println(players.get(i).toString());
        }
        
       int totalPoints=0;
       int twoPointAttempts=0;
       int twoPointSuccess=0;
       int threePointAttempts=0;
       int threePointSuccess=0;
       int foulAttempts=0;
       int foulSuccess=0;
       for(int i=0; i<players.size(); i++)
       {
    	   totalPoints+=players.get(i).getMade2()*2;
    	   totalPoints+=players.get(i).getMade3()*3;
    	   totalPoints+=players.get(i).getMade1();
    	   twoPointAttempts+=players.get(i).getAtt2();
    	   twoPointSuccess+=players.get(i).getMade2();
    	   threePointAttempts+=players.get(i).getAtt3();
    	   threePointSuccess+=players.get(i).getMade3();
    	   foulAttempts+=players.get(i).getAtt1();
    	   foulSuccess+=players.get(i).getMade1();
    	   
    	   
    	   
       }
       double twoPointPercent=(double)twoPointSuccess/twoPointAttempts;
       double threePointPercent=(double)threePointSuccess/threePointAttempts;
       double foulPercent=(double)foulSuccess/foulAttempts;
       outputStream.println("The total points of the team is: " + totalPoints);
       outputStream.println("The two point percent is: " + twoPointPercent*100);
       outputStream.println("The three point percent is: " + threePointPercent*100);
       outputStream.println("The foul shot percent is: " + foulPercent*100);
     
       inputStream.close();
       outputStream.close();
       }
}
