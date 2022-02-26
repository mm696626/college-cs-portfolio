import java.util.Scanner;

class Select1 
{
    public static void main ( String[] args ) 
    {
        Scanner keyboard = new Scanner( System.in );
        int day;

        System.out.println("Enter the number of the day of the week (1 through 7)");
        day = keyboard.nextInt();
        
        System.out.print("The day you entered was ");
        switch (day)
        {
            case 1:
                System.out.println("Sunday");
                //break;
            case 2:
                System.out.println("Monday");
                //break;
            case 3:
                System.out.println("Tuesday");
                //break;
            case 4:
                System.out.println("Wednesday");
                //break;
            case 5:
                System.out.println("Thursday");
                //break;
            case 6:
                System.out.println("Friday");
                //break;
            case 7:
                System.out.println("Saturday");
               // break;
            default:
                System.out.println(" an invalid day");
                //break;
        } // end switch
    }  //end main
}  //end class Select1