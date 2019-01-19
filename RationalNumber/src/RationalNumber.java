/**
 * 
 * @author Jonathan Meredith
 * 
 * This is a class that creates, stores, and does operations on rational
 * numbers.
 * Part 1 of 2 of assignment 1 for CS 230 Data Structures.
 *
 */


public class RationalNumber {

	//Declare variables
	int numerator,
		denominator;


	/**
	 * Default Constructor
	 */
	public RationalNumber() {
		numerator = 0;
		denominator = 1;
	}


	/**
	 * Constructor
	 * @param a Numerator
	 * @param b Denominator
	 */

	public RationalNumber(int a, int b) {
		numerator = a;
		denominator = b;
		simplify(a,b);
	}


	/**
	 * The add method allows us to add a rational number by another
	 * 		rational number
	 * @param other The other rational number you want to add
	 * @return The new rational number
	 */

	public RationalNumber add(RationalNumber other) {

		int num = (this.numerator * other.denominator) + 
					(other.numerator * this.denominator);

		int den = this.denominator * other.denominator;

		RationalNumber newFraction = new RationalNumber(num, den);

		return newFraction;

	}


	/**
	 * The subtract method allows us to subtract a rational number by 
	 * 		another rational number
	 * @param other The other rational number you want to subtract
	 * @return The new rational number
	 */

	public RationalNumber subtract(RationalNumber other) {

		int num = (this.numerator * other.denominator) - 
					(other.numerator * this.denominator);

		int den = this.denominator * other.denominator;

		RationalNumber newFraction = new RationalNumber(num, den);

		return newFraction;

	}


	/**
	 * The multiply method allows us to multiply a rational number by 
	 * 		another rational number
	 * @param other The other rational number you want to multiply by
	 * @return The new rational number
	 */

	public RationalNumber multiply(RationalNumber other) {

		int num = this.numerator*other.numerator; 

		int den = this.denominator*other.denominator; 
		
		RationalNumber newFraction = new RationalNumber(num, den);

		return newFraction;
	}


	/**
	 * The divide method allows us to divide a rational number by another
	 * 		rational number
	 * @param other The other rational number you want to divide by
	 * @return The new rational number
	 */

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
	

	/**
	 * The toDecimal method gets the decimal value of the rational number
	 * @return the decimal of the rational number
	 */

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


	/**
	 * The gcd method calculates the greatest common divisor of the two
	 * numbers input
	 * @param a The first of the two numbers you want the gcd of 
	 * 			(numerator)
	 * @param b The second of the two numbers you want the gcd of
	 * 			(denominator)
	 * @return The GCD of the two numbers
	 */

	public int gcd(int a, int b) {

		// Euclidean Algorithm
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a%b);
		}

	}


	/**
	 * The simplify method reduces the fraction to the smallest number
	 * @param a The numerator of the rational number
	 * @param b The denominator of the rational number
	 */

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
