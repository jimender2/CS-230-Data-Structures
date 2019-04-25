import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellCheck {

	public static void main(String args[]) throws FileNotFoundException {
		BST<String> dictionary = new BST<>();
		Scanner file = new Scanner(new File ("words.txt"));
		while (file.hasNext()) {
			dictionary.insert(file.nextLine());
		}
		file.close();

		BST<String> misspelled = new BST<>();
		Scanner scan = new Scanner(new File ("sampleText.txt"));
		while (scan.hasNext()) {
			String temp = scan.nextLine().replaceAll("[.,]", "");
			String[] array = temp.split(" ");
			for(int i = 0; i < array.length; i++)
				if( !dictionary.searchFor(array[i]))
					misspelled.insert(array[i]);
		}
		scan.close();

		if (misspelled.isEmpty())
			System.out.println("There are no misspelled words");
		else
			misspelled.inOrderTraversal();
	}
}