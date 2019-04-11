import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PolynomialOperations {

	// Java program to add two polynomials

	// Return maximum of two integers
	static int max(int m, int n) {
		if (m < n)
			return n;
		else
			return m;
	}

	// Add two Polynomials
	static ABList<Integer> addPoly(ABList<Integer> poly1, ABList<Integer> poly2) {

		int size = max(poly1.size(), poly2.size());
		ABList<Integer> sum = new ABList<>(size);

		// Take every term of first polynomial
		for (int i = 0; i < poly1.size() && i < poly2.size(); i++)
			sum.insert(poly1.get(i) + poly2.get(i), i);

		int temp = sum.size();

		while( temp < poly1.size()) {
			sum.insert(poly1.get(temp));
			temp++;
		}

		while( temp < poly2.size()) {
			sum.insert(poly2.get(temp));
			temp++;
		}

		return sum;
	}

	static ABList<Integer> subtractPoly(ABList<Integer> poly1, ABList<Integer> poly2) {

		int size = max(poly1.size(), poly2.size());
		ABList<Integer> sum = new ABList<>(size);

		for (int i = 0; i < poly1.size() && i < poly2.size(); i++)
			sum.insert(poly1.get(i) - poly2.get(i), i);

		int temp = sum.size();

		while( temp < poly1.size()) {
			sum.insert(poly1.get(temp));
			temp++;
		}

		while( temp < poly2.size()) {
			sum.insert((poly2.get(temp) * -1));
			temp++;
		}

		return sum;
	}

	static int evaluate(ABList<Integer> poly, int x) {

		int sum = 0;

		for (int i = 0; i < poly.size(); i++) {
			sum = sum + (((int) Math.pow(x, i)) * poly.get(i));
		}

		return sum;

	}

	static void printPolyABList(ABList<Integer> poly) {

		int n = poly.size();
		System.out.print("(");
		for (int i = 0; i < n; i++) {
			if(poly.get(i) == 0) {
				//do nothing
			} else {
				if(poly.get(i) != 1 || i == 0) {
					System.out.print(poly.get(i));
				}
				if (i != 0) {
					if (i != 1)
						System.out.print("x^" + i);
					else
						System.out.print("x");
				}
				if (i != n - 1) {
					System.out.print(" + ");
				}
			}
		}
		System.out.print(")");
	}

	// Main method
	public static void main(String[] args) throws FileNotFoundException {

		File fileIn = new File("polynomials.txt");
		Scanner file = new Scanner(fileIn);

		int x;
		String read;

		x = file.nextInt();

		file.nextLine();

		read = file.nextLine();
		ABList<Integer> poly1 = new ABList<>();

		int exponent = 0;
		int coefficient = 0;
		while (exponent < read.length() - 1) {
			exponent = coefficient + 2;
			poly1.insert(read.charAt(coefficient) - 48,
					read.charAt(exponent) - 48);
			coefficient = exponent + 2;
		}


		read = file.nextLine();
		ABList<Integer> poly2 = new ABList<>();
		exponent = 0;
		coefficient = 0;
		while (exponent < read.length() - 1) {
			exponent = coefficient + 2;
			poly2.insert(read.charAt(coefficient) - 48,
					read.charAt(exponent) - 48);
			coefficient = exponent + 2;
		}

		System.out.println("Program is reading input file to obtain the "
				+ "two polynomials. The two input polynomials are:");

		System.out.print("p(x) = ");
		printPolyABList(poly1);
		System.out.println();

		System.out.print("q(x) = ");
		printPolyABList(poly2);
		System.out.println();

		System.out.println();
		System.out.println("Program is now performing arithmetic "
				+ "operations on the two polynomials…");
		printPolyABList(poly1);
		System.out.print(" + ");
		printPolyABList(poly2);
		System.out.print(" = ");

		ABList<Integer> sum;
		sum = addPoly(poly1, poly2);
		printPolyABList(sum);
		System.out.println();


		printPolyABList(poly1);
		System.out.print(" - ");
		printPolyABList(poly2);
		System.out.print(" = ");

		ABList<Integer> sub;
		sub = subtractPoly(poly1, poly2);
		printPolyABList(sub);

		System.out.println();
		System.out.println();
		System.out.println("Program is now evaluating each polynomial "
				+ "using x = " + x);

		int poly1evaluation = evaluate(poly1, x);
		System.out.println("p(" + x + ") = " + poly1evaluation);

		int poly2evaluation = evaluate(poly2, x);
		System.out.println("q(" + x + ") = " + poly2evaluation);

		System.out.println();
		System.out.println("Program is done.");
		System.out.println("Bye!");

		file.close();
	}

}
