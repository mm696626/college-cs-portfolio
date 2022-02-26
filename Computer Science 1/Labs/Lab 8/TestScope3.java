class TestScope3 
{
    public static void main( String[] args ) 
    {
        int i=10;
        int j=20;

        func1( 50, j );
        func1( i, 50 );
        System.out.println("In main: i is " + i + " j is " + j);
    } // end main
     
    public static void func1 ( int i, int j ) 
    {
         i = i + j;
         j = j + i;
         System.out.println("In func1: i is " + i + " j is " + j);
    }  // end func1
} // end class