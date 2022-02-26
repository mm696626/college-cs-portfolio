import java.util.Scanner;

//Author: Matt McCullough
public class Greetings2 {

	public static void main(String[] args) {
		System.out.println("Welcome to the Greetings Program!");
		System.out.println("Written by Matt McCullough");
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String name = reader.nextLine();
		System.out.println("Hello from" + " " + name);
		System.out.println("Goodbye from" + " " + name);

	}

}
