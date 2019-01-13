
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

}
