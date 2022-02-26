import java.util.Scanner;

class Select2 
{
    public static void main ( String[] args ) 
    {
        Scanner keyboard = new Scanner( System.in );
        int num;

        System.out.println( "Enter the number (0 through 9)" );
        num = keyboard.nextInt();
        
        System.out.println( "The number you entered was:" );
        switch ( num )
        {
            case 0:
                System.out.println( "Zero" );
                break;
            case 1:
            case 2:
                System.out.println( "One" );
                System.out.println( "Two" );
                break;
            case 3:
            case 4:
            case 5:
                System.out.println( "Four" );
                break;
            case 6:
                System.out.println( "Six" );
            case 7:
                System.out.println( "Seven" );
            case 8:
                System.out.println( "Eight" );
                break;
            case 9:
                System.out.println( "Nine" );
            default:
                System.out.println( " an invalid number" );
                break;
        } // end switch
    }  //end main
}  //end class Select2