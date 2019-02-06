import java.util.Scanner;
public class DecimalToBinary {

	public static void main(String[] args) {

		int x;
		Scanner keyboard = new Scanner( System.in);

		for( int count = 1 ; count <= 5 ; count++) {
			System.out.println( "Enter a postitive integer: ");
			x = keyboard.nextInt();
			if( x >= 0)
				convert( x);
			else
				System.out.println( x + " is negative.");
		}

		keyboard.close();
		return;
	}

	public static void convert( int num) {

		int rem;
		ABStack<Integer> stack = new ABStack<Integer>();

		while( num > 0) {
			rem = num % 2;
			stack.push( rem);
			num = num / 2;
		}
		
		while( !stack.isEmpty())
			System.out.print( stack.pop());

		System.out.println();
		return;
	}

}
