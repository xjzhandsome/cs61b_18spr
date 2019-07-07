public class LinkedListDeque<T>{
	//define node;
	private class Node{
		public Node prev, next;
		// every item can be int, string, etc.
		public T item;
		// constructor of Node;
		public Node(T i, Node p, Node n){
			item = i;
			prev = p;
			next = n;
		}
	}

	private Node sentinel;
	private static int size;
	//empty LLD; only one sentinel node in this LLD;
	public LinkedListDeque(){
		this.sentinel = new Node(null, null, null);
		this.sentinel.prev = sentinel;
		this.sentinel.next = sentinel;
		size = 0;
	}
	/**specific methods of LLD are below;*/
	public int size(){
		return size;
	}

	public void addFirst(T item){
		Node p = sentinel;
		p.next = new Node(item, sentinel, sentinel.next);
		p.next.next.prev = p.next;
		size = size + 1;
	}

	public void addLast(T item){
		Node p = sentinel;
		//now, p.prev == last node;
		p.prev.next = new Node(item, p.prev, sentinel);
		p.prev = p.prev.next;
		size = size + 1;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public void printDeque(){
		if(size == 0){
			System.out.println("no items in LLD");
		}
		Node p = sentinel.next;
		while(p != sentinel){
			System.out.print(p.item + " ");
			p = p.next;
		}
		System.out.print('\n');
	}
	//return the front item of the deque;
	public T removeFirst(){
		if(size == 0){
			return null;
		}
		T front = sentinel.next.item;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		size = size - 1;
		return front;
	}	
	//return the last item of the deque;
	public T removeLast(){
		if(size == 0){
			return null;
		}
		T last = sentinel.prev.item;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		size = size - 1;
		return last;
	}
	/**
	 * Gets the item at the given index, where 0 is the front, 
	 * 1 is the next item, and so forth. If no such item exists, returns null. 
	 * Must not alter the deque!
	 */
	public T get(int index){
		if(size == 0){
			return null;
		}
		Node p = sentinel;
		for(int i = 0; i <= index; i++){
			p = p.next;
		}
		return p.item;
	}
	/**
	 * Same as get, but uses recursion.
	 */
	public T getRecursive(int index) {
		if(index == 0) {
			return sentinel.next.item;
		}
		Node p = sentinel.next;
		return getHelper(index, p);
	}

	private T getHelper(int index, Node p){
		if(index == 0) {
			return p.item;
		}
		p = p.next;
		return getHelper(index - 1, p);
	}

}