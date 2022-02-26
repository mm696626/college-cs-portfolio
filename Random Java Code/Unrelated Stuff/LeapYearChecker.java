import java.util.Scanner;
public class LeapYearChecker {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		boolean isLeapYear = true;
		int year = 0;
		System.out.println("What year do you want to check if its a leap year");
		year = reader.nextInt();
		if(year%4!=0)
			isLeapYear = false;
		else if(year%100!=0)
			isLeapYear=true;
		else if(year%400!=0)
			isLeapYear=false;
		else
			isLeapYear=true;
		
		
		if(isLeapYear==true)
			System.out.println("The year " + year + " is a leap year");
		else
			System.out.println("The year " + year + " is not a leap year");
		
		

	}

}
