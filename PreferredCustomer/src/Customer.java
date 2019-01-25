
public class Customer extends Person {

	int customerNumber;

	Boolean mailingList;

	Customer(String name, String streetAddress, String city,
			String state, String zipcode, String phoneNumber,
			int customerNumber, Boolean mailingList) {
		
		super(name, streetAddress, city, state, zipcode, phoneNumber);

		this.customerNumber = customerNumber;
		this.mailingList = mailingList;

	}

	Customer(String name, String address, String phoneNumber,
			int customerNumber, Boolean mailingList) {
		
		super(name, address, phoneNumber);

		this.customerNumber = customerNumber;
		this.mailingList = mailingList;

	}
}
