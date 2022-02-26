import java.util.Scanner;
public class Birthday 
{
   public static void main(String args[])
   {
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter your first name");
      String firstName = reader.next();
      System.out.println("Enter your last name");
      String lastName = reader.next();
      System.out.println("Enter your age");
      int age = reader.nextInt();
      System.out.println(firstName + " " + lastName + " Happy " + age + " Birthday");
      
   
   }


}