
public class CQueue<T> {


	private int back;
	private int front;
	private int size;
	private T [] queue;
	
	public CQueue() {
		
		back = 0;
		front = 0;
		size = 0;
		queue = (T[]) new Object[100];
	}
	
	public CQueue( int capacity) {
		
		back = 0;
		front = 0;
		size = 0;
		if( capacity > 0)
			queue = (T[]) new Object[capacity];
		else
			queue = (T[]) new Object[100];
	}
	
	public void enqueue( T element) {
		
		if( isFull()) {
			T[] newQueue = (T[]) new Object[queue.length + 50];
			for(int index = 0 ; index < queue.length; index++)
				newQueue[index] = queue[index];
			back = queue.length;
			queue = newQueue;
		}
		queue[back] = element;
		back = (back+1) % queue.length;
		size++;
		return;		
	}
	
	public T dequeue() {
		
		T item = null;
		if( isEmpty()) {
			System.out.println( "Empty queue...");
			return null;
		}
		item = queue[front];
		front = (front + 1) % queue.length;
		size--;
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
		if( back == 0 )
			backItem = queue[queue.length-1];
		else
			backItem = queue[back-1];
		
		return backItem;
	}
	
	public String toString() {
		
		String str = "[ ";
		
		if( front < back)
			for( int index = front ; index < back ; index++ )
				str = str + queue[index] + " ";
		else {
			int index = front;
			while( index < queue.length) {
				str = str + queue[index] + " ";
				index++;
			}
			for( index = 0 ; index < back ; index++)
				str = str + queue[index] + " ";
		}
		str += "]";
		
		return str;
	}

	public int size() {
		
		return( size);
	}
	
	public boolean isFull() {
		
		return( size == queue.length);
	}

	public boolean isEmpty() {
		
		return( size == 0);
	}
}
