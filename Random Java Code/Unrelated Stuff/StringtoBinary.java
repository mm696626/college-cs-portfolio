import java.util.Scanner;
public class StringtoBinary {

	public static void main(String[] args) {
		System.out.print("Give a binary number to convert to decimal: ");
		Scanner reader = new Scanner(System.in);
		String binary = reader.next();
		boolean invalid = false;
		int sum = 0;
		
		for(int i=0; i<=binary.length()-1; i++)
		{
			if(binary.charAt(binary.length()-(1+i)) == '1')
			{
				sum += Math.pow(2, i);
			}
			else if(binary.charAt(binary.length()-(1+i)) == '0')
			{
				
			}
			else
			{
				System.out.println("Invalid binary number");
				invalid=true;
				break;
			}
		
		}
		if(invalid==false)
			System.out.println("Result is: " + sum);
	}

}
