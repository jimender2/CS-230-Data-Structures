
public class ABStack<T> {

	private T[] stack;
	int top;
	final int CAPACITY = 10;


	public ABStack() {
		top = -1;
		stack = (T[]) new Object[CAPACITY];
	}

	public ABStack( int capacity) {

		if( capacity <= 0) {
			System.out.println( "Invalid capacity provided. Default capacity will be used.");
			top = -1;
			stack = (T[]) new Object[CAPACITY];
		}
		else {
			top = -1;
			stack = (T[]) new Object[capacity];
		}
		
	}
}
