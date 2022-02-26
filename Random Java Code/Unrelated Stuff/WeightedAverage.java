import java.util.*;
public class WeightedAverage {

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		double weight=0;
		double totalweight=0;
		ArrayList<Double> grades = new ArrayList<Double>();
		ArrayList<Double> weights = new ArrayList<Double>();
		boolean done = false;
		int counter = 0;
		double grade = 0;
		int weightedaveragecheck=0;
		System.out.println("Are you doing a weighted average? 1 - yes any other number-no");
		weightedaveragecheck= reader.nextInt();
		while(done==false)
		{
			if(weightedaveragecheck!=1)
			{
				
				double points = 0;
				double totalpoints=0;
				System.out.println("Enter points");
				points = reader.nextDouble();
				System.out.println("Enter total points");
				totalpoints= reader.nextDouble();
				grade = (points/totalpoints) * 100.0;
				done=true;
			}
			if(weightedaveragecheck==1)
			{
				double points = 0;
				double totalpoints=0;
				System.out.println("Enter points");
				points = reader.nextDouble();
				System.out.println("Enter total points");
				totalpoints= reader.nextDouble();
				System.out.println("Enter weight");
				weight= reader.nextDouble();
				totalweight+=weight;
				grade = (points/totalpoints);
				grades.add(grade);
				weights.add(weight);
				counter++;
				int choice=0;
				System.out.println("Are you done? 1 - yes any other number-no");
				choice = reader.nextInt();
				if(choice==1)
					done=true;
			}
			
		}
		if(weightedaveragecheck==1)
		{
			double top = 0;
			for(int x=0; x<grades.size(); x++)
			{
				top += grades.get(x)*weights.get(x);
			}
			grade = (top/totalweight)*100.0;
		}
		
		System.out.println("Your grade is a " + grade + "%");
		
		
	}
	
}
