
public class StringLinkedList implements MyList{
	
	private static class Node{
		private String nodeValue;
		private Node nextNode;
		
		private Node(String value)
		{
			nodeValue = value;
			nextNode = null;
		}
		
		private Node(String value, Node nextItem)
		{
			nodeValue = value;
			nextNode = nextItem;
		}
	}
	
	private Node head = null;
	private int size = 0;
	
	public StringLinkedList() {
		head = null;
	}
	
	private void addFirst(String value)
	{
		head = new Node(value, head);
		size++;
	}
	
	private Node getRef2Node(int index)
	{
		if(index < 0 || index >= size)
		{
			throw new ArrayIndexOutOfBoundsException(index);
		}
		Node ref2Visit = head;
		for(int i=0; i<index; i++)
		{
			ref2Visit = ref2Visit.nextNode;
		}
		return ref2Visit;
		
	}
	@Override
	public void add(int index, String value) {
		if(index < 0 || index > size)
		{
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if(index == 0){
			addFirst(value);
		}
		else {
			Node ref2PreNode = getRef2Node(index-1);
			ref2PreNode.nextNode = new Node(value,ref2PreNode.nextNode);
			size++;
		}
		
	}

	@Override
	public void add(String value) {
		add(size,value);
		
	}

	@Override
	public String remove(int index) {
		String oldValue = null;
		if(index == 0)
		{
			oldValue = head.nodeValue;
			head = head.nextNode;
		}
		else
		{
			Node prevNode = getRef2Node(index-1);
			oldValue = prevNode.nodeValue;
			prevNode.nextNode = prevNode.nextNode.nextNode;
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
		Node ref = getRef2Node(index);
		String oldValue = ref.nodeValue;
		ref.nodeValue = value;
		return oldValue;
	}

	@Override
	public String get(int index) {
		if(index < 0 || index >= size)
		{
			throw new ArrayIndexOutOfBoundsException(index);
		}
		Node ref = getRef2Node(index);
		return ref.nodeValue;
		
	}
	
	public void traverse()
	{
		if(size > 0)
		{
			Node nodeRef = head;
			while(nodeRef != null)
			{
				System.out.print(nodeRef.nodeValue + " ");
				nodeRef = nodeRef.nextNode;
			}
		}
	}

}
