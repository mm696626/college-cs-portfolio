import java.util.ArrayList;
public class TitanicTester2
{
   public static void main(String[] args)
   {     ArrayList<Passenger> titanic= new ArrayList<Passenger>();

  	
  	
  	
  	//titanic.add(new Passenger (2 ,"male", true, false));    // exception - "male" in the wrong place
  	titanic.add(new Passenger (5, true, "male", false));	// exception - status cannot be 5
  	
	   	//Loop through and print out titanic   
  	for(int i=0; i<titanic.size(); i++)
  	{
  		System.out.println(titanic.get(i));
  	}
}
}
