import java.util.ArrayDeque;

public class TestProgram {

	public static void main(String[] args) {
		System.out.println("Deque-based Stack 1:");
		ArrayDeque<Integer> stack1 = new ArrayDeque<Integer>();
		stack1.offerFirst(1);
		stack1.offerFirst(2);
		stack1.offerFirst(3);
		stack1.offerFirst(4);
		while(!stack1.isEmpty())
		{
			System.out.println(stack1.pollFirst());
		}
		
		
		
		System.out.println("Deque-based Stack 2:");
		ArrayDeque<Integer> stack2 = new ArrayDeque<Integer>();
		stack2.offerLast(1);
		stack2.offerLast(2);
		stack2.offerLast(3);
		stack2.offerLast(4);
		
		while(!stack2.isEmpty())
		{
			System.out.println(stack2.pollLast());
		}
		
		System.out.println("Deque-based Queue 1:");
		ArrayDeque<Integer> queue1 = new ArrayDeque<Integer>();
		queue1.offerFirst(1);
		queue1.offerFirst(2);
		queue1.offerFirst(3);
		queue1.offerFirst(4);
		while(!queue1.isEmpty())
		{
			System.out.println(queue1.pollLast());
		}

	}

}
