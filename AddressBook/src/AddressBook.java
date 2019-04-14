import java.util.Scanner;

public class AddressBook {

	static Scanner scan = new Scanner(System.in);
	LinkedList<Address> list = new LinkedList<Address>();


	public static void main(String[] args) {
		int selection = 0;
		while(selection != 8) {

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
		}
	}

	private static void printRecord() {

	}

	private static void retrieveRecord() {

	}

	private static void saveRecord() {

	}

	private static void modifyRecord() {

	}

	private static void deleteRecord() {

	}

	private static void viewRecord() {

	}

	private static void addRecord() {

	}

	public static void printOptions() {

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
}
