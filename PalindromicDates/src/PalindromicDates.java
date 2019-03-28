import java.util.Scanner;

/**
 *
 * @author Jonathan Meredith
 * This program reads in a year from the user and tells the user if that
 * year is a palindrome or not.  It also tells the user the first
 * palindromic date in the 21st century.
 */

public class PalindromicDates {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int i;
		int year;
		boolean again = true;

		while(again) {

			//Normal operations
			year = getNumber();
			execute(year, true);
			again = runAgain();

			//For Bonus points as stated in the assignment
			if(!again) {
				LQueue<Integer> queue = new LQueue<Integer>();
				i = 2000;
				while (i < 3000) {
					queue.enqueue(i);
					i++;
				}

				boolean found = false;
				int first = 0;
				while (!queue.isEmpty() && !found) {
					first = queue.dequeue();
					found = execute(first, false);
				}

				String str = Integer.toString(first);
				System.out.println();
				System.out.println("The first palindromic date in the 21st"
						+ " century is " + str.charAt(3) + str.charAt(2) +
						" " + str.charAt(1) + str.charAt(0) + ", " + str);
			}
		}
	}

	public static int getNumber() {
		int num = 0;
		boolean again = true;

		while (again) {
			System.out.print("Please enter a year:");
			try {
				num = scan.nextInt();
				System.out.println();
				if (num >= 1000 && num <= 9999) {
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

	public static boolean runAgain() {
		String response;
		boolean again = true;

		while (again) {
			System.out.println();
			System.out.print("Would you like to run again? (Y or N):");
			response = scan.nextLine();
			response = response.toUpperCase();
			if (response.charAt(0) == 'Y') {
				return true;
			} else if (response.charAt(0) == 'N') {
				return false;
			}
			System.out.println("I'm sorry, that was not a valid input. "
					+ "Please answer Y or N.");
		}
		return false;
	}

	public static boolean checkLeapYear(int year) {

		if(year % 400 == 0) {
			return true;
		} else if (year % 100 == 0) {
			return false;
		} else if (year % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void print(int day, int month, int year, boolean print) {
		if (!print) {
			return;
		}
		System.out.println("The palindromic date in the year " + year +
				" is " + String.format("%02d", month) + " " +
				String.format("%02d", day) + ", " + year + ".");
	}

	public static void noPal(int year, boolean print) {
		if (!print) {
			return;
		}
		System.out.println("There are no palindromic dates in the year "
				+ year + ".");
	}

	public static boolean execute(int year, boolean print) {
		int i;
		int month;
		int day;
		String yearString;
		String temp;
		LQueue<String> queue = new LQueue<>();

		yearString = Integer.toString(year);
		i = yearString.length() - 1;
		while (i >= 0) {
			queue.enqueue(yearString.charAt(i) + "");
			i--;
		}
		i = 0;

		while (i < yearString.length()) {
			queue.enqueue(yearString.charAt(i) + "");
			i++;
		}

		temp = queue.dequeue() + queue.dequeue();
		month = Integer.parseInt(temp);

		temp = queue.dequeue() + queue.dequeue();
		day = Integer.parseInt(temp);

		//Not a month
		if (month == 0 || month > 12) {
			noPal(year, print);
			return false;
		} else if (month == 2) {
			//February
			if(checkLeapYear(year)) {
				if (day <= 29 && day > 0) {
					print(day, month, year, print);
					return true;
				} else {
					noPal(year, print);
					return false;
				}
			} else {
				if (day <= 28 && day > 0) {
					print(day, month, year, print);
					return true;
				} else {
					noPal(year, print);
					return false;
				}
			}
		} else if (month % 2 == 0) {
			//Even month
			if (day <= 30 && day > 0) {
				print(day, month, year, print);
				return true;
			} else {
				noPal(year, print);
				return false;
			}
		} else {
			//Odd month
			if (day <= 31 && day > 0) {
				print(day, month, year, print);
				return true;
			} else {
				noPal(year, print);
				return false;
			}
		}
	}
}