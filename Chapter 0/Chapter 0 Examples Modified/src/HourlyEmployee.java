public class HourlyEmployee extends Employee {

	private int hours;
	private double rate;

	public HourlyEmployee() {
	
		this.hours = 0;
		this.rate = 0.0;
	}

	public HourlyEmployee( String fname, String lname, String ssn, int hours, double rate) {

		super( fname, lname, ssn);
		this.hours = hours;
		this.rate = rate;
	}

	public HourlyEmployee( HourlyEmployee other) {

		this.firstName = other.firstName;
		this.lastName = other.lastName;
		this.ssn = other.ssn;
		this.hours = other.hours;
		this.rate = other.rate;
	}

	public void setHours( int hours) {

		this.hours = hours;
	}

	public void setRate( double rate) {

		this.rate = rate;
	}

	public int getHours() {

		return this.hours;
	}

	public double getRate() {

		return this.rate;
	}

	public String getName() {

		String str = lastName.toUpperCase() + ", " + firstName;

		return str;
	}

	public double computeSalary() {

		double salary;

		if( this.hours > 40)
			salary = 40 * this.rate + (1.5 * this.rate * (this.hours - 40));
		else
			salary = this.hours * this.rate;

		return salary;
	}

	public HourlyEmployee copy() {

		HourlyEmployee e = new HourlyEmployee();

		e.hours = this.hours;
		e.rate = this.rate;
		e.firstName = this.firstName;
		e.lastName = this.lastName;
		e.ssn = this.ssn;

		return e;
	}

	public String toString() {

		String str = super.toString();
		
	}
}
