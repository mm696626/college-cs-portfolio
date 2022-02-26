public class part2raisingXtoN {
	
	public static void main(String[] args) 
	{
		System.out.println("Raising 2 to -4 is " + power2(2,-4));
	}
	public static double power2(double x, int n) {
		if(n==0)
			return 1;
		if(n<0)
			return power2(x,n+1)/x;
		else
			return power2(x,n-1) * x;
		}
	}

