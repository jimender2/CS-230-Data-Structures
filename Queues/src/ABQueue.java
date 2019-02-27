public class ABQueue<T> {

	private int back;
	private int front;
	private T [] queue;
	
	public ABQueue() {
		
		back = 0;
		front = 0;
		queue = (T[]) new Object[100];
	}
	
	public ABQueue( int capacity) {
		
		back = 0;
		front = 0;
		if( capacity > 0)
			queue = (T[]) new Object[capacity];
		else
			queue = (T[]) new Object[100];
	}

	public void enqueue( T element) {
		
		if( isFull()) {
			T[] newQueue = (T[]) new Object[queue.length + 50];
			for(int index = 0 ; index < back; index++)
				newQueue[index] = queue[index];
			queue = newQueue;
		}
		queue[back] = element;
		back++;
		return;		
	}
	
	public T dequeue() {
		
		T item = null;
		if( isEmpty()) {
			System.out.println( "Empty queue...");
			return null;
		}
		item = queue[front];
		for( int i = 1; i < back; i++)
			queue[i-1] = queue[i];
		back--;
		return item;
	}

	public T peekAtFront() {
		
		T frontItem = null;
		
		if( isEmpty()) {
			System.out.println( "Queue is empty.");
			return frontItem;
		}
		frontItem = queue[front];
		
		return frontItem;
	}

	public T peekAtBack() {

		T backItem = null;
		
		if( isEmpty()) {
			System.out.println( "Queue is empty.");
			return backItem;
		}
		backItem = queue[back-1];
		
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
