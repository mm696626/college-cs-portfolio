import java.util.LinkedList;
import java.util.Queue;

public class TestProgram {

	public static void main(String[] args) {
		Queue<String> namelist = new LinkedList<String>();
		System.out.println("The first item is: " + namelist.peek());
		try {
			System.out.println("The first item is: " + namelist.element());
		}
		catch(Exception ex)
		{
			System.out.println("Exception:" + ex);
		}
		
		namelist.offer("Ryan");
		namelist.add("David");
		namelist.offer("Caroline");
		namelist.add("John");
		
		System.out.println("The first item is " + namelist.remove());
		System.out.println("The first item is " + namelist.poll());
		
		System.out.println("The size of the current queue is: " + namelist.size());
		
		if(namelist.isEmpty())
			System.out.println("Empty queue");
		else
			System.out.println("Not empty");
			
		
		
		
		
		
		
	}

}
