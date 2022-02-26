public class FahrenToCels
{
   public static void main(String args[])
   {
      double fahrenTemp, celsTemp;
      fahrenTemp=20.0;
      celsTemp = (fahrenTemp-32)*(5.0/9.0);
      
      
      System.out.println("20.0 degrees Fahrenheit equals " + celsTemp + " degrees Celsius.");
      
      
      double testFahren;
      testFahren = (celsTemp*(9.0/5.0))+32;
      System.out.println("Regression test gives " + testFahren + " as answer");
   
   
   }



}