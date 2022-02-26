
public class CircularArrayQueue<T> {
	private T[] data;
	private int capacity = 5;
	private int front = 0;
	private int rear = -1;
	private int size = 0;
	
	
	public CircularArrayQueue()
	{
		data = (T[]) new Object[capacity];
	}
	
	public boolean offer(T item)
	{
		if(size == capacity)
		{
			System.out.println("The internal array is full");
			return false;
		}
		else
		{
			rear = (rear+1) % capacity;
			data[rear] = item;
			size++;
			return true;
		}
	}
	
	
	
	public boolean offer_autoIncrease(T item)
	{
		if(size == capacity)
		{
			System.out.println("Internal array is full; Create a new one");
			int newCapacity = capacity * 2;
			T[] data2 = (T[])new Object[newCapacity];
			
			
			int j = front;
			for(int i=0; i<size; i++)
			{
				data2[i] = data[j];
				j = (j+1)%capacity;
			}
			data = data2;
			front = 0;
			rear = size-1;
			capacity = newCapacity;
		}
		
		rear = (rear + 1) % capacity;
		data[rear] = item;
		size++;
		return true;
		
	}
	public T poll()
	{
		if(size == 0)
		{
			System.out.println("An empty queue");
			return null;
		}
		else
		{
			T oldValue = data[front];
			front = (front+1) % capacity;
			size--;
			return oldValue;
		}
	}
	
	
	public T peek()
	{
		if(size == 0)
		{
			System.out.println("An empty queue");
			return null;
		}
		else
		{
			return data[front];
		}
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		if(size==0)
			return true;
		else
			return false;
	}
	
	
	
}
