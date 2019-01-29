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

		Boolean bool;

		double purchaseAmount;

		ArrayList<PreferredCustomer> myList = new ArrayList<>();

		while (file.hasNextLine()) {

			input = file.nextLine();

			split = input.split("; ");

			split[4] = split[4].toLowerCase();

			if (split[4].equals("true")) {
				bool = true;

			} else {
				bool = false;

			}

			purchaseAmount = Double.parseDouble(split[5]);

			myList.add(new PreferredCustomer(split[0], split[1], split[2],
					split[3], bool, purchaseAmount));

		}

		file.close();

		System.out.println("Customer Name \t Customer’s Discount Level \t"
				+ " Customer’s Number\n============= \t "
				+ "========================= \t =================");

		int i = 0;

		while (i < myList.size()) {

			System.out.println(myList.get(i).name() + "\t\t\t" + 
								myList.get(i).getDiscount() + "\t\t\t" +
								myList.get(i).customerNumber());
			i++;
		}

		System.out.println("Program is done.");
		System.out.println("Bye!");
	}

}