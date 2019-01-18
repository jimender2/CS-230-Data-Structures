
public class RationalNumber {

	int numerator,
		denominator;


	public RationalNumber() {

		numerator = 0;
		denominator = 1;

	}


	public RationalNumber(int num, int den) {

		if (den < 0) {
			denominator = -den;

			if (num < 0) {
				numerator = num;
			} else {
				numerator = -num;
			}
		
		} else if (den > 0) {
			denominator = den;
			numerator = num;
		}

	}


	public RationalNumber add(RationalNumber rat) {

		int tempNum = 0;
		int tempDen = 0;
		
		if (denominator == rat.denominator) {

			tempNum = numerator + rat.numerator;
			tempDen = denominator;
			
		} else {

			tempNum = (numerator * rat.denominator) + 
					(rat.numerator * denominator);
			tempDen = denominator * rat.denominator;

		}

		int gcd = gcd(tempNum, tempDen);
		tempNum = tempNum / gcd;
		tempDen = tempDen / gcd;
		
		RationalNumber newFraction = new RationalNumber(tempNum, tempDen);

		return newFraction;

	}


	public RationalNumber subtract(RationalNumber rat) {

		int tempNum = 0;
		int tempDen = 0;
		
		if (denominator == rat.denominator) {

			tempNum = numerator - rat.numerator;
			tempDen = denominator;

		} else {

			tempNum = (numerator * rat.denominator) - 
					(rat.numerator * denominator);
			tempDen = denominator * rat.denominator;

		}
		
		int gcd = gcd(tempNum, tempDen);
		tempNum = tempNum / gcd;
		tempDen = tempDen / gcd;
		
		RationalNumber newFraction = new RationalNumber(tempNum, tempDen);

		return newFraction;

	}


	public RationalNumber multiply(RationalNumber rat) {

		int tempNum = 0;
		int tempDen = 0;
		
		if (denominator == rat.denominator) {

			tempNum = numerator * rat.numerator;
			tempDen = denominator;

		} else {

			tempNum = numerator * rat.numerator;
			tempDen = denominator * rat.denominator;

		}
		
		int gcd = gcd(tempNum, tempDen);
		tempNum = tempNum / gcd;
		tempDen = tempDen / gcd;
		
		RationalNumber newFraction = new RationalNumber(tempNum, tempDen);

		return newFraction;

	}


	/**
     * toString method
     * @return A string indicating the fraction in the form a/b.
	 */
 
	public String toString() {

		//Format the string
		String str = numerator + "/" + denominator;

		// Return the string.
		return str;
	}

	
	/**
     * The equals method compares two RationalNumber objects.
     * @param object2 A RationalNumber object to compare to the calling
     * RationalNumber object.
     * @return true if the argument object is equal to the calling object.
	 */

	public boolean equals(RationalNumber object2){
		boolean status;

		// Determine whether this object's radius is equal to object2's
		// radius.
		if (numerator == object2.numerator &&
				denominator == object2.denominator) {
			status = true;  // Yes, the objects are equal.
		} else { 
			status = false; // No, the objects are not equal.
		}
		
		// Return the value in status.
		return status;
	}


	// Euclidean Algorithm
	public int gcd(int a, int b) {
		
		if (b == 0) {	
			return a;
		} else {
			return gcd(b,a%b);
		}
		
	}
}
