
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

			stack = (T[]) new Object[CAPACITY];
		}
		else
			stack = (T[]) new Object[capacity];

		top = -1;		
	}
	
	public void push ( T item) {

		if( isFull()) {
			int newSize = top + 1 + CAPACITY;
			T[] newStack = (T[]) new Object[newSize];

			for( int index = 0; index < top; index++)
				newStack[index] = stack[index];
			stack = newStack;
		}
		top++;
		stack[top] = item;
	}

	public boolean isFull() {

		if(stack.length -1 == top)
			return true;
		return false;
		
		// return( stack.length-1 == top);
	}
}
