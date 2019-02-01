/**
 * 
 * @author Jonathan Meredith
 *
 */

public class Person {

	//Declare Variables
	private String name,
			streetAddress,
			city,
			state,
			zipCode,
			phoneNumber;


	/**
	 * Constructor for the person class
	 * @param name First and Last Name of the person
	 * @param address Address of the person in the format
	 * 			860 Stone Creek Blvd, Ashland, OH 44805
	 * @param phoneNumber Phone number of the person in the format
	 * 			419-555-1111
	 */
	public Person(String name, String address, String phoneNumber) {

		this.name = name;
		this.phoneNumber = phoneNumber;

		String[] parse = new String[3];
		parse = address.split(", ");

		String[] par = new String[2];
		par = parse[2].split(" ");

		this.streetAddress = parse[0];
		this.city = parse[1];
		this.state = par[0];
		this.zipCode = par[1];

	}


	/**
	 * getAddress
	 * @return The full address of the person in the format 
	 * 			860 Stone Creek Blvd, Ashland, OH 44805
	 */
	public String getAddress() {

		return streetAddress + "\n" + city + ", " + state + " "
				+ zipCode;
	}


	/**
	 * toString
	 * @return a generic response
	 */
	@Override
	public String toString() {

		String str = super.toString();
		str = str + "\n" + streetAddress + "\n" + city + ", " + state + " "
				+ zipCode;
		return str;
	}


	/**
	 * getName
	 * @return the name of the person
	 */
	public String getName() {

		return name;
	}


	/**
	 * setName
	 * @param name the name of the person
	 */
	public void setName(String name) {

		this.name = name;
	}


	/**
	 * 
	 * @return
	 */
	public String getStreetAddress() {

		return streetAddress;
	}


	/**
	 * 
	 * @param streetAddress
	 */
	public void setStreetAddress(String streetAddress) {

		this.streetAddress = streetAddress;
	}


	/**
	 * 
	 * @return
	 */
	public String getCity() {

		return city;
	}


	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {

		this.city = city;
	}


	/**
	 * 
	 * @return
	 */
	public String getState() {

		return state;
	}


	/**
	 * 
	 * @param state
	 */
	public void setState(String state) {

		this.state = state;
	}


	/**
	 * 
	 * @return
	 */
	public String getZipCode() {

		return zipCode;
	}


	/**
	 * 
	 * @param zipCode
	 */
	public void setZipCode(String zipCode) {

		this.zipCode = zipCode;
	}


	/**
	 * 
	 * @return
	 */
	public String getPhoneNumber() {

		return phoneNumber;
	}


	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;
	}







	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result
				+ ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}


	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
}
