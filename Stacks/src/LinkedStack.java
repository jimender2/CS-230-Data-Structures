
public class LinkedStack<T> {

	private class Node<T>{
		private T data;
		private Node<T> next;

		public Node( T data) {
			this.data = data;
			this.next = null;
		}
	}

	Node<T> top;

	public LinkedStack() {
		top = null;
	}

	public void push( T data) {

		Node<T> newNode = new Node( data);

		
	}
}
