import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Jonathan Meredith
 *
 */
public class AddressBook {

	static Scanner scan = new Scanner(System.in);
	static LinkedList<Address> list = new LinkedList<>();
	static boolean saved = false;

	public static void main(String[] args) throws FileNotFoundException {

		fileRead();

		int selection = -1;

		while(selection != 0) {

			printOptions();

			selection = getNumber();

			if(selection == 1)
				addRecord();
			else if(selection == 2)
				viewRecord();
			else if(selection == 3)
				deleteRecord();
			else if(selection == 4)
				modifyRecord();
			else if(selection == 5)
				saveRecord();
			else if(selection == 6)
				retrieveRecord();
			else if(selection == 7)
				printRecord();
			else if(selection == 8) {
				if (!saved){
					print("It looks like your address book"
							+ "is not saved.");
					print("Would you like to save? (Y or N)");
					String s = scan.nextLine().toLowerCase();
					if (s.charAt(0) == 'Y')
						saveRecord();
				}
				selection = 0;
			}
		}
	}

	/**
	 * @throws FileNotFoundException
	 *
	 */
	private static void fileRead() throws FileNotFoundException {

		Scanner file = new Scanner(new File("addresses.txt"));

		while(file.hasNext()) {
			Address address = new Address();

			address.setfName(file.nextLine());
			address.setlName(file.nextLine());
			address.setStreetAddress(file.nextLine());
			address.setCity(file.nextLine());
			address.setState(file.nextLine());
			address.setZip(file.nextLine());
			address.setCountry(file.nextLine());
			address.setPhoneNumber(file.nextLine());

			file.nextLine();

			list.insertAtBack(address);

		}

		file.close();

	}

	/**
	 *
	 */
	private static void printRecord() {
		LinkedList<Address> tempAddress = new LinkedList<>(list);
		print("Here are all of the addresses stored in your address book!!\n\n");
		for(int i = 0; i < list.size(); i++) {
			print(i+1 + ". " +tempAddress.removeFromFront().toString());
		}
		pause();
	}

	/**
	 *
	 */
	private static void retrieveRecord() {
		clear();

		Address address = null;

		LinkedList<Address> tempList = new LinkedList<>(list);


		String zip = scan.nextLine();
		for(int i = 0; i < list.size(); i++) {
			address = tempList.removeFromFront();
			if(address.getZip().toLowerCase().contentEquals(zip)) {
				break;
			}
		}

		if(address == null) {
			print("I am sorry. It looks like there is not an"
					+ " entry that has a zipcode of " + zip + ".");
			pause();
			return;
		}

		print(address.toString());
	}

	/**
	 *
	 */
	private static void saveRecord() {
		clear();
	}

	/**
	 *
	 */
	private static void modifyRecord() {
		clear();

		boolean again = true;
		Address address = null;

		LinkedList<Address> tempList = new LinkedList<>(list);

		String lastName = scan.nextLine();

		for(int i = 0; i < list.size(); i++) {
			address = tempList.removeFromFront();
			if(address.getlName().toLowerCase().contentEquals(lastName.toLowerCase())) {
				break;
			}
		}

		if(address == null) {
			print("I am sorry. It looks like there is not an"
					+ " entry that has a last name of " + lastName + ".");
			pause();
			return;
		}

		while(again) {
			int nextOp = 0;

			print("1. Change First Name");
			print("2. Change Last Name");
			print("3. Change Street Address");
			print("4. Change City");
			print("5. Change State");
			print("6. Change Zip Code");
			print("7. Change Country");
			print("8. Change Phone Number");
			print("9. Finished with changes");

			print("Type the number of the option you would"
					+ " like to perform.");
			String temp;
			int option;
			option = scan.nextInt();
			scan.nextLine();
			if(option == 1) {
				temp = scan.nextLine();
				print("Please enter the new first name: ");
				address.setfName(temp);
			} else if(option == 2) {
				print("Please enter the new last name: ");
				temp = scan.nextLine();
				address.setlName(temp);
			} else if(option == 3) {
				print("Please enter the new Street Address: ");
				temp = scan.nextLine();
				address.setStreetAddress(temp);
			} else if(option == 4) {
				print("Please enter the new City: ");
				temp = scan.nextLine();
				address.setCity(temp);
			} else if(option == 5) {
				print("Please enter the new State: ");
				temp = scan.nextLine();
				address.setState(temp);
			} else if(option == 6) {
				print("Please enter the new Zip Code: ");
				temp = scan.nextLine();
				address.setZip(temp);
			} else if(option == 7) {
				print("Please enter the new Country: ");
				temp = scan.nextLine();
				address.setCountry(temp);
			} else if(option == 8) {
				print("Please enter the new phone number: ");
				temp = scan.nextLine();
				address.setPhoneNumber(temp);
			} else if(option == 9) {
				break;
			}

			print("Would you like to make more changes to "
					+ "this entry? (Y or N)");
			String run = scan.next().toLowerCase();

			if( run.charAt(0) == 'y') {
				again = true;
			} else if (run.charAt(0) == 'n') {
				again = false;
			}

		}
		print("Here is your entry with the new changes:");
		list(address);

		pause();

	}

