public class ComplexNumber {

	private int realPart;
	private int imaginaryPart;
	
	public ComplexNumber() {
		
		this.realPart = 0;
		this.imaginaryPart = 0;
	}
	
	public ComplexNumber( int realPart, int imaginaryPart) {
		//this is an interesting thing, use this.realpart  helps clean up 
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	public ComplexNumber( ComplexNumber other) {
		
		this.realPart = other.realPart;
		this.imaginaryPart = other.imaginaryPart;
	}
	
	public void SetComplexNumber( int realPart, int imaginaryPart) {

		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
		
		return;
	}
	
	public void setRealPart( int realPart) {

		this.realPart = realPart;
		
		return;
	}
	
	public void setImaginaryPart( int imaginaryPart) {

		this.imaginaryPart = imaginaryPart;
		
		return;
	}
	
	public ComplexNumber getComplexNumber() {

		int newReal = this.realPart;
		int newImag = this.imaginaryPart;	
		
		return new ComplexNumber( newReal, newImag);
	}
	
	public int getRealPart() {

		return realPart;
	}
	
	public int getImaginaryPart() {

		return imaginaryPart;
	}
	
	public ComplexNumber add( ComplexNumber other) {

		int newReal = this.realPart;
		int newImaginary = this.imaginaryPart;
		
		newReal += other.realPart;
		newImaginary += other.imaginaryPart;
		
		return new ComplexNumber( newReal, newImaginary);
	}
	
	public ComplexNumber subtract( ComplexNumber other) {

		int newReal = this.realPart;
		int newImaginary = this.imaginaryPart;
		
		newReal -= other.realPart;
		newImaginary -= other.imaginaryPart;
		
		return new ComplexNumber( newReal, newImaginary);
	}
	
	public ComplexNumber multiply( ComplexNumber other) {

		int newReal = this.realPart * other.realPart - this.imaginaryPart * other.imaginaryPart;
		int newImag = this.imaginaryPart * other.realPart + this.realPart * other.imaginaryPart;
		
		return new ComplexNumber( newReal, newImag);
	}
	
	public ComplexNumber dividedBy( ComplexNumber other) {

		ComplexNumber temp1 = other.conjugate();
		ComplexNumber temp2 = this.multiply( temp1);
		ComplexNumber temp3 = other.multiply( temp1);
		int newReal = temp2.realPart / temp3.realPart;
		int newImag = temp2.imaginaryPart / temp3.realPart;
		
		return new ComplexNumber( newReal, newImag);
	}
	
	public ComplexNumber conjugate() {

		int newReal = this.realPart;
		int newImag = -this.imaginaryPart;
		
		return new ComplexNumber( newReal, newImag);
	}
	
	public String toString() {

		String str = "";
		int r = this.realPart;
		int m = this.imaginaryPart;
		
		if( r == 0 && m == 0) {
			str += "0";
			return str;
		}
		
		if( r == 0) {
			str += m + "i";
			return str;
		}
		
		if( m == 0) {
			str += r;
			return str;
		}
		
		if( m < 0) {
			m = -m;
			str += r + " - " + m + "i";
			return str;
		}
		
		str += r + " + " + m + "i";
		return str;
	}
}
