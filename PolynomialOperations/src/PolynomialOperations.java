public class PolynomialOperations {

	//	public static void main(String[] args) throws FileNotFoundException {
	//
	//		File fileIn = new File("polynomials.txt");
	//		Scanner file = new Scanner(fileIn);
	//
	//		ABList poly1 = new ABList();
	//		ABList poly2 = new ABList();
	//		int x;
	//		String read;
	//		String[] numberStrs;
	//
	//		x = file.nextInt();
	//
	//		read = file.nextLine();
	//
	//		numberStrs = read.split(" ");
	//		int[] numbers = new int[numberStrs.length];
	//		for(int i = 0; i < numberStrs.length; i++)
	//		{
	//			numbers[i] = Integer.parseInt(numberStrs[i]);
	//		}


	// Java program to add two polynomials



	// A utility function to return maximum of two integers
	static int max(int m, int n) {
		if (m < n)
			return n;
		else
			return m;
	}

	// A[] represents coefficients of first polynomial
	// B[] represents coefficients of second polynomial
	// m and n are sizes of A[] and B[] respectively
	static int[] add(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int size = max(m, n);
		int sum[] = new int[size];

		// Initialize the product polynomial
		for (int i = 0; i < m; i++) {
			sum[i] = A[i];
		}

		// Take ever term of first polynomial
		for (int i = 0; i < n; i++) {
			sum[i] += B[i];
		}

		return sum;
	}

	static ABList addPoly(ABList poly1, ABList poly2) {

		int size = max(poly1.size(), poly2.size());
		ABList<Integer> sum = new ABList<Integer>(size);

		int sizeOfPoly1 = poly1.size();
		int sizeOfPoly2 = poly2.size();
		// Initialize the product polynomial
		for (int i = 0; i < sizeOfPoly2; i++) {
			//sum.insert((Integer) poly2.get(i));
		}

		// Take every term of first polynomial
		for (int i = 0; i < sizeOfPoly1 && i < sizeOfPoly2; i++) {
			sum.insert((Integer)poly2.get(i)+(Integer)poly1.get(i),i);
		}

		int temp = sum.size();

		while( temp < sizeOfPoly1) {
			sum.insert((Integer)poly1.get(temp));
			temp++;
		}

		while( temp < sizeOfPoly2) {
			sum.insert((Integer)poly2.get(temp));
			temp++;
		}

		return sum;
	}

	// A utility function to print a polynomial
	static void printPoly(int poly[]) {

		int n = poly.length;
		for (int i = 0; i < n; i++) {
			System.out.print(poly[i]);
			if (i != 0) {
				System.out.print("x^" + i);
			}
			if (i != n - 1) {
				System.out.print(" + ");
			}
		}
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
	public static void main(String[] args) {

		ABList<Integer> poly1 = new ABList<Integer>();
		ABList<Integer> poly2 = new ABList<Integer>();

		poly1.insert(Integer.parseInt("5"));
		poly1.insert(Integer.parseInt("0"));
		poly1.insert(Integer.parseInt("10"));
		poly1.insert(Integer.parseInt("6"));

		poly2.insert(Integer.parseInt("1"));
		poly2.insert(Integer.parseInt("2"));
		poly2.insert(Integer.parseInt("4"));


		// The following array represents polynomial 5 + 10x^2 + 6x^3
		int A[] = {5, 0, 10, 6};

		// The following array represents polynomial 1 + 2x + 4x^2
		int B[] = {1, 2, 4};

		System.out.println("First polynomial is");
		printPoly(A);
		System.out.println();
		printPolyABList(poly1);
		System.out.println("\nSecond polynomial is");
		printPoly(B);
		System.out.println();
		printPolyABList(poly2);
		int sum[] = add(A, B);
		ABList<Integer> polySum = addPoly(poly1, poly2);
		//		int size = max(m, n);
		System.out.println("\nsum polynomial is");
		printPoly(sum);
		System.out.println();
		printPolyABList(polySum);
		System.out.println();
		System.out.println();
		printPolyABList(poly1);
		System.out.println();
		printPolyABList(poly2);

	}

}
