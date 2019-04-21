import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Jonathan Meredith
 *
 */
public class AddressBook {

	static Scanner scan = new Scanner(System.in);
	static LinkedList<Address> list = new LinkedList<>();
	static boolean saved = true;

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
					java.awt.Toolkit.getDefaultToolkit().beep();
					print("It looks like your address book "
							+ "is not saved.");
					print("Would you like to save? (Y or N)");
					String s = scan.nextLine().toLowerCase();
					if (s.charAt(0) == 'y')
						saveRecord();
				}
				selection = 0;
			}
		}
		clear();
		title();
		print("");
		print("");
		print("Thank you for using the Address Book. Feel free to open "
				+ "me up again in order to look something up or to store "
				+ "things.");
	}

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

	private static void printRecord() {
		clear();
		LinkedList<Address> tempAddress = new LinkedList<>(list);
		print("Here are all of the addresses that are in your address "
				+ "book");
		print("");
		for(int i = 0; i < list.size(); i++) {
			Address address = tempAddress.removeFromFront();
			print(address.getfName() + " " + address.getlName());
			print(address.getStreetAddress());
			print(address.getCity() + ", " + address.getState() + " "
					+ address.getZip());
			print(address.getCountry());
			print(address.getPhoneNumber());
			print("");
		}
		pause();
	}

	private static void retrieveRecord() {
		clear();

		Address address = null;

		LinkedList<Address> tempList = new LinkedList<>(list);

		print("What is the zip code of the person you want to look up?");
		String zip = scan.nextLine();
		for(int i = 0; i < list.size(); i++) {
			address = tempList.removeFromFront();
			if(address.getZip().toLowerCase().contentEquals(
					zip.toLowerCase())) {
				print(address.toString());
				break;
			}
		}

		if(address == null) {
			print("I am sorry. It looks like there is not an entry that "
					+ "has a zipcode of " + zip + ".");
			pause();
			return;
		}

		pause();
	}

	private static void saveRecord() throws FileNotFoundException {
		clear();

		print("I am saving your address book.... Please do not exit the "
				+ "program or turn off your computer.");

		LinkedList<Address> tempAddress = new LinkedList<>(list);

		PrintWriter print = new PrintWriter("addresses.txt");
		for(int i = 0; i < list.size(); i++) {
			Address address = tempAddress.removeFromFront();
			print.println(address.getfName());
			print.println(address.getlName());
			print.println(address.getStreetAddress());
			print.println(address.getCity());
			print.println(address.getState());
			print.println(address.getZip());
			print.println(address.getCountry());
			print.println(address.getPhoneNumber());
			print.println();
		}

		print.close();

		saved = true;
		print("I am finished saving your address book.");

		pause();

	}

	private static void modifyRecord() {
		clear();

		boolean again = true;
		Address address = null;

		LinkedList<Address> tempList = new LinkedList<>(list);

		print("Please enter the last name of the entry that you wish to "
				+ "modify: ");
		String lastName = scan.nextLine();

		for(int i = 0; i < list.size(); i++) {
			address = tempList.removeFromFront();
			if(address.getlName().toLowerCase().contentEquals(
					lastName.toLowerCase())) {
				while(again) {

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
						saved = false;

					} else if(option == 2) {
						print("Please enter the new last name: ");
						temp = scan.nextLine();
						address.setlName(temp);
						saved = false;

					} else if(option == 3) {
						print("Please enter the new Street Address: ");
						temp = scan.nextLine();
						saved = false;
						address.setStreetAddress(temp);

					} else if(option == 4) {
						print("Please enter the new City: ");
						temp = scan.nextLine();
						address.setCity(temp);
						saved = false;

					} else if(option == 5) {
						print("Please enter the new State: ");
						temp = scan.nextLine();
						address.setState(temp);
						saved = false;

					} else if(option == 6) {
						print("Please enter the new Zip Code: ");
						temp = scan.nextLine();
						address.setZip(temp);
						saved = false;

					} else if(option == 7) {
						print("Please enter the new Country: ");
						temp = scan.nextLine();
						address.setCountry(temp);
						saved = false;

					} else if(option == 8) {
						print("Please enter the new phone number: ");
						temp = scan.nextLine();
						address.setPhoneNumber(temp);
						saved = false;

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
				return;
			}
		}

		if(address == null) {
			print("I am sorry. It looks like there is not an entry that "
					+ "has a last name of " + lastName + ".");
			pause();
			return;
		}

		print("I am sorry. It looks like there is not an entry that "
				+ "has a last name of " + lastName + ".");
		pause();
		return;
	}

	private static void deleteRecord() {
		clear();

		LinkedList<Address> tempList = new LinkedList<>(list);
		Address address = null;

		print("Please enter the last name of the entry that you wish to "
				+ "delete");
		String lastName = scan.nextLine();
		for(int i = 0; i < list.size(); i++) {
			address = tempList.removeFromFront();
			if(address.getlName().toLowerCase().contentEquals(
					lastName.toLowerCase())) {
				list.remove(address);
				saved = false;
				print("The entry with the last name of " + lastName + " "
						+ "has been removed.");
				pause();
				return;
			}
		}

		if(address == null) {
			print("I am sorry. It looks like there is not an entry that "
					+ "has a last name of " + lastName + ".");
			pause();
			return;
		}

		print("I am sorry. It looks like there is not an entry that "
				+ "has a last name of " + lastName + ".");

		pause();
	}

	private static void viewRecord() {
		clear();

		Address address = null;

		LinkedList<Address> tempList = new LinkedList<>(list);

		print("Please enter the last name of the person you want to look "
				+ "for:");
		String lastName = scan.nextLine();
		for(int i = 0; i < list.size(); i++) {
			address = tempList.removeFromFront();
			if(address.getlName().toLowerCase().contentEquals(
					lastName.toLowerCase())) {
				print(address.toString());
				pause();
				return;
			}
		}

		if(address == null) {
			print("I am sorry. It looks like there is not an"
					+ " entry that has a last name of " + lastName + ".");
			pause();
			return;
		}

		print("I am sorry. It looks like there is not an"
				+ " entry that has a last name of " + lastName + ".");
		pause();

	}

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

			clear();

			print("Is the following information correct? (Y or N)");
			print("");

			list(address);

			String temp = scan.nextLine().toLowerCase();

			saved = false;

			if (temp.charAt(0) == 'y') {
				correct = true;
				list.insertAtBack(address);
				print("This entry has been added to your address book.");
			}

		}
	}

	public static void printOptions() {
		clear();
		title();
		print("");
		print("");
		print("Please Select a Number Below:");
		print("1. Add a new address record");
		print("2. View an existing address record");
		print("3. Delete an existing address record");
		print("4. Modify an existing address record");
		print("5. Save the entire address book in a file");
		print("6. Retrieve all address entries using zip code");
		print("7. Print the entire address book on the screen");
		print("8. Exit the program");

		print("");
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
					System.out.println("I'm sorry, the option you entered"
							+ " was invalid. Please try again.");
				}
			} catch (Exception InputMismatchException) {
				System.out.println();
				System.out.println("I'm sorry, what you entered was not a"
						+ " valid option. Please try again.");
				scan.next();
			}

		}
		return num;
	}


	public static void clear() {
		for(int i = 0; i < 100; i++)
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

	public static void title() {
		print("   ___      _     _                    ______             _"
				+ "    ");
		print("  / _ \\    | |   | |                   | ___ \\           "
				+ "| |   ");
		print(" / /_\\ \\ __| | __| |_ __ ___  ___ ___  | |_/ / ___   ___ "
				+ "| | __");
		print(" |  _  |/ _` |/ _` | '__/ _ \\/ __/ __| | ___ \\/ _ \\ / _ "
				+ "\\| |/ /");
		print(" | | | | (_| | (_| | | |  __/\\__ \\__ \\ | |_/ / (_) | (_)"
				+ " |   < ");
		print(" \\_| |_/\\__,_|\\__,_|_|  \\___||___/___/ \\____/ \\___/ "
				+ "\\___/|_|\\_\\");

	}

}
