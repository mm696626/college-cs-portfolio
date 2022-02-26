
public class TestProgram {

	public static void main(String[] args) {
		BinaryTree<Character> treex = new BinaryTree<Character>('x',null,null);
		BinaryTree<Character> treey = new BinaryTree<Character>('y',null,null);
		BinaryTree<Character> operator1 = new BinaryTree<Character>('+',treex,treey);
		
		BinaryTree<Character> treea = new BinaryTree<Character>('a',null,null);
		BinaryTree<Character> treeb = new BinaryTree<Character>('b',null,null);
		BinaryTree<Character> operator2 = new BinaryTree<Character>('/',treea,treeb);
		
		BinaryTree<Character> operator = new BinaryTree<Character>('*',operator1,operator2);
		//operator.preOrder();
		//operator.inOrder();
		operator.postOrder();

	}

}
