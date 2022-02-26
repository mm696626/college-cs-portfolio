import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> {
	private E[] data;
	private int capacity = 5;
	private int top = -1;
	
	public ArrayStack()
	{
		data = (E[]) new Object[capacity];
	}
	
	public void push(E item)
	{
		top++;
		if(top+1>capacity)
		{
			//internal array is full
			capacity = capacity *2;
			data = Arrays.copyOf(data, capacity);
		}
		data[top] = item;
	}
	
	public E pop()
	{
		if(top < 0)
		{
			//System.out.println("Empty stack");
			throw new EmptyStackException();
		}
		E oldValue = data[top];
		top--;
		return oldValue;
	}
	public E peek()
	{
		if(top < 0)
		{
			System.out.println("Empty stack");
			return null;
		}
		else
		{
			E oldValue = data[top];
			return oldValue;
		}
		
	}
	public int size()
	{
		return top+1;
	}
	public boolean empty()
	{
		if(top<0)
			return true;
		else
			return false;
	}
	
}

	
