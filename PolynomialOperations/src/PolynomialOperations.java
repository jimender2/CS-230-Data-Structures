import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PolynomialOperations {

	// Java program to add two polynomials

	// A utility function to return maximum of two integers
	static int max(int m, int n) {
		if (m < n)
			return n;
		else
			return m;
	}

	static ABList addPoly(ABList poly1, ABList poly2) {

		int size = max(poly1.size(), poly2.size());
		ABList<Integer> sum = new ABList<>(size);

		// Take every term of first polynomial
		for (int i = 0; i < poly1.size() && i < poly2.size(); i++) {
			sum.insert((Integer)poly1.get(i)+(Integer)poly2.get(i),i);
		}

		int temp = sum.size();

		while( temp < poly1.size()) {
			sum.insert((Integer)poly1.get(temp));
			temp++;
		}

		while( temp < poly2.size()) {
			sum.insert((Integer)poly2.get(temp));
			temp++;
		}

		return sum;
	}

	static ABList subtractPoly(ABList poly1, ABList poly2) {

		int size = max(poly1.size(), poly2.size());
		ABList<Integer> sum = new ABList<>(size);

		// Take every term of first polynomial
		for (int i = 0; i < poly1.size() && i < poly2.size(); i++) {
			sum.insert((Integer)poly1.get(i) - (Integer)poly2.get(i),i);
		}

		int temp = sum.size();

		while( temp < poly1.size()) {
			sum.insert((Integer)poly1.get(temp));
			temp++;
		}

		while( temp < poly2.size()) {
			sum.insert(((Integer)poly2.get(temp) * -1));
			temp++;
		}

		return sum;
	}

	static int evaluate(ABList poly, int x) {

		int sum = 0;

		for (int i = 0; i < poly.size(); i++) {
			sum = sum + (((int) Math.pow(x, i)) * (int) poly.get(i));
		}

		return sum;

	}

	static void printPolyABList(ABList poly) {

		int n = poly.size();
		for (int i = 0; i < n; i++) {
			System.out.print(poly.get(i));
			if (i != 0) {
				System.out.print("x^" + i);
			}
			if (i != n - 1) {
				System.out.print(" + ");
			}
		}
	}






	// Driver program to test above functions
	public static void main(String[] args) throws FileNotFoundException {
		//
		File fileIn = new File("polynomials.txt");
		Scanner file = new Scanner(fileIn);
		//
		int x;
		String read;
		String[] numberStrs;

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
		ABList<Integer> poly2 = new ABList<Integer>();
		exponent = 0;
		coefficient = 0;
		while (exponent < read.length() - 1) {
			exponent = coefficient + 2;
			poly2.insert(read.charAt(coefficient) - 48,
					read.charAt(exponent) - 48);
			coefficient = exponent + 2;
		}

		System.out.println("Test");
		printPolyABList(poly1);
		System.out.println();
		System.out.println("Test2");
		printPolyABList(poly2);

		System.out.println();
		System.out.println();

		System.out.println("poly1: " + poly1);
		System.out.println("poly2 : " + poly2);


		//		ABList<Integer> poly1 = new ABList<Integer>();
		//		ABList<Integer> poly2 = new ABList<Integer>();
		//
		//		poly1.insert(Integer.parseInt("5"));
		//		poly1.insert(Integer.parseInt("0"));
		//		poly1.insert(Integer.parseInt("10"));
		//		poly1.insert(Integer.parseInt("-6"));
		//
		//		poly2.insert(Integer.parseInt("1"));
		//		poly2.insert(Integer.parseInt("2"));
		//		poly2.insert(Integer.parseInt("4"));
		//
		//		// The following array represents polynomial 5 + 10x^2 + 6x^3
		//		int A[] = {5, 0, 10, 6};
		//
		//		// The following array represents polynomial 1 + 2x + 4x^2
		//		int B[] = {1, 2, 4};
		//
		System.out.println("First polynomial is");
		printPolyABList(poly1);
		System.out.println("\nSecond polynomial is");
		printPolyABList(poly2);
		//
		System.out.println();
		System.out.println();
		//
		System.out.println("Subtract");
		ABList<Integer> polySub = subtractPoly(poly1, poly2);
		printPolyABList(polySub);

		ABList<Integer> polySum = addPoly(poly1, poly2);

		System.out.println("\nsum polynomial is");
		printPolyABList(polySum);
		System.out.println();
		System.out.println();

		int xEvaluatedTo = evaluate( polySum, x);
		System.out.println(xEvaluatedTo);
	}

}
