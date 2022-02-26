import java.util.Scanner;
import java.text.NumberFormat;

public class Atm 
{
    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner( System.in );
        NumberFormat money = NumberFormat.getCurrencyInstance();
        double balance = 10.00;  
        double amount;           
        char choice;             
        String strChoice, message;
          
        message = "Enter w for withdrawal, d to desposit, b to check balance, " +
                    "or q to quit: ";
        do
        {
            System.out.print( message );
            strChoice = keyboard.next();
            choice = strChoice.charAt( 0 );
        } while ( choice != 'w' && choice != 'b' && choice != 'q' && choice != 'd');
       
        while ( choice != 'q' )
        {
            
            switch ( choice )  
            {
                case 'w':
          
                    System.out.print( "Enter the amount for withdrawal: $" );
                    amount = keyboard.nextDouble();
                    if(amount<=0)
                    {
                       System.out.println("Error");
                    
                    }
                    else if (balance < amount)
                    {
                        System.out.println( "Sorry, insufficient funds" );
                    }
                    else
                    {
                        balance = balance-amount;
                        System.out.println( "Withdrawal complete" );
                    }
                    break;
                case 'd':
                    System.out.print( "Enter the amount for deposit: $" );
                    amount = keyboard.nextDouble();
                    balance = balance+amount;
                    System.out.println( "Deposit complete" );
                    break;
                
                case 'b':
                    System.out.println( "Your balance is " + 
                                        money.format( balance ) );
                    break;
                default:
                     System.out.println( "This line should never be printed" );
            }  
           
            do {
                System.out.print( message );
                strChoice = keyboard.next();
                choice = strChoice.charAt( 0 );
            } while ( choice != 'w' && choice != 'b' && choice != 'q' && choice != 'd');
          
        }  
       
        System.out.println( "BYE" );
    }
}