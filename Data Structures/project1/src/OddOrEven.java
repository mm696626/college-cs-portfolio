import java.util.Scanner;
public class OddOrEven {

       public static void main(String[] args) {

              Scanner sc = new Scanner(System.in);

              System.out.println("Enter an integer number: ");

              int n = sc.nextInt();

              if (checkFunction(n)){

                     System.out.println("It is even");

              } else {

                     System.out.println("It is odd");

              }

       }

      

       public static boolean checkFunction(int m){

              if(m%2==0)
            	  return true;
              else
            	  return false;

}
       }

