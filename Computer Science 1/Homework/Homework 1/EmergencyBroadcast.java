/*
  Name:        Matt McCullough
  Date:        September 3, 2018
  Title:       EmergencyBroadcast.java
  Description: Prints the phrase "This is a test of the emergency broadcast system" to the screen
  Input:       none
  Output:      the phrase "This is a test of the emergency broadcast system"
*/
public class EmergencyBroadcast {

	public static void main(String[] args) 
	{
		//first time with 6 System.out statements
		System.out.print("This is a test");
		System.out.println();
		System.out.print("of the emergency");
		System.out.println();
		System.out.print("broadcast system");
		System.out.println();
		
		System.out.println();//blank line 
		
		//1 System.out.print and one System.out.println
		System.out.println("This is a test" + "\n" + "of the emergency");
		System.out.print("broadcast system");

	}

}
