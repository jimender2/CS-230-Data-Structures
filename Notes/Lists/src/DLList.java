public class DLList<T> {

	private class Node<T> {

		private T data;
		private Node<T> next;
		private Node<T> prev;

		public Node( T data) {

			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private int nodeCount;
	private Node<T> firstNode;

	public DLList() {

		this.firstNode = null;
		nodeCount = 0;
	}

	public DLList( DLList<T> otherList) {

		if( !otherList.isEmpty()) {

			Node<T> current = otherList.firstNode;
			this.insert( current.data);
			current = current.next;
		}
	}

	public int size() {

		return nodeCount;
	}

	public void reset() {

		this.nodeCount = 0;
		this.firstNode = null;

		return;
	}

	public boolean isEmpty() {

		return( nodeCount == 0);
	}

	public boolean insert(T element) {

		if( this.isEmpty())
			insertAtFront( element);
		else
			insertAtBack( element);

		return true;
	}

	public void insertAtFront( T element) {

		Node<T> newNode = new Node<T>( element);

		if( isEmpty()) {
			firstNode = newNode;
		}
		else {
			newNode.next = firstNode;
			firstNode.prev = newNode;
			firstNode = newNode;
		}
		nodeCount++;
		return;
	}

	public void insertAtBack( T element) {

		Node<T> newNode = new Node<T>( element);

		if( isEmpty())
			firstNode = newNode;
		else {
			Node<T> currentNode = firstNode;
			while( currentNode.next != null)
				currentNode = currentNode.next;
			newNode.prev = currentNode;
			currentNode.next = newNode;
		}
		nodeCount++;
		return;
	}

	public boolean remove(T target) {

		if( isEmpty()) {
			System.out.println( " List is empty.");
			return false;
		}

		Node<T> currentNode = firstNode;
		Node<T> trailCurrentNode = firstNode;
		while( currentNode != null && !currentNode.data.equals( target)) {
			trailCurrentNode = currentNode;
			currentNode = currentNode.next;
		}

		if( currentNode == null) {
			System.out.println( target + " not found");
			return false;
		}

		if( nodeCount == 1) {
			reset();
			return true;
		}

		if( currentNode == firstNode) {
			firstNode = firstNode.next;
			firstNode.prev = null;
			nodeCount--;
			return true;
		}

		if( currentNode.next == null) {
			trailCurrentNode.next = currentNode.next;
			currentNode.prev = null;
			nodeCount--;
			return true;
		}

		trailCurrentNode.next = currentNode.next;
		currentNode.prev = null;
		currentNode.next.prev = trailCurrentNode;
		nodeCount--;
		return true;
	}


	public boolean contains(T target) {

		if( isEmpty()) {
			System.out.println( " List is empty.");
			return false;
		}

		Node<T> currentNode = firstNode;

		while( currentNode != null && !currentNode.data.equals( target))
			currentNode = currentNode.next;

		if( currentNode == null) {
			System.out.println( target + " not found");
			return false;
		}
		else
			return true;
	}

	@Override
	public String toString() {

		String str = "";

		if( isEmpty()) {
			str = "List is empty";
			return str;
		}

		Node<T> current = firstNode;

		while( current != null) {
			str = str + current.data + " ";
			current = current.next;
		}
		return str;
	}
}
