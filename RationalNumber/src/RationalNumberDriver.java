import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RationalNumberDriver {

	public static void main(String[] args) {

		int numerator;
		int denominator;
		
		RationalNumber num1;
		RationalNumber num2;
		
		File inFile = new File("10_Random");
		try {
			Scanner file = new Scanner(inFile);
			
		} catch (FileNotFoundException e1) {
			System.out.println("Error Reading File.");
		}

		Boolean test;
		
		RationalNumber rat = new RationalNumber(-4,-16);
		RationalNumber r = new RationalNumber(1,-8);
		
		RationalNumber e = rat.add(r);
		System.out.println(e.toString());
	}

}
