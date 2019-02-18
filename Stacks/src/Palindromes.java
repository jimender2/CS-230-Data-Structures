import java.util.Scanner;

public class Palindromes {

	public static void main(String[] args) {

		String str;
		Scanner keyboard = new Scanner( System.in);

		for( int count = 1 ; count <= 5 ; count ++) {

			System.out.println( "Enter your string: ");
			str = keyboard.nextLine();
			if( isPalindrome( str))
				System.out.println( str + " is a palindrome");
			else
				System.out.println( str + " is not a palindrome.");;
		}
		keyboard.close();
	}

	public static boolean isPalindrome( String str) {

		LinkedStack<Character> stack = new LinkedStack<Character>();

		str = removeBlanks( str);
		str = str.toUpperCase();

		for( int index = 0 ; index < str.length() ; index++)
			stack.push( str.charAt(index));

		for( int index = 0 ; index < str.length() ; index++)
			if( str.charAt( index) != stack.pop())
				return false;
		return true;
	}

	public static String removeBlanks( String str) {

		String noBlanks = "";
		for( int index = 0 ; index < str.length(); index ++)
			if( str.charAt(index) != ' ')
				noBlanks = noBlanks + str.charAt(index);
		return noBlanks;
	}
}
