
public class RationalNumber {

	int numerator,
		denominator;


	public RationalNumber() {

		numerator = 0;
		denominator = 1;

	}


	public RationalNumber(int a, int b) {

		numerator = a;
		denominator = b;
		simplify(a,b);
		
	}


	public RationalNumber add(RationalNumber other) {


		int num = (this.numerator * other.denominator) + 
					(other.numerator * this.denominator);
		
	    int den = this.denominator * other.denominator;

		RationalNumber newFraction = new RationalNumber(num, den);

		return newFraction;

	}


	public RationalNumber subtract(RationalNumber other) {

		int num = (this.numerator * other.denominator) - 
					(other.numerator * this.denominator);

		int den = this.denominator * other.denominator;

				
		RationalNumber newFraction = new RationalNumber(num, den);

		return newFraction;

	}


	public RationalNumber multiply(RationalNumber other) {

		int num = this.numerator*other.numerator; 

		int den = this.denominator*other.denominator; 
		
		RationalNumber newFraction = new RationalNumber(num, den);

		return newFraction;
	}

	
	public RationalNumber divide(RationalNumber other) {

		int num = this.numerator*other.denominator;
		int den = this.denominator*other.numerator;
		
		
		RationalNumber newFraction = new RationalNumber(num, den);

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
	

	public double toDecimal() {
		double dub = (numerator + 0.0) / (denominator);
		return dub;
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
	
	
	public void simplify(int a, int b) {
		
		int gcd = gcd(a, b);
	
		a = a / gcd;
		b = b / gcd;
		
		if (b < 0) {
			denominator = -b;
			if (a < 0) {
				numerator = a;
			} else {
				numerator = -a;
			}
		
		} else {
			denominator = b;
			numerator = a;
		}
		
	}
}
