import java.util.Random;
import java.util.Scanner;

public class Arrays {
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Array Program in Java");
        System.out.println("Written by Matt McCullough");
        System.out.println("With assistance from Andy Mac");

        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a value: ");
        int size = reader.nextInt();

        int[] array = new int[size];
        Random rng = new Random();

        for(int i=0; i<array.length; i++)
        {
            array[i] = rng.nextInt(90)+10;
        }
        System.out.println("The contents of the array are: ");
        for(int i=0; i<array.length; i++)
        {
            System.out.println(array[i]);
        }


    }
}
