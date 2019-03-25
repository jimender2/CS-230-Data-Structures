
public class ToDoList {

	public static void main(String[] args) {

		PQueue<Task> toDoList = new PQueue<Task>();
		
		toDoList.enqueue( new Task( "Go to the Movies", 'B', 1));
		toDoList.enqueue( new Task( "Do Homework", 'C', 1));
		toDoList.enqueue( new Task( "Do Dishes", 'B', 2));
		toDoList.enqueue( new Task( "Play Video Games", 'A', 1));
		toDoList.enqueue( new Task( "Practice Programming", 'C', 3));
		toDoList.enqueue( new Task( "Solve the Puzzle", 'C', 2));

		while( !toDoList.isEmpty())
				System.out.println( toDoList.dequeue());
		
		

	}

}
