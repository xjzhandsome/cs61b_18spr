public class ArrayDeque<T>{
	private T[] items;
	private static int size;
	//if head = tail, which means the deque is empty;
	private int head = 4;
	private int tail = 4;
	private int space = 8;

	//constructor; create an empty ArrayDeque;
	public ArrayDeque(){
		items = (T []) new Object[space];
		size = 0;
	}
	// all methods of ArrayDeque;
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public static int size(){
		return size;
	}
	//calculate the position of next head item;
	public int minusOne(int index){
		return Math.floorMod(index - 1, items.length);
	}
	//calculate the position of next tail item;
	public int plusOne(int index){
		return Math.floorMod(index + 1, items.length);
	}

	public void resize(){
		if(size == items.length -1  ){
			expand();
		}
		if(size <= items.length / 4 && items.length >= 16){
			reduce();
		}
	}
	//get an items[] which has a doubled space;
	public void expand(){
		T[] tmp = (T []) new Object[space * 2];
		//firstly, copy the right items of the head;
		System.arraycopy(items, head, tmp, 0, items.length - head);
		//secondly, copy the left items of the head;
		System.arraycopy(items, 0, tmp, items.length - head, head);
		//reset head and tail;
		head = 0;
		tail = size;
		items = tmp;
	}
	//get items[], and size / items.length >= 0.25;
	public void reduce(){
		T[] tmp = (T []) new Object[size * 2];
		System.arraycopy(items, head, tmp, 0, items.length - head);
		System.arraycopy(items, 0, tmp, items.length - head, tail);
		head = 0;
		tail = size;
		items = tmp;
	}

	public void addFirst(T item){
		resize();
		items[minusOne(head)] = item;
		head = minusOne(head);
		size = size + 1;
	}

	public void addLast(T item){
		resize();
		items[tail] = item;		
		tail = plusOne(tail);
		size = size + 1;
	}

	public void printDeque(){
		if(size == 0){
			System.out.println("no items in ArrayDeque");
		}
		int tmp = head;
		for(int i = 0; i<= size - 1; i++){
			System.out.print(items[tmp] + " ");
			tmp = plusOne(tmp);
		}
		System.out.print("\n");
	}

	public T removeFirst(){
		resize();
		if(size == 0){
			return null;
		}
		T tmp = items[head];
		items[head] = null;
		head = plusOne(head);
		size = size - 1;
		return tmp;
	}

	public T removeLast(){
		resize();
		if(size == 0){
			return null;
		}
		T tmp = items[tail - 1];
		items[tail - 1] = null;
		tail = minusOne(tail);
		size = size - 1;
		return tmp; 
	}
	// get the index number of item in the begin with head;
	public T get(int index){
		if(size == 0){
			return null;
		}
		int tmp = head;
		for(int i = 0; i <= index; i++){
			tmp = plusOne(tmp);
		}
		return items[tmp];
	}
}
