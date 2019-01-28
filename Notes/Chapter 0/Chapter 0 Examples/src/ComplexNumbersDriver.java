import java.util.Random;
import java.util.Scanner;

public class ComplexNumbersDriver {

	public static void main(String[] args) {

		int real, imaginary;
		ComplexNumber x, y, z;
		Random rand = new Random();
		Scanner keyboard = new Scanner( System.in);
				
		System.out.print( "Enter the real part and imaginary part for complex number x: ");
		real = keyboard.nextInt();
		imaginary = keyboard.nextInt();
		x = new ComplexNumber( real, imaginary);
		System.out.println( "Complex Number x is: " + x);
		
		System.out.println( "Generating a random complex number y: ");
		real = rand.nextInt( 10);
		imaginary = rand.nextInt( 10);
		y = new ComplexNumber( real, imaginary);
		System.out.println( "Complex Number y is: " + y);
		System.out.println( "Testing arithmetic operations on complex numbers x and y ...");	
		z = x.add( y);
		System.out.println( "x + y = " + z);
		z = x.subtract( y);
		System.out.println( "x - y = " + z);
		z = x.multiply( y);
		System.out.println( "x * y = " + z);
		z = x.dividedBy( y);
		System.out.println( "x / y = " + z);
		z = x.conjugate();
		System.out.println( "Conjugate of x is: " + z);
		
		System.out.println( "\nGenerating new complex numbers for testing ...");
		x = new ComplexNumber( rand.nextInt( 10), rand.nextInt( 10));
		System.out.println( "New Complex Number x is: " + x);
		y = new ComplexNumber( rand.nextInt( 10), rand.nextInt( 10));
		System.out.println( "New Complex Number y is: " + y);
		System.out.println( "Testing arithmetic operations on new complex numbers x and y ...");
		z = x.add( y);
		System.out.println( "x + y = " + z);
		z = x.subtract( y);
		System.out.println( "x - y = " + z);
		z = x.multiply( y);
		System.out.println( "x * y = " + z);
		z = x.dividedBy( y);
		System.out.println( "x / y = " + z);
		z = y.conjugate();
		System.out.println( "Conjugate of y is: " + z);
		
		System.out.println( "\nDone.");
		keyboard.close();
		return;
	}

}
