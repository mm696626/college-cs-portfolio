public class DoubleLinkedListQueue<E> {

	private class Node<E>{
		E value;
		Node<E> next;
		Node<E> prev;
		
		public Node(E newItem, Node<E> ref, Node<E> ref2) {
			value = newItem;
			next = ref;
			prev = ref2;
		}
	}
	
	private Node<E> front;
	private Node<E> rear;
	private int size;
	
	
	
	public DoubleLinkedListQueue() {
		front = null;
		rear = null;
		size = 0;
	}
	
	public void offer(E item) {
		if(size == 0) 
		{
			front = new Node<E>(item,null,null);
			rear = front;
		}
		else
		{
			rear.next = new Node<E>(item,null,rear);
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
			front.prev = null;
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
