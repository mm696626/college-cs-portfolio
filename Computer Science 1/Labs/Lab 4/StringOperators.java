public class StringOperators
{
   public static void main(String[] args)
   {
     
      
      String lat = "385323N";
      String lon = "770027W";
      
      String latDeg = lat.substring(0,2);
      String latMin = lat.substring(2,4);
      String latSec = lat.substring(4,6);
      String latDir = lat.substring(6);
      
      String lonDeg = lon.substring(0,2);
      String lonMin = lon.substring(2,4);
      String lonSec = lon.substring(4,6);
      String lonDir = lon.substring(6);
      System.out.println("The Capitol is located at " + latDeg + " degrees " + latMin + " minutes " + latSec + " seconds " + latDir + " and");
      System.out.println(lonDeg + " degrees " + lonMin + " minutes " + lonSec + " seconds " + lonDir);
   
   
   }



}