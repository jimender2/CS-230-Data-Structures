import java.io.*;
import java.util.Scanner;

public class RationalNumberDriver {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		int num = 0,
			den = 1;
		
		boolean notFound = true;
		
		File list = new File("fractions.txt");
		Scanner file = new Scanner(list);
		
		System.out.println("Program is reading input file to validate two"
				+ "rational numbers...");
		
		while (file.hasNext() && notFound) {
			
			num = file.nextInt();
			den = file.nextInt();
			
			if (den == 0) {

				System.out.println("Invalid Fraction: denominator " +
						"cannot be zero.");
				
			} else {
				notFound = false;

			}
		}

		RationalNumber rat1 = new RationalNumber(num, den);
		System.out.println("The first valid fraction obtained is:\t\t" +
				rat1.toString() + "\t" + rat1.toDecimal());
		
		notFound = true;
		while (file.hasNext() && notFound) {
			
			num = file.nextInt();
			den = file.nextInt();
			
			if (den == 0) {

				System.out.println("Invalid Fraction: denominator " +
						"cannot be zero.");
				
			} else {
				notFound = false;
			}
		}

		file.close();
		
		RationalNumber rat2 = new RationalNumber(num, den);
		System.out.println("The second valid fraction obtained is:\t\t" +
				rat2.toString() + "\t" + rat2.toDecimal());			

		System.out.println("");
		System.out.println("Program is now performing arithmetic " +
				"operations on the two fractions...");
		
		
		RationalNumber ans = null;
		
		ans = rat1.add(rat2);
		System.out.println(rat1.toString() + " + " + rat2.toString() +
				" = " +	ans.toString() + " = " + ans.toDecimal());
		
		ans = rat1.subtract(rat2);
		System.out.println(rat1.toString() + " - " + rat2.toString() +
				" = " +	ans.toString() + " = " + ans.toDecimal());
		
		ans = rat1.multiply(rat2);
		System.out.println(rat1.toString() + " * " + rat2.toString() +
				" = " +	ans.toString() + " = " + ans.toDecimal());
		
		if(rat2.numerator == 0) {
			System.out.println("Not allowed to divide these two fractions"
					+ " due to a zero being in the numerator of the second"
					+ " fraction being zero.");
		} else {
			ans = rat1.divide(rat2);
			System.out.println(rat1.toString() + " / " + rat2.toString() +
					" = " +	ans.toString() + " = " + ans.toDecimal());
		}
			
		System.out.println("Program is done.");
		System.out.println("Bye!");

	}

}
