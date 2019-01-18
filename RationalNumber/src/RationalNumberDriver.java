
public class RationalNumberDriver {

	public static void main(String[] args) {

		Boolean test;
		
		RationalNumber rat = new RationalNumber(3,2);
		
		RationalNumber r = new RationalNumber(2,3);
		
		RationalNumber e = rat.add(r);
		System.out.println(e.toString());
	}

}