	/**
	 *
	 */
	private static void deleteRecord() {
		clear();

		LinkedList<Address> tempList = new LinkedList<>(list);
		Address address = null;

		String lastName = scan.nextLine();
		for(int i = 0; i < list.size(); i++) {
			address = tempList.removeFromFront();
			if(address.getlName().toLowerCase().contentEquals(lastName)) {
				list.remove(address);
				print("The entry with the last name of " + lastName + " "
						+ "has been removed.");
			}
		}

		if(address == null) {
			print("I am sorry. It looks like there is not an"
					+ " entry that has a last name of " + lastName + ".");
		}

		pause();
	}

	/**
	 *
	 */
	private static void viewRecord() {
		clear();

		Address address = null;

		LinkedList<Address> tempList = new LinkedList<>(list);


		String lastName = scan.nextLine();
		for(int i = 0; i < list.size(); i++) {
			address = tempList.removeFromFront();
			if(address.getlName().toLowerCase().contentEquals(lastName)) {
				break;
			}
		}

		if(address == null) {
			print("I am sorry. It looks like there is not an"
					+ " entry that has a last name of " + lastName + ".");
			pause();
			return;
		}

		pause();
		print(address.toString());
	}

	/**
	 *
	 */
	private static void addRecord() {
		clear();
		boolean correct = false;

		while(!correct) {
			print("I will interactivly guide you to create an entry in "
					+ "your address book.");
			print("");

			print("What is the first name of the entry?");
			String fName = scan.nextLine();

			print("What is the last name of the entry?");
			String lName = scan.nextLine();

			print("What is the street address of the entry?");
			String streetAddress = scan.nextLine();

			print("What is the city of the entry?");
			String city = scan.nextLine();

			print("What is the state of the entry?");
			String state = scan.nextLine();

			print("What is the zip code of the entry?");
			String zip = scan.nextLine();

			print("What is the country of the entry?");
			String country = scan.nextLine();

			print("What is the phone number of the entry?");
			String phoneNumber = scan.nextLine();

			Address address = new Address(fName, lName, streetAddress,
					city, state, zip, country, phoneNumber);

			print("Is the following information correct? (Y or N)");
			print("");

			list(address);

			String temp = scan.nextLine().toLowerCase();

			if (temp.charAt(0) == 'y') {
				correct = true;
				list.insertAtBack(address);
			}

		}
	}

	/**
	 *
	 */
	public static void printOptions() {
		clear();
		print("Please Select a Number Below:");
		print("1. Add a new address record");
		print("2. View an existing address record");
		print("3. Delete an existing address record");
		print("4. Modify an existing address record");
		print("5. Save the entire address book in a file");
		print("6. Retrieve all address entries using zip code");
		print("7. Print the entire address book on the screen");
		print("8. Exit the program");
	}

	/**
	 * @param str
	 */
	public static void print(String str) {
		System.out.println(str);
	}


	/**
	 * @return
	 */
	public static int getNumber() {
		int num = 0;
		boolean again = true;

		while (again) {
			System.out.print("Please enter a valid option from above:");
			try {
				num = scan.nextInt();
				System.out.println();
				if (num >= 1 && num <= 8) {
					scan.nextLine();
					return num;
				} else {
					System.out.println("I'm sorry, the year you entered"
							+ " was invalid. Please try again.");
				}
			} catch (Exception InputMismatchException) {
				System.out.println();
				System.out.println("I'm sorry, what you entered was not a "
						+ "valid year. Please try again.");
				scan.next();
			}

		}
		return num;
	}

	public static void clear() {
		for(int i = 0; i < 2; i++)
			print("");
	}

	public static void pause() {
		print("");
		print("");
		print("Press the enter key to continue");
		scan.nextLine();

	}
	public static void list(Address address) {
		print("First Name: " + address.getfName());
		print("Last Name:  " + address.getlName());
		print("Address:    " + address.getStreetAddress());
		print("City:       " + address.getCity());
		print("State:      " + address.getState());
		print("Zip Code:   " + address.getZip());
		print("Country:    " + address.getCountry());
		print("Phone:      " + address.getPhoneNumber());
	}

}
