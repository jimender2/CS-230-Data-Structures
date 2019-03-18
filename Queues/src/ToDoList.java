
public class ToDoList {

	public static void main(String[] args) {

		PQueue<Task> toDoList = new PQueue<Task>();
		
		toDoList.enqueue( new Task( "", 'B', 1));
		toDoList.enqueue( new Task( "", 'C', 1));
		toDoList.enqueue( new Task( "", 'B', 2));
		toDoList.enqueue( new Task( "", 'A', 1));
		toDoList.enqueue( new Task( "", 'C', 3));
		toDoList.enqueue( new Task( "", 'C', 2));

		while( !toDoList.isEmpty())
				System.out.println( toDoList.dequeue());
		
		

	}

}
