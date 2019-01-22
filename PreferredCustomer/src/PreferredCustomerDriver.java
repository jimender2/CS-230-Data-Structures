import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PreferredCustomerDriver {

	public static void main(String args[]) throws FileNotFoundException {

		File fileName = new File("customers.txt");

		Scanner file = new Scanner(fileName);

		String input,
				split[];

		while (file.hasNextLine()) {
			input = file.nextLine();

			split = input.split(";");
			
		}
	}

}
