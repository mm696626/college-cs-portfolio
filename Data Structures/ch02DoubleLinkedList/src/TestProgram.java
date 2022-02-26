
public class TestProgram {

	public static void main(String[] args) {
		DoubleLinkedList testList = new DoubleLinkedList();
		testList.add(0, "Alice");
		testList.add(1, "Cher");
		testList.add(2, "David");
		testList.add(3, "Ellen");
		testList.add(1, "Bob");
		testList.traverseRound();
		System.out.println();
		testList.remove(2);
		testList.traverseRound();
		
		

	}

}
