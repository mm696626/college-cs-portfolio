import java.util.Scanner;

public class Menu {
    public static void main(String[] args)
    {
        boolean running = true;
        int choice1=0;
        int choice2=0;

        Scanner reader = new Scanner(System.in);

        while(running==true)
        {
            System.out.println("Welcome to the PPL Menu System");
            System.out.println("Author: Matt McCullough");
            System.out.println("1. Echo a number");
            System.out.println("2. Double a number");
            System.out.println("3. Eat something");
            System.out.println("4. Quit");
            System.out.print("Enter your selection: ");
            int selection = reader.nextInt();

            if(selection==1)
            {
                System.out.print("Enter a number: ");
                choice1 = reader.nextInt();
                System.out.println("The number is: " + choice1);

            }
            else if(selection==2)
            {
                System.out.print("Enter a number: ");
                choice2 = reader.nextInt();
                choice2 *= 2;
                System.out.println("The number doubled is: " + choice2);
            }
            else if(selection==3)
            {
                System.out.print("Enter a food: ");
                String food = reader.next();
                System.out.println("If you eat " + choice2 + " " + food + " " + "it would cost you $" + choice1);

            }
            else if(selection==4)
            {
                System.out.println("Thanks for using the Menu System");
                System.out.println("Goodbye!");
                running=false;
            }
            else
                System.out.println("Invalid selection");
        }


    }

}
