import java.util.Scanner;

public class Sieve {

	static Scanner scan = new Scanner (System.in);
	public static void main(String[] args) {

		int num;
		boolean again = true;
		int number;

		do {
			num = getNumber();

			CQueue<Integer> queue = new CQueue<Integer>();
			ABQueue<Integer> prime = new ABQueue<Integer>();

			int i = 2;

			while (i <= num) {
				queue.enqueue(i);
				i++;
			}

			do {
				prime.enqueue(queue.dequeue());

				int size = queue.size();

				for (int d = 0; d < size; d++){
					number = queue.dequeue();

					if ((number % prime.peekAtBack()) != 0)
						queue.enqueue(number);
				}

			} while(prime.peekAtBack() < Math.sqrt(num));

			while(!queue.isEmpty()) {
				prime.enqueue(queue.dequeue());
			}
			
			display(prime);

			again = runAgain();
		} while(again);
		scan.close();
	}

	public static int getNumber() {
		int num = 0;
		boolean again = true;

		while (again) {
			System.out.print("Please enter a number between 2 and infinitity:");
			try {
				num = scan.nextInt();
				System.out.println();
				if (num >= 2) {
					scan.nextLine();
					return num;
				} else {
					System.out.println("I'm sorry, the number you entered was invalid. Please try again.");
				}
			} catch (Exception InputMismatchException) {
				System.out.println();
				System.out.println("I'm sorry, what you entered was not a valid number. Please try again.");
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
			System.out.println("I'm sorry, that was not a valid input. Please answer Y or N.");
		}
		return false;
	}

	public static void display(ABQueue queue) {
		int num = queue.size() / 10;
		int i = 0;

		while (i < num) {
			for (int f = 1; f <= 10; f++)
				System.out.print(queue.dequeue() + " ");
			System.out.println("");
			i++;
		}

		while (!queue.isEmpty())
			System.out.print(queue.dequeue() + " ");

		System.out.println("");

	}
}
