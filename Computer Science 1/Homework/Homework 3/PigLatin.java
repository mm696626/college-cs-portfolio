import java.util.Scanner;
public class PigLatin
{
   public static void main(String args[])
   {
      String firstName = "";
      String lastName = "";
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter first name");
      firstName = reader.next();
      System.out.println("Enter last name");
      lastName = reader.next();
      firstName = firstName.toLowerCase(); //changes strings to lower case
      lastName = lastName.toLowerCase();
      String firstNameletter = firstName.substring(0,1); //takes first letter from both strings
      String lastNameletter = lastName.substring(0,1);
      String newString1 = firstName.substring(1); //takes strings without first letter
      String newString2 = lastName.substring(1);
      System.out.println(newString1 + firstNameletter + "ay" + " " + newString2 + lastNameletter + "ay");
      
   }


}