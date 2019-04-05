import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LargeInteger {

	public static void main(String[] args) throws FileNotFoundException {
		
		String line;
		int size1, size2;
		LinkedList<Byte> sum = new LinkedList<Byte>();
		LinkedList<Byte> largeInt1 = new LinkedList<Byte>();
		LinkedList<Byte> largeInt2 = new LinkedList<Byte>();
		Scanner inFile = new Scanner( new File( "largeIntegers.txt"));
		
		line = inFile.nextLine();
		largeInt1 = buildLargeInteger( line);
		line = inFile.nextLine(); 	
		largeInt2 = buildLargeInteger( line);
		inFile.close();
		
		size1 = largeInt1.size();
		size2 = largeInt2.size();
		
		System.out.println( largeInt1);
		System.out.println( largeInt2);
		largeInt1.reverse();
		largeInt2.reverse();
		sum = add( largeInt1, largeInt2);
		System.out.println( sum);
		return;
	}
	
	public static LinkedList<Byte> buildLargeInteger( String line) {
		
		Byte x;
		String str;
		int length = line.length();
		LinkedList<Byte> largeInt = new LinkedList<Byte>();
		
		
		
		return largeInt;
	} 

	public static LinkedList<Byte> add( LinkedList<Byte> num1, LinkedList<Byte> num2) {
		
		int size = num1.size();
		Byte x, y, z, carry = 0;
		LinkedList<Byte> largeInt = new LinkedList<Byte>();
		
		
		return largeInt;
	}
		
}
