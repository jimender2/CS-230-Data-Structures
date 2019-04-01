import java.util.Random;

public class MergingLists {

	public static void main(String args[]) {
		int [] A = new int[25];
		int [] B = new int[40];
		ABList<Integer> C = new ABList<Integer>();
		Random random = new Random();
		int i, j;

		for( i = 0 ; i < A.length ; i++)
			A[i] = random.nextInt(100);
		for( j = 0 ; j < B.length ; j++)
			B[j] = random.nextInt(100);

		A = bubbleSort( A);
		B = bubbleSort( B);

		i = j = 0;
		while( i < A.length && j < B.length) {
			while( A[i] <= B[j]) {
				C.insert( A[i]);
				i++;
			}
			while( B[j] <= A[i]) {
				C.insert( B[j]);
				j++;
			}
		}
	}

	public static int[] bubbleSort( int[] X) {

		int pass, i, temp;

		for( pass = 1 ; pass <= X.length ; pass++) {
			for( i = 0 ; i < X.length-1 ; i++)
				if( X[i] > X[i+1]) {
					temp = X[i];
					X[i] = X[i+1];
					X[i+1] = temp;
				}
		}
//		for( i = 0 ; i < X.length ; i++)
//			System.out.print( X[i] + " ");
//		System.out.println();
		return X;
	}
}
