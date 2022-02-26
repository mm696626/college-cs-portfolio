import java.util.Arrays;

public class StringArrayList implements MyList{
	private String[] theData;
	private static final int INITIAL_CAPACITY = 5;
	private int capacity = 0;
	private int size = 0;

	public StringArrayList()
	{
		theData = new String[INITIAL_CAPACITY];
		capacity = INITIAL_CAPACITY;
	}
	
	public void traverse()
	{
		for(int i=0; i<size; i++)
		{
			System.out.println(i + ": " + theData[i]);
		}
	}
	private void reallocate()
	{
		capacity = capacity * 2;
		theData = Arrays.copyOf(theData, capacity);
	}
	@Override
	public void add(int index, String value) {
		if(index < 0 || index >= size) 
		{
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if(size >= capacity) {
			reallocate();
		}
		for(int i= size-1; i>= index; i--)
		{
			theData[i+1] = theData[i];
		}
		theData[index] = value;
		size++;
		
	}

	@Override
	public void add(String value) {
		if(size < capacity) {
			//current array is not full
			theData[size] = value;
		}
		else
		{
			//current internal array is full
			reallocate();
			theData[size] = value;
		}
		size++;
		
	}

	@Override
	public String remove(int index) 
	{
		if(index < 0 || index >= size) 
		{
			throw new ArrayIndexOutOfBoundsException(index);
		}
		String oldValue = theData[index];
		for(int i = index+1; i<size; i++)
		{
			theData[i-1] = theData[i];
		}
		size--;
		return oldValue;
	}

	@Override
	public String set(int index, String value) {
		if(index < 0 || index >= size) 
		{
			throw new ArrayIndexOutOfBoundsException(index);
		}
		String oldValue = theData[index];
		theData[index] = value;
		return oldValue;
	}

	@Override
	public String get(int index) {
		if(index < 0 || index >= size) 
		{
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theData[index];
	}
	
	public void deleteRange(int fromIndex, int toIndex)
	{
		if(fromIndex < 0 || fromIndex > toIndex || fromIndex >= size) 
		{
			throw new ArrayIndexOutOfBoundsException(fromIndex);
		}
		if(toIndex < fromIndex || toIndex >= size) 
		{
			throw new ArrayIndexOutOfBoundsException(toIndex);
		}
		
		for(int i=fromIndex; i<toIndex; i++)
		{
			remove(fromIndex);
		}
	}
	public void deleteAll(String str)
	{
		for(int i=size-1; i>=0; i--)
		{
			if(theData[i].equals(str))
				remove(i);
		}
	}
	public int indexOf(String str)
	{
		for(int i=0; i<size; i++)
		{
			if(theData[i].equals(str))
				return i;
		}
		return -1;
	}
	public int lastIndexOf(String str)
	{
		for(int i=size-1; i>=0; i--)
		{
			if(theData[i].equals(str))
				return i;
		}
		return -1;
	}
	
	

}