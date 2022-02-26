public class IntLinkedList {

	private Node head = null;
	private int size = 0;
	
	private static class Node {
		private int data;
		private Node next;
		
		private Node(int dataItem){
			data = dataItem;
			next = null;
		}
		
		private Node(int dataItem, Node nodeRef){
			data = dataItem;
			next = nodeRef;
		}

	}
	
	public void addFirst(int dataItem){
		head = new Node(dataItem, head);
		size++;
	}
	
	public void traverse(){
		Node currentnode = head;
		while(currentnode != null){
			System.out.print(currentnode.data);
			currentnode = currentnode.next;
			if (currentnode != null){
				System.out.print(" ==> ");
			}
		}
		System.out.println(" ");
	}
	
	public Node getNode(int index){
		if(index < 0 || index >= size){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		Node currentnode = head;
		for(int i =0; i < index && currentnode != null; i++){
			currentnode = currentnode.next;
		}
		return currentnode;
	}
	
	public void add(int index, int dataItem){
		if(index < 0 || index > size){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if (index == 0){
			//insert at the head of the chain
			addFirst(dataItem);
		} else {
			Node prevnode = getNode(index-1);
			prevnode.next = new Node(dataItem, prevnode.next);
			size++;
		}
	}
	
	public void removeFirst(){
		Node targetnode = head;
		if (head != null){ 
			head = head.next;
		}
		if (targetnode != null){
			size--;
		}
	}
	
	public void remove(int index){
		if(index < 0 || index >= size){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if (index == 0){
			removeFirst();
		} else {
			Node prevnode = getNode(index-1);
			Node targetnode = prevnode.next;
			prevnode.next = targetnode.next;
			size--;		
		}
		
	}
	
	public static void showContent(Node nodeRef){
		if (nodeRef == null){
			System.out.print("null");
		} else{ 
			System.out.print(nodeRef.data);
		}
	}
	
	public int getLength(){
		return size; //length of a LinkedList is just size
	}
	
	public void addTail(int dataItem){
		add(size, dataItem);
	}
	
	public IntLinkedList copyList(){
		IntLinkedList newList = new IntLinkedList();
		if(size <= 0)
		{
			return null; //no list to copy
		}
		else
		{
			
			for(int i=0; i<size; i++)
			{
				int item = getNode(i).data;
				newList.add(i, item);
			}
		}
		return newList;
		
	}
	
	public Node findItem(int dataItem){

		for(int i=0; i<size; i++)
		{
			if(getNode(i).data == dataItem)
				return getNode(i);
		}
		return null;
	}
	
	public int maxValue(){
		int maxValue = head.data;
		for(int i=1; i<size; i++)
		{
			if(getNode(i).data>maxValue)
				maxValue = getNode(i).data;
		}
		return maxValue;
	}
	
	public IntLinkedList scaleBy(int n){
		Node currentnode = head;
		IntLinkedList copiedList = new IntLinkedList();
		while(currentnode != null){
			copiedList.addTail(currentnode.data*n);
			currentnode = currentnode.next;
		}
		return copiedList;
	}
	
	public IntLinkedList divisibleBy(int divisor){
		IntLinkedList newList = new IntLinkedList();
		if(size <= 0)
		{
			return null; //no list to copy
		}
		else
		{
			int counter=0; // may not necessarily be exact size as original
			for(int i=0; i<size; i++)
			{
				int item = getNode(i).data;
				if(getNode(i).data % divisor == 0)
				{
					newList.add(counter, item);
					counter++;
				}
			}
		}
		return newList;
		
	}
	
	
	public IntLinkedList filter(int n){
		IntLinkedList newList = new IntLinkedList();
		if(size <= 0)
		{
			return null; //no list to copy
		}
		else
		{
			int counter=0; // may not necessarily be exact size as original
			for(int i=0; i<size; i++)
			{
				int item = getNode(i).data;
				if(getNode(i).data!=n)
				{
					newList.add(counter, item);
					counter++;
				}
			}
		}
		return newList;
	}
	
	public IntLinkedList reverseCopy(){
		IntLinkedList newList = new IntLinkedList();
		if(size <= 0)
		{
			return null; //no list to copy
		}
		else
		{
			int index = 0;
			for(int i=size-1; i>=0; i--)
			{
				int item = getNode(i).data;
				newList.add(index, item);
				index++;
			}
		}
		return newList;
	}

}
