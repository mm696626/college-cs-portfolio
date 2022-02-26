import java.util.*;
public class randomSentences
{
   public static void main(String args[])
   {
     Random rng = new Random();
     Scanner reader = new Scanner(System.in);
     String random = "";
     int x=0;
     System.out.println("How many strings will you use");
     x = reader.nextInt();
     String dummy = reader.nextLine();
     
     
     String[] strings = new String[x];
     for(int z=0; z<strings.length;z++)
     {
         System.out.println("Enter a string");
         random = reader.nextLine();
         strings[z] = random;
     }
     int n1 = rng.nextInt(x);
     int n2 = rng.nextInt(x);
     int n3 = rng.nextInt(x);
     String s1 = strings[n1];
     String s2 = strings[n2];
     String s3 = strings[n3];
     System.out.println(s1 + " " + s2 + " " + s3);
     boolean randomizeagain = false;
     System.out.println("want to randomize again?");
     randomizeagain=reader.nextBoolean();
     while(randomizeagain==true)
     {
        n1 = rng.nextInt(x);
        n2 = rng.nextInt(x);
        n3 = rng.nextInt(x);
        s1 = strings[n1];
        s2 = strings[n2];
        s3 = strings[n3];
        System.out.println(s1 + " " + s2 + " " + s3);
        System.out.println("want to randomize again?");
        randomizeagain=reader.nextBoolean();
     }
     
     
   }
   

}