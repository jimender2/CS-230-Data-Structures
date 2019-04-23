import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellCheck {

	public static void main(String args[]) throws FileNotFoundException {
		BST<String> dictionary = new BST<String>();
		Scanner file = new Scanner(new File ("words.txt"));
		while (file.hasNext()) {
			dictionary.insert(file.nextLine());
		}

		System.out.println("Done");
		System.out.println(dictionary.getLeafNodeCount());
		System.out.println(dictionary.getTreeHeight());
		System.out.println(dictionary.getNodeCount());
		dictionary.inOrderTraversal();
	}
}
