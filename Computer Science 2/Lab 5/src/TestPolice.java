import java.util.ArrayList;
public class TestPolice {

	public static void main(String[] args) 
	{
		ArrayList<Policeman> squad = new ArrayList<Policeman>();
		Patrolman p1 = new Patrolman("Mickey", "Mouse", 3);
		squad.add(p1);
		Patrolman p2 = new Patrolman("Matt", "McCullough", 5);
		squad.add(p2);
		Sergeant s1 = new Sergeant("Frank", "Furter", 12);
		squad.add(s1);
		Sergeant s2 = new Sergeant("Bob", "Ross", 10);
		squad.add(s2);
		Lieutenant l1 = new Lieutenant("Daffy", "Duck", 15);
		squad.add(l1);
		for(int i=0; i<squad.size(); i++)
		{
			System.out.println(squad.get(i));
			System.out.println();
		}
		System.out.println("The average earnings for all Police is $" + String.format("%.2f", avgPay(squad)));

	}
	public static double avgPay(ArrayList<Policeman> p)
	{
		double averageEarnings=0;
		for(int i=0; i<p.size(); i++)
		{
			averageEarnings+= p.get(i).earnings();
		}
		averageEarnings/= p.size();
		return averageEarnings;
	}
}
