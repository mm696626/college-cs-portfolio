public class part1sequence {
	
	public static void main(String[] args) 
	{	
		System.out.println("The 6th element of the sequence is " + seq(6));	
	}//the answer should be 23
	
	
	
	
	public static int seq(int n){
		if(n==0)
			return 2;
		else
		{
			return seq(n-1) + n;
		}
	}
}
