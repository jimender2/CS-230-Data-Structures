
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

		String[] parse = new String[3];
		parse = address.split(",");

		String[] par = new String[2];
		par = parse[2].split(" ");

		this.streetAddress = parse[0];
		this.city = parse[1];
		this.state = par[0];
		this.zipCode = par[1];

	}

	public String name() {

		return name;
	}

	public String address() {

		String str = streetAddress + "\n" + city + ", " + state + " "
				+ zipCode;
		return str;
	}

	public String toString() {

		String str = super.toString();
		str = str + "\n" + streetAddress + "\n" + city + ", " + state + " "
				+ zipCode;
		return str;
	}
}
