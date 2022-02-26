class TestScopeI 
{
    public static void main( String[] args ) 
    {
        int  a=5;
        int  b=6;
   
        System.out.println( "a is " + a + " b is " + b );
        swap( a, b );
        System.out.println("a is " + a + " b is " + b);
    } // end main
     
    public static void swap ( int x, int y ) 
    {
        int temp = x;
          
        x = y;       
        y = temp;    
    } // end swap method  
} // end class