/**
This program provides search and sort practice using an integer array
@author  Matt McCullough 
@date 1/24/19
*/
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class SearchSort {
/**
 * This is the main method where all of the other methods will be ran and tested
 * 
 */
	public static void main(String[] args) 
	{
		Random rng = new Random();
		Scanner reader = new Scanner(System.in);
		/**This an array of 101 random ints*/
		int[] nums = new int[101];
		for(int i=0; i<nums.length; i++)
		{
			nums[i] = rng.nextInt(101);
		}
		System.out.println("Unsorted Array: " + "First number in array : " + nums[0] + " Middle Number in array: " + nums[50] + " Last Number in Array: " + nums[100]);
		sort(nums);
		System.out.println("Sorted Array: " + "First number in array : " + nums[0] + " Middle Number in array: " + nums[50] + " Last Number in Array: " + nums[100]);
		System.out.println("What number do you want to search for?");
		int target = reader.nextInt();
		if(search(nums,target))
			System.out.println("Number is in array");
		else
			System.out.println("Number is not in array");
		System.out.println(Arrays.toString(nums));
	}
	/** Search method implements a binary search through an ordered array 
	@param arr integer array filled with 100 random ints
	@param num int value searching for in arr
	@return true if num is found in arr, false otherwise */

	public static boolean search(int[] a, int b) {
        if (a.length == 0) {
            return false;
        }
        int low = 0;
        int high = a.length-1;

        while(low <= high ) {
            int middle = (low+high) /2;
            if (b> a[middle] ){
                low = middle +1;
            } else if (b< a[middle]){
                high = middle -1;
            } else { // The element has been found
                return true;
            }
        }
        return false;
    }
	/** Sort method sorts an array in ascending order i.e. 0,1,2,3,4,5
	@param arr integer array filled with 100 random ints */
	public static void sort(int a[])  {
        int n = a.length;
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (a[j] < a[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first element
            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
    }
	/*
	 * Sample output:
	 * Unsorted Array: First number in array : 27 Middle Number in array: 30 Last Number in Array: 52
	 * Sorted Array: First number in array : 0 Middle Number in array: 49 Last Number in Array: 100
     * What number do you want to search for?
     * 77
     * Number is in array
     * [0, 1, 2, 3, 4, 8, 8, 8, 11, 11, 12, 12, 13, 13, 13, 13, 13, 14, 14, 15, 15, 17, 17, 20, 22, 23, 23, 24, 24, 25, 26, 26, 27, 28, 28, 30, 33, 34, 34, 34, 36, 38, 39, 40, 43, 46, 47, 48, 48, 48, 49, 50, 51, 51, 52, 53, 54, 55, 55, 56, 56, 58, 60, 61, 62, 64, 65, 65, 65, 68, 68, 68, 69, 70, 70, 71, 71, 76, 77, 78, 78, 79, 79, 79, 84, 85, 86, 88, 89, 90, 90, 90, 94, 95, 95, 95, 96, 97, 98, 100, 100] 
	 */
}
