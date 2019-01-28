import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PreferredCustomerDriver {

	public static void main(String args[]) throws FileNotFoundException {

		File fileName = new File("customers.txt");

		Scanner file = new Scanner(fileName);

		String input,
				split[] = new String[6];
		
		Boolean bool = false;
		
		double purchaseAmount = 0.0;
		
		ArrayList<PreferredCustomer> myList = new ArrayList<>();

		while (file.hasNextLine()) {
			input = file.nextLine();

			split = input.split(";");

			split[4] = split[4].toLowerCase();
			
			if (split[4] == "true") {
				bool = true;
			} else {
				bool = false;
			}

			purchaseAmount = Double.parseDouble(split[5]);

			myList.add(new PreferredCustomer(split[0], split[1], split[2],
					split[3], bool, purchaseAmount));
		}
		
		
		System.out.println(myList.get(0).toString());
		System.out.println(myList.get(1).toString());
		System.out.println(myList.get(2).toString());

	}

}