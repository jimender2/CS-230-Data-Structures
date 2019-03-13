public class LQueue<T> {

	private Node<T> front;
	private Node<T> back;
	
	private class Node<T> {	
		private T data;
		private Node<T> next;
		
		public Node( T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public LQueue() {
		
		front = null;
		back = null;
	}
	
	public LQueue( LQueue<T> otherQueue) {
		
		if( otherQueue.isEmpty()) {
			System.out.println( "Incoming queue is empty");
		}
		else {
			this.front = null;
			this.back = null;			
			T dataValue;
			Node<T> currentNode = otherQueue.front;
			
		}
	}
	
	public void enqueue( T dataValue) {
		
		Node<T> newNode = new Node<T>( dataValue);
		
		
		
		return;
	}
	
	public T dequeue() {
		
		T item = null;
		
		
		
		return item;
	}
	
	public T peekAtFront() {
		
		T dataValue = null;
		
		if( isEmpty())
			System.out.println( "Queue is empty.");
		else
			dataValue = front.data;
					
		return dataValue;
	}
	
	public T peekAtBack() {
		
		T dataValue = null;
		
		if( isEmpty())
			System.out.println( "Queue is empty.");
		else
			dataValue = back.data;
		
		return dataValue;
	}

	public boolean isEmpty() {
		
		return( );
	}
	
	public int size() {

		int nodeCount = 0;

		return nodeCount;
	}
	
	public void reset() {
		
		this.front = null;
		this.back = null;
		this.nodeCount = 0;
		
		return;
	}

	public String toString() {
		
		String str = "";
		
		if( isEmpty()) {
			str = str + "Queue is empty...";
			return str;
		}
		
		Node<T> currentNode = front;	
		
		
		return str;
	}
}
