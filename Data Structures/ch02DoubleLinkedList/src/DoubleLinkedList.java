public class DoubleLinkedList {
	private static class Node{
		private String info;
		private Node next;
		private Node prev;
		
		private Node(String value) {
			info = value;
			next = null;
			prev = null;
		}
		
		private Node(String value, Node nextItem, Node prevItem) {
			info = value;
			next = nextItem;
			prev = prevItem;
		}
	}
	
	private Node head = null;
	private Node tail = null;
	private int size = 0;

	
	
	
	
	public DoubleLinkedList() {
		head = null;
		tail = null;
	}
	
	public void addFirst(String value) {
		if(size == 0) {
			head = new Node(value);
			tail = head;
		}
		else { 
			Node a = new Node(value,head,null);
			head.prev = a;
			head = a;
		}
		size++;
	}
	
	public void addLast(String value) {
		if(size == 0) {
			head = new Node(value);
			tail = head;
		}
		else {
			Node a = new Node(value,null,tail);
			tail.next = a;
			tail = a;
		}
		size++;
	}
	
	private String removeFirst() { 
		if(size <=0) {
			System.out.println("Invalid Method Call");
		}
		
		String oldValue = head.info;
		if(size > 1) {
			head = head.next;
			head.prev.next = null;
			head.prev = null;
		}
		else {
			head = null;
			tail = null;
		}
		size--;
		return oldValue;	
	}
	
	public String removeLast() {
		String old = tail.info;
		if(size > 1) {
			tail = tail.prev;
			tail.next.prev = null;
			tail.next = null;
		} else {
			head = null;
			tail = null;
		}
		size--;
		return old;
	}
	
	public void traverseRound() {
		if(size > 0) {
			Node nodeRef = head;
			while(nodeRef!= null) { 
				System.out.print(nodeRef.info + " ");
				nodeRef = nodeRef.next;
			}
			System.out.println();
			nodeRef = tail;
			while(nodeRef!= null) {
				System.out.print(nodeRef.info + " ");
				nodeRef = nodeRef.prev;
			}
			System.out.println();
		}
		else {
			System.out.println("Empty List");
		}
	}
	
	private Node getRef2Node(int index) {
		if(index < 0 || index >=size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		Node ref = head;
		for(int i = 0; i < size; i++) {
			ref = ref.next;
		}
		return ref;
	}
	
	public void add(int index, String value) {
		if(index == 0) {
			addFirst(value);
		} else {
			if(index == size) {
				addLast(value);
			}
			else {
				Node ref = getRef2Node(index);
				Node newnode = new Node(value,ref,ref.prev);
				ref.prev.next = newnode;
				ref.prev = newnode;
				size++;
			}
		}
	}
	
	public String remove(int index) {
		if(index == 0) return removeFirst();
		if(index == size -1) return removeLast();
		Node cur = getRef2Node(index);
		String old = cur.info;		
		cur.prev.next = cur.next;
		cur.next.prev = cur.prev;
		cur.prev = null; //optional
		cur.next = null; //optional
		size--;
		return old;
	}
}
