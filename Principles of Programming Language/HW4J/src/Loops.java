import java.util.Scanner;

public class Loops {
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to the Loop Program");
        System.out.println("Written by Matt McCullough");
        System.out.print("Enter a value: ");
        int num1 = reader.nextInt();
        for(int i=0; i<=num1; i++)
        {
            if(i%2==0)
                System.out.println(i);
        }

        System.out.print("Enter a value: ");
        int num2 = reader.nextInt();
        while(num2>=0)
        {
            if(num2%2!=0)
                System.out.println(num2);
            num2--;
        }
    }
}
