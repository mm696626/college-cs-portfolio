import java.util.Scanner;
public class Grades
{
   public static void main(String[] args)
   {
      Scanner reader = new Scanner(System.in);
      double score1 = 0;
      double score2 = 0;
      double score3 = 0;
      double average = 0;
       
      System.out.println("Enter score 1 (in percent)");
      score1 = reader.nextDouble();
      System.out.println("Enter score 2 (in percent)");
      score2 = reader.nextDouble();
      System.out.println("Enter score 3 (in percent)");
      score3 = reader.nextDouble();
      
      average = (score1+score2+score3)/3.0; //takes average
      if(average>=90) //checks if average is within bounds
      System.out.println("Your average is a " + average + " percent which is an A");
      else if(average>=80 && average < 90)
      System.out.println("Your average is a " + average + " percent which is a B");
      else if(average>=70 && average < 80)
      System.out.println("Your average is a " + average + " percent which is a C");
      else if(average>=60 && average < 70)
      System.out.println("Your average is a " + average + " percent which is a D");
      else
      System.out.println("Your average is a " + average + " percent which is a F");

   
   }


}