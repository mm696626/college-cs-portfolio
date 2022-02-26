public class part3sumofarray { 
	public static void main(String[] args) 
	{ 
		int[] values = {1,3,5,7,9}; 
		System.out.println("The sum is " + sum(values)); 
	} 
	private static int sum(int[] array, int index) 
	{ 
		if(index==array.length-1)
			return array[array.length-1];
		else
			return array[index] + sum(array,index+1);
	} 
	public static int sum(int[] array) 
	{ 
		return sum(array, 0); 
	} 
}
