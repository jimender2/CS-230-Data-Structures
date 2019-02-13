import java.util.Scanner;

public class Palindromes {

	public static void main(String[] args) {

		String str;
		Scanner keyboard = new Scanner( System.in);

		for( int count = 1 ; count <= 5 ; count ++) {

			System.out.println( "Enter your string: ");
			str = keyboard.nextLine();
			isPalindrome( str);
		}
	}

	public static boolean isPalindrome( String str) {

		return true;
	}
}
