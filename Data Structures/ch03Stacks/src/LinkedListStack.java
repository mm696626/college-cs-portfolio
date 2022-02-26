import java.util.EmptyStackException;
import java.util.LinkedList;

public class LinkedListStack<T> {

	private LinkedList<T> head = null;
	
	public LinkedListStack()
	{
		head = new LinkedList<T>();
	}
	
	public int size()
	{
		return head.size();
	}
	
	public void push(T item)
	{
		head.addFirst(item);
	}
	
	public T pop()
	{
		if(head.size() <=0)
		{
			throw new EmptyStackException();
		}
		return head.removeFirst();
	}
	
	public T peek()
	{
		if(head.size() <=0)
		{
			return null;
		}
		return head.getFirst();
	}
	
	public boolean empty()
	{
		if(head.size() <= 0)
			return true;
		else
			return false;
	}
}

