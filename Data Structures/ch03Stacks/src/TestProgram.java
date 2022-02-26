import java.util.Stack;

public class TestProgram {

	public static void main(String[] args) {
		Stack<Integer> javaStack = new Stack<Integer>();
		javaStack.push(5);
		javaStack.push(3);
		System.out.println("Peek: " + javaStack.peek());
		System.out.println("Pop: " + javaStack.pop());
		System.out.println("The number of elements is: " + javaStack.size());
		javaStack.pop();
		if(!javaStack.empty())
			javaStack.pop();
		
		System.out.println("My own stack class' outputs:");
		ArrayStack<Integer> myArrayStack = new ArrayStack<Integer>();
		myArrayStack.push(5);
		myArrayStack.push(3);
		System.out.println("Peek: " + myArrayStack.peek());
		System.out.println("Pop: " + myArrayStack.pop());
		System.out.println("The number of elements is: " + myArrayStack.size());
		myArrayStack.pop();
		if(!myArrayStack.empty())
			myArrayStack.pop();
		
		System.out.println("My own linked list stack class' outputs:");
		LinkedListStack<Integer> mylistStack = new LinkedListStack<Integer>();
		mylistStack.push(5);
		mylistStack.push(3);
		System.out.println("Peek: " + mylistStack.peek());
		System.out.println("Pop: " + mylistStack.pop());
		System.out.println("The number of elements is: " + mylistStack.size());
		mylistStack.pop();
		if(!mylistStack.empty())
			mylistStack.pop();
		
	}

}
