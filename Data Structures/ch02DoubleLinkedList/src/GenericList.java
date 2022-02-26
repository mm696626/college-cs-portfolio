public class GenericList<E> {
		private static class Node<E>{
			private E info;
			private Node<E> next;
			private Node<E> prev;
			
			private Node(E value) {
				info = value;
				next = null;
				prev = null;
			}
			
			private Node(E value, Node<E> nextItem, Node<E> prevItem) {
				info = value;
				next = nextItem;
				prev = prevItem;
			}
		}
		
		private Node<E> head = null;
		private Node<E> tail = null;
		private int size = 0;

		
		
		
		
		public GenericList() {
			head = null;
			tail = null;
		}
		
		public void addFirst(E value) {
			if(size == 0) {
				head = new Node<E>(value);
				tail = head;
			}
			else { 
				Node<E> a = new Node<E>(value,head,null);
				head.prev = a;
				head = a;
			}
			size++;
		}
		
		public void addLast(E value) {
			if(size == 0) {
				head = new Node<E>(value);
				tail = head;
			}
			else {
				Node<E> a = new Node<E>(value,null,tail);
				tail.next = a;
				tail = a;
			}
			size++;
		}
		
		private E removeFirst() { 
			if(size <=0) {
				System.out.println("Invalid Method Call");
			}
			
			E oldValue = head.info;
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
		
		public E removeLast() {
			E old = tail.info;
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
				Node<E> nodeRef = head;
				while(nodeRef!= null) { 
					System.out.println(nodeRef.info + " ");
					nodeRef = nodeRef.next;
				}
				System.out.println();
				nodeRef = tail;
				while(nodeRef!= null) {
					System.out.println(nodeRef.info + " ");
					nodeRef = nodeRef.prev;
				}
				System.out.println();
			}
			else {
				System.out.println("Empty List");
			}
		}
		
		private Node<E> getRef2Node(int index) {
			if(index < 0 || index >=size) {
				throw new ArrayIndexOutOfBoundsException(index);
			}
			
			Node<E> ref = head;
			for(int i = 0; i < size; i++) {
				ref = ref.next;
			}
			return ref;
		}
		
		public void add(int index, E value) {
			if(index == 0) {
				addFirst(value);
			} else {
				if(index == size) {
					addLast(value);
				}
				else {
					Node<E> ref = getRef2Node(index);
					Node<E> newnode = new Node<E>(value,ref,ref.prev);
					ref.prev.next = newnode;
					ref.prev = newnode;
					size++;
				}
			}
		}
		
		public E remove(int index) {
			if(index == 0) return removeFirst();
			if(index == size -1) return removeLast();
			Node<E> cur = getRef2Node(index);
			E old = cur.info;		
			cur.prev.next = cur.next;
			cur.next.prev = cur.prev;
			cur.prev = null; //optional
			cur.next = null; //optional
			size--;
			return old;
		}
	}


