import java.util.Scanner;

public class Palindrome {

       public static void main(String[] args) {

              Scanner sc = new Scanner(System.in);

              System.out.println("Enter an integer number: ");

              // such as 121, 15451, or 1234

              int inputVal = sc.nextInt();

              if (checkPalindrome(inputVal)){

                     System.out.println("It is palindrome");

              } else {

                     System.out.println("It is not palindrome");

              }

       }

       public static boolean checkPalindrome(int m){
    	   StringBuilder a = new StringBuilder();
    	   a.append(m);
    	   if(a.toString().equals(a.reverse().toString()))
    		   return true;
    	   else
    		   return false;
    	 
    	  

       }

}