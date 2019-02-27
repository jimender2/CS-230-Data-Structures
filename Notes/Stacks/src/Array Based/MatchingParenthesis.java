import java.util.Scanner;

public class MatchingParenthesis {

	public static void main(String[] args) {

		char ch;
		String expression;
		ABStack<Integer> stack = new ABStack<Integer>( 20);
		Scanner keyboard = new Scanner( System.in);

		for( int count = 1 ; count <=5 ; count ++)
		{
			System.out.println("Enter an expression: ");
			expression = keyboard.nextLine();
			for( int index = 0 ; index < expression.length() ; index++) {
				ch = expression.charAt(index);
				if(ch == '(')
					stack.push( index);
				else if( ch == ')') {
					if( stack.isEmpty())
						System.out.println(") at index " + index + " does not have a matching (");
					else
						System.out.println(") at index " + index + " matches the ( at index " + stack.pop());
				}
			}

			while( !stack.isEmpty())
				System.out.println("( at index " + stack.pop() + " does not have a matching ).");
		}

		keyboard.close();
	}

}
