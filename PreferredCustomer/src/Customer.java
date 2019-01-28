
public class Customer extends Person {

	String customerNumber;

	Boolean mailingList;

	Customer(String name, String streetAddress, String city,
			String state, String zipcode, String phoneNumber,
			String customerNumber, Boolean mailingList) {

		super(name, streetAddress, city, state, zipcode, phoneNumber);

		this.customerNumber = customerNumber;
		this.mailingList = mailingList;

	}

	Customer(String name, String address, String phoneNumber,
			String customerNumber, Boolean mailingList) {
		
		super(name, address, phoneNumber);

		this.customerNumber = customerNumber;
		this.mailingList = mailingList;

	}

	public String customerNumber() {

		return customerNumber + "";
	}
	
	public Boolean mailingList() {

		return mailingList;
	}
	
	public String toString() {

		String str = "";
		str = str + " " + customerNumber + " " + mailingList;
		return str;
	}

}
