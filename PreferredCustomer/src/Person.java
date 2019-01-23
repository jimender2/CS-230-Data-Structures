
public class Person {

	String name,
			streetAddress,
			city,
			state,
			zipCode,
			phoneNumber;

	public Person() {
		
	}

	public Person(String name, String streetAddress, String city,
					String state, String zipcode, String phoneNumber) {

		this.name = name;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipcode;
		this.phoneNumber = phoneNumber;

	}

	public Person(String name, String address, String phoneNumber) {

		this.name = name;
		this.phoneNumber = phoneNumber;

		String[] parse = new String[5];
		parse = address.split(",");

		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = "";

	}

}
