
public class ABStack<T> {

	private T[] stack;
	int top;
	final int CAPACITY = 10;


	public ABStack() {
		top = -1;
		stack = (T[]) new Object[CAPACITY];
	}
}
