import java.util.Scanner;
public class AlphabeticalStrings
{
   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter the first string: ");
      String str1 = reader.nextLine();
      System.out.print("Enter the second string: ");
      String str2 = reader.nextLine();
      System.out.print("Enter the third string: ");
      String str3 = reader.nextLine();
      
      if(str1.compareToIgnoreCase(str2)<0 && str1.compareToIgnoreCase(str3)<0 && str2.compareToIgnoreCase(str3)<0)
         System.out.println(str1 + "," + str2 + "," + str3);
      
      else if(str1.compareToIgnoreCase(str3)<0 && str1.compareToIgnoreCase(str2)<0 && str3.compareToIgnoreCase(str2)<0)
         System.out.println(str1 + "," + str3 + "," + str2);
         
            
      else if(str2.compareToIgnoreCase(str1)<0 && str2.compareToIgnoreCase(str3)<0 && str1.compareToIgnoreCase(str3)<0)
         System.out.println(str2 + "," + str1 + "," + str3);
         
      
         
      else if(str2.compareToIgnoreCase(str3)<0 && str2.compareToIgnoreCase(str1)<0 && str3.compareToIgnoreCase(str1)<0)
         System.out.println(str2 + "," + str3 + "," + str1);
         
      else if(str3.compareToIgnoreCase(str1)<0 && str3.compareToIgnoreCase(str2)<0 && str1.compareToIgnoreCase(str2)<0)
         System.out.println(str3 + "," + str1 + "," + str2);
         
      else if(str3.compareToIgnoreCase(str2)<0 && str3.compareToIgnoreCase(str1)<0 && str2.compareToIgnoreCase(str1)<0)
         System.out.println(str3 + "," + str2 + "," + str1);
      else
         System.out.println("Error: Strings are identical");
         
   
   }

}