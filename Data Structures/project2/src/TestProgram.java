
public class TestProgram {

	public static void main(String[] args) {
		StringArrayList testList = new StringArrayList();
		testList.add("Alice");
		testList.add("David");
		testList.add("Cher");
		testList.add("David");
		testList.add("David");
		testList.add("Ellen");
		testList.add(1,"Bob");
		testList.add(4,"Joseph");
		testList.set(4, "Hugh");
		
		testList.traverse();
		System.out.println("The element at index 3 is " + testList.get(3));
		System.out.println();
		System.out.println("After deleteRange (1,3)");
		testList.deleteRange(1,3);
		testList.traverse();
		System.out.println();
		testList.deleteAll("David");
		System.out.println("After deleteAll(David)");
		testList.traverse();
		System.out.println();
		System.out.println("The first instance of Hugh is at index " + testList.indexOf("Hugh"));
		System.out.println("The last instance of David is at index " + testList.lastIndexOf("David"));
		
		/*
		 *  Output:
		 *  0: Alice
			1: Bob
			2: David
			3: Cher
			4: Hugh
			5: David
			6: David
			7: Ellen
			The element at index 3 is Cher
			
			After deleteRange (1,3)
			0: Alice
			1: Cher
			2: Hugh
			3: David
			4: David
			5: Ellen
			
			After deleteAll(David)
			0: Alice
			1: Cher
			2: Hugh
			3: Ellen
			
			The first instance of Hugh is at index 2
			The last instance of David is at index -1

		 */
		
		
		

	}

}
