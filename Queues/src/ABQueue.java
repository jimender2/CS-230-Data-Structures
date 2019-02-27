public class ABQueue<T> {

	private int back;
	private int front;
	private T [] queue;
	
	public ABQueue() {
		
		back = 0;
		front = 0;
		queue = (T[]) new Object[1000];
	}
	
	public ABQueue( int capacity) {
		
		back = 0;
		front = 0;
		if( capacity > 0)
			queue = (T[]) new Object[capacity];
		else
			queue = (T[]) new Object[1000];
	}

	public void enqueue( T element) {
		
		if( isFull()) {
			System.out.println( "Queue is full.");
			return;
		}

		
	}
	
	public T dequeue() {
		
		if( isEmpty()) {
			System.out.println( "Empty queue...");
			return null;
		}
		
		
		return item;
	}

	public T peekAtFront() {
		
		T frontItem = null;
		
		
		
		return frontItem;
	}

	public T peekAtBack() {

		T backItem = null;
		
		
		
		return backItem;
	}
	
	public String toString() {
		
		String str = "[ ";
		
		if( !isEmpty())
			for( int index = 0 ; index < back ; index++ )
				str = str + queue[index] + " ";
		
		str += "]";
		
		return str;
	}

	public int size() {
		
		return( back-1);
	}
	
	public boolean isFull() {
		
		return( back == queue.length);
	}

	public boolean isEmpty() {
		
		return( back == 0);
	}
}
