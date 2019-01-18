import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RationalNumberDriver {

	public static void main(String[] args) {

		File inFile = new File("10_Random");
		try {
			Scanner file = new Scanner(inFile);
			
		} catch (FileNotFoundException e1) {
			System.out.println("Error Reading File.");
		}

		Boolean test;
		
		RationalNumber rat = new RationalNumber(3,2);
		
		RationalNumber r = new RationalNumber(2,3);
		
		RationalNumber e = rat.multiply(r);
		System.out.println(e.toString());
	}

}
