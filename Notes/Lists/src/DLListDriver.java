
public class DLListDriver {

	public static void main(String[] args) {

		DLList<String> names = new DLList<String>();

		names.insert("Bob");
		System.out.println( names);
		names.remove( "Bob");
		System.out.println( names);
		names.insert("Mary");
		System.out.println( names);
		names.insertAtFront( "John");
		System.out.println( names);
		names.insertAtBack( "Jack");
		System.out.println( names);
		names.remove( "Mary");
		names.remove( "Jack");
		System.out.println( names);
		if( names.contains( "Mary"))
			System.out.println( "Found it");
		else
			System.out.println( "Not found");
		names.remove("Jim");
		names.remove("John");
		System.out.println( names);

	}
}
