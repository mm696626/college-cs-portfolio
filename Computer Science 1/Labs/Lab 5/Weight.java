import java.text.DecimalFormat;

class Weight 
{     
     final static int W_START = 100;
     final static int W_END = 80;

     public static void main(String[] args) 
     {
          DecimalFormat twoPlaces = new DecimalFormat( "0.00" );
          int lb_weight;
          double kg_weight;

          System.out.println("\n Table of weights\n");
          System.out.println(" lbs \t kilos");
          System.out.println("----- \t -----");
          for (lb_weight = W_START; lb_weight <= W_END; lb_weight += 2)
          {
               kg_weight = lb_weight / 2.2;  // conversion 
               System.out.println(lb_weight + " \t" 
                                  + twoPlaces.format( kg_weight ) );
          }
     } // ends the main 
} // ends the class
