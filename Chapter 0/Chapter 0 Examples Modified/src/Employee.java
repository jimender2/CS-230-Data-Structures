public class Employee {

	protected String firstName;
	protected String lastName;
	protected String ssn;
	
	public Employee() {
	
		firstName = "";
		lastName = "";
		ssn = "";
	}
	
	public Employee(String fName, String lName, String sssn) {
		
		firstName = fName;
		lastName = lName;
		ssn = sssn;
	}
	
	public Employee(Employee other) {
		this.firstName = other.firstName;
		this.lastName = other.lastName;
		this.ssn = other.ssn;
		
	}
	
	public void setFirstName( String name) {
	
		this.firstName = name;
		
		return;
	}
	
	public void setLastName( String name) {

		this.lastName = name;
		
		return;
	}

	public void setName( String fname, String lname) {

		this.firstName = fname;
		this.lastName = lname;
	
		return;
	}
	
	public void setSSN( String ssn) {
	
		this.ssn = ssn;
		
		return;
	}
	
	public String getName() {
	
		return( this.firstName + " " + this.lastName);
	}
	
	public String getFirstName() {
	
		return( this.firstName);
	}
	
	public String getLastName() {
	
		return( this.lastName);
	}
	
	public String getSSN() {
	
		return this.ssn;
	}
	
	public String toString() {

		String str = "[";
		str = str + this.firstName + " ";
		str = str + this.lastName + ", " + this.ssn + "]";															 	// <<<<<<<<<<<<
		
		return( str);
	}
	
	public boolean equals( Employee e) {

		return( this.ssn.equals( e.ssn));	
	}

	public void copy( Employee e) {
	
		this.firstName = e.firstName;
		this.lastName = e.lastName;
		this.ssn = e.ssn;
		
		return;
	}
	
	public Employee copy() {
	
		Employee e = new Employee( this.firstName, this.lastName, this.ssn);
		
		return e;
	}
	
	public int compareTo( Employee e) {
	
		if( this.lastName.compareTo(e.lastName) < 0) {
			return -1;
		} else if( this.lastName.compareTo( e.lastName) == 0) {
			if( this.firstName.compareTo( e.firstName) < 0) {
				return -1;
			}
			if( this.firstName.compareTo( e.firstName) == 0) {
				return 0;
			} else {
				return 1;
			}
			
		} else {
			return 1;
		}
		
		
	}
}
