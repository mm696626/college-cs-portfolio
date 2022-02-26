class TestScope2 
{
    public static void main ( String[] args ) 
    {
        int a=6;
        int b=7;

        func1( a );
        System.out.println("a is " + a + " b is " + b);
    } // end main
     
    public static void func1 ( int a ) 
    {
        int b=5;
          
        a=3;
        System.out.println("a is " + a + " b is " + b);
    }  // end method   
} // end class