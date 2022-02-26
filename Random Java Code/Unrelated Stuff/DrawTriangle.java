import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DrawTriangle {

       public static void main(String[] args) throws FileNotFoundException {
    	   	
    	  
    	   	  
              Scanner sc = new Scanner(System.in);

              System.out.println("Enter an integer, which is no less than 2: ");

              int n = sc.nextInt();

              if (n>=2){

                     printStructure(n);

              } 
              else {

                     System.out.println("Invalid value!");

              }

       }

      
       public static void printStructure(int m){
    	   PrintWriter os=null;
    	   try{
		        os = new PrintWriter( new FileOutputStream("triangle.txt"));
		       }
		       catch (FileNotFoundException f) {
		         System.out.println("Problem opening files");
		          System.exit(0);
		       }
          for(int i=0; i<m; i++)
          {
        	  for(int j=0; j<=i; j++)
        	  {
        		  os.print("*");
        	  }
        	 os.println();
          }
          
          for(int i=0; i<m; i++)
          {
        	  for(int j=m-1; j>i; j--)
        	  {
        		  os.print("*");
        	  }
        	 os.println();
          }
    	  os.close();
       }

}