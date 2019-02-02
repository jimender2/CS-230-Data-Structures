/**
 * 
 */

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

		System.out.printf("%-20s %-30s %-20s%n", "Customer Name",
				"Customer’s Discount Level", "Customer’s Number");
		System.out.printf("%-20s %-30s %-20s%n", "=============",
				"=========================", "=================");
		int i = 0;

		while (i < myList.size()) {

			System.out.printf("%-20s %-30s %-20s%n",
					myList.get(i).getName(),
					myList.get(i).getDiscount() + "%",
					myList.get(i).getCustomerNumber());
			i++;
		}

		System.out.println("");



		String mailingList = "",
				phoneList = "";

		i = 0;
		while (i< myList.size()) {

			if (myList.get(i).getMailingList()) {
				mailingList = mailingList + "\t" + myList.get(i).getName()
						+ "\n\t" + myList.get(i).getStreetAddress()
						+ "\n\t" + myList.get(i).getCity() + ", " 
						+ myList.get(i).getState() + " "
						+ myList.get(i).getZipCode() + "\n\n";
				
				phoneList = phoneList + "\t" + myList.get(i).getName()
						+ "\t" + myList.get(i).getPhoneNumber() + "\n";
			}

			i++;
		}

		System.out.println("Mailing List:");
		System.out.print(mailingList);
		
		System.out.println("Phone List:");
		System.out.println(phoneList);

		System.out.println("Program is done.");
		System.out.println("Bye!");
	}

}