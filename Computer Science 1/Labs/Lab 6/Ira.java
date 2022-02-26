public class Ira
{
   public static void main(String[] args)
   {
      int age = 22;
      double balance = 0.00;
      while(balance<1000000)
      {
         age++;
         balance += balance*0.08;
         balance+=2000;
      }
      
      System.out.println("You will be " + age + " years old when you retire and when the IRA holds 1 million dollars");
   
   }



}