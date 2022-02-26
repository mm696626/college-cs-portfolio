import java.util.Scanner;

public class PrintStructure {

       public static void main(String[] args) {

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
          for(int i=0; i<m; i++)
          {
        	  for(int j=0; j<=i; j++)
        	  {
        		  System.out.print("*");
        	  }
        	  System.out.println();
          }
          
          for(int i=0; i<m; i++)
          {
        	  for(int j=m-1; j>i; j--)
        	  {
        		  System.out.print("*");
        	  }
        	  System.out.println();
          }
    	  
       }

}