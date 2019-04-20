import java.util.Scanner;

public class AddressBook {

	static Scanner scan = new Scanner(System.in);
	static LinkedList<Address> list = new LinkedList<>();
	static boolean saved = false;


	public static void main(String[] args) {
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
					System.out.println("It looks like your address book"
							+ "is not saved.");
					System.out.println("Would you like to save? (Y or N)");
					String s = scan.nextLine().toLowerCase();
					if (s.charAt(0) == 'Y')
						saveRecord();
				}
				selection = 0;
			}
		}
	}

	private static void printRecord() {
		LinkedList<Address> use = new LinkedList<Address>(list);
		System.out.println("Here are all of the addresses stored in your address book!!\n\n");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(use.removeFromFront() + "\n");
		}
	}

	private static void retrieveRecord() {
		clear();
	}

	private static void saveRecord() {
		clear();
	}

	private static void modifyRecord() {
		clear();

		boolean again = true;
		Address address = null;

		LinkedList<Address> tempList = new LinkedList<Address>(list);


		String lastName = scan.nextLine();
		for(int i = 0; i < list.size(); i++) {
			address = tempList.removeFromFront();
			if(address.getlName().toLowerCase().contentEquals(lastName)) {
				break;
			}
		}

		if(address == null) {
			System.out.println("I am sorry. It looks like there is not an"
					+ " entry that has a last name of " + lastName + ".");
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

			System.out.println("Type the number of the option you would"
					+ " like to perform.");
			String temp;
			int option;
			option = scan.nextInt();
			if(option == 1) {
				temp = scan.nextLine();
				address.setfName(temp);
			} else if(option == 2) {
				temp = scan.nextLine();
				address.setlName(temp);
			} else if(option == 3) {
				temp = scan.nextLine();
				address.setStreetAddress(temp);
			} else if(option == 4) {
				temp = scan.nextLine();
				address.setCity(temp);
			} else if(option == 5) {
				temp = scan.nextLine();
				address.setState(temp);
			} else if(option == 6) {
				temp = scan.nextLine();
				address.setZip(temp);
			} else if(option == 7) {
				temp = scan.nextLine();
				address.setCountry(temp);
			} else if(option == 8) {
				temp = scan.nextLine();
				address.setPhoneNumber(temp);
			} else if(option == 9) {
			}

			System.out.println("Would you like to make more changes to "
					+ "this entry? (Y or N)");
			String run = scan.next().toLowerCase();

			if(run.)
		}
		System.out.println("Here is your entry with the new changes:");
		list(address);


	}

	private static void deleteRecord() {
		clear();
	}

	private static void viewRecord() {
		clear();
	}

	private static void addRecord() {
		clear();
		boolean correct = false;

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

	}

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

	public static void print(String str) {
		System.out.println(str);
	}


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
		for(int i = 0; i < 100; i++)
			System.out.println();
	}

	public static void list(Address address) {
		print("First Name: " + address.getfName());
		print("Last Name:  " + address.getlName());
		print("Address:    " + address.getStreetAddress());
		print("City:       " + address.getCity());
		print("State:      " + address.getState());
		print("Zip Code:   " + address.getZip());
		print("Country:    " + address.getZip());
		print("Phone:      " + address.getPhoneNumber());
	}

}
