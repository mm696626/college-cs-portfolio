class Presents
{
   final static int DAYS_OF_XMAS = 12;
   public static void main(String[] args)
   {
      int total_presents=0;
      int day = 0;
      int daily_presents,increment;
      for(day=2; day<=DAYS_OF_XMAS; day = day+2)
      {
         daily_presents = 0;
         for(increment=1; increment<=day; increment++)
         {
            daily_presents+=increment;
         }
         System.out.println( "Presents for day " + day + ": " +
                                 daily_presents );
            total_presents += daily_presents;
        } 
        System.out.println( "Total presents received on Christmas: " +
                             total_presents );
    }  
}  