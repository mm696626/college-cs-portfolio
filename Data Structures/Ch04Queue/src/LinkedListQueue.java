
public class LinkedListQueue<E> {

	private class Node<E>{
		E value;
		Node<E> next;
		
		public Node(E newItem, Node<E> ref) {
			value = newItem;
			next = ref;
		}
	}
	
	private Node<E> front;
	private Node<E> rear;
	private int size;
	
	
	
	public LinkedListQueue() {
		front = null;
		rear = null;
		size = 0;
	}
	
	public void offer(E item) {
		if(size == 0) 
		{
			front = new Node<E>(item,null);
			rear = front;
		}
		else
		{
			rear.next = new Node<E>(item,null);
			rear = rear.next;
		}
		
		size++;
	}
	public E poll() 
	{
		if(size == 0)
		{
			return null;
		}
		else
		{
			E dataValue = front.value;
			front = front.next;
			size--;
			return dataValue;
		}
	}
	public E peek()
	{
		if(size == 0)
		{
			return null;
		}
		else
		{
			return front.value;
		}
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		if(size == 0)
			return true;
		else
			return false;
	}
	
	
	
	
	
	
	
}
