import java.util.Scanner;

class TimesTable 
{
    public static void main (String [] args)
    {
	Scanner keyboard = new Scanner( System.in );
        int count, multiple, product = 0;
        
        System.out.println("Enter number for which you'd like a times table");
        multiple = keyboard.nextInt();
        
        for (count = 1; count <= 12; count ++)
        {
            product = multiple * count;
            System.out.println(multiple + " * " + count + " = " + product);
        }
            
          
    }
}