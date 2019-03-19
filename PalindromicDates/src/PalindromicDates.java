import java.util.Scanner;

public class PalindromicDates {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int year;
		int i;
		int month;
		int day;
		boolean again = true;
		String yearString;
		String temp;
		LQueue<String> queue = new LQueue<String>();

		while(again) {
			year = getNumber();
			
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
			System.out.println(queue);
			temp = queue.dequeue() + queue.dequeue();
			month = Integer.parseInt(temp);

			temp = queue.dequeue() + queue.dequeue();
			day = Integer.parseInt(temp);

			if (month == 0) {
				System.out.println("There are no palindromic dates "
						+ "in " + year + ".");
			} else if (month == 2) {
				//February
				if (year % 4 != 0) {
					//Not a leap year
				} else if (year % 100 != 0) {
					//Leap year
				} else if (year % 400 != 0) {
					//Leap year
				} else {
					
				}
			} else if (month % 2 == 0) {
				//Even
				if (day <= 30 && day > 0) {
					System.out.println("The palindromic date in the year "
							+ year + " is " + month + " " + day + ", "
							+ year + ".");
				} else {
					System.out.println("There are no palindromic dates "
							+ "in " + year + ".");
				}
			} else {
				//Odd
				if (day <= 31 && day > 0) {
					System.out.println("The palindromic date in the year "
							+ year + " is " + month + " " + day + ", "
							+ year + ".");
				} else {
					System.out.println("There are no palindromic dates "
							+ "in " + year + ".");
				}
			}

			again = runAgain();
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

}
