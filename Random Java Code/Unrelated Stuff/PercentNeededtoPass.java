import java.util.*;
public class PercentNeededtoPass {

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		double gradeyouwant = 0;
		String classname = "";
		int terms = 0;
		int currentterm=0;
		double totalneeded=0;
		double currenttotal=0;
		boolean done = false;
		while(done==false)
		{
			System.out.println("What is the name of your class?");
			classname= reader.nextLine();
			System.out.println("How many terms is it? Examples are 4 for quarters, 2 for semester");
			terms = reader.nextInt();
			System.out.println("What term are you in?");
			currentterm=reader.nextInt();
			while(currentterm>terms)
			{
				System.out.println("What term are you in?");
				currentterm=reader.nextInt();
			}
			System.out.println("What grade do you want in the class?");
			gradeyouwant = reader.nextDouble();
			
			
			int termsleft = 0;
			termsleft = terms-(currentterm-1);
			for(int x=0; x<currentterm-1; x++)
			{
			
				double currentgrade=0;
				System.out.println("What is your current grade for term " + (x+1));
				currentgrade = reader.nextDouble();
				currenttotal+=currentgrade;
			}
			totalneeded= gradeyouwant*terms;
			totalneeded= (totalneeded-currenttotal);
			totalneeded= (totalneeded)/(termsleft);
			if(totalneeded>0 && totalneeded<=100)
			{
				System.out.println();
				if(termsleft!=1)
				{
					System.out.println("The grade you need for the last " + termsleft + " terms in " + classname + " class is a " + totalneeded + "%" + " for each term");
				}
				if(termsleft==1)
				{
					System.out.println("The grade you need for the last " + termsleft + " term in " + classname + " class is a " + totalneeded + "%");
				}
				
			}
			if(totalneeded<=0)
			{
				System.out.println("You already have a " + gradeyouwant + "%" + " in " + classname + " class"); 
			}
			if(totalneeded>100)
			{
				System.out.println("It is impossible to get a " + + gradeyouwant + "%" + " in " + classname + " class");
			}
			reader.nextLine();
			System.out.println("Are you done using the calculator 1-yes any other number-no");
			int choice=reader.nextInt();
			if(choice==1)
			{
				done=true;
			}
			reader.nextLine();
		}

	}

}
