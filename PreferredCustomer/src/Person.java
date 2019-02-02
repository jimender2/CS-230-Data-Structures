/**
 * This class is the person class for assignment 2 of CS 230 Data
 * Structures
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


	Person(Person other) {

		name = other.getName();
		phoneNumber = other.getPhoneNumber();

		streetAddress = other.getAddress();
		city = other.getCity();
		state = other.getState();
		zipCode = other.getZipCode();
	}


	/**
	 * Blank Constructor
	 */
	public Person() {

		name = "";
		phoneNumber = "";
		streetAddress = "";
		city = "";
		state = "";
		zipCode = "";
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


	public String getFullAddress() {

		return streetAddress + ", " + city + ", " + state + " " + zipCode;
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
	 * getStreetAddress
	 * @return Gets the house number and the street of the person
	 */
	public String getStreetAddress() {

		return streetAddress;
	}


	/**
	 * setStreetAddress
	 * @return Sets the house number and the street of the person
	 */
	public void setStreetAddress(String streetAddress) {

		this.streetAddress = streetAddress;
	}


	/**
	 * getCity
	 * @return Gets the city of the person
	 */
	public String getCity() {

		return city;
	}


	/**
	 * setCity
	 * @param city Sets the city of the person
	 */
	public void setCity(String city) {

		this.city = city;
	}


	/**
	 * getState
	 * @return gets the state of the person
	 */
	public String getState() {

		return state;
	}


	/**
	 * setState
	 * @param state sets the city of the person
	 */
	public void setState(String state) {

		this.state = state;
	}


	/**
	 * getZipCode
	 * @return gets the zipcode of the person
	 */
	public String getZipCode() {

		return zipCode;
	}


	/**
	 * setZipCode
	 * @param zipCode sets the zipcode of the person
	 */
	public void setZipCode(String zipCode) {

		this.zipCode = zipCode;
	}


	/**
	 * getPhoneNumber
	 * @return the phonenumber of the person
	 */
	public String getPhoneNumber() {

		return phoneNumber;
	}


	/**
	 * setPhoneNumber
	 * @param phoneNumber Sets the phoneNumber of the person
	 */
	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;
	}


	/**
	 * Copy Method
	 * @return the address to the copied object
	 */
	public Person copy() {

		return new Person(getName(), getFullAddress(), getPhoneNumber());

	}


	/**
	 * Sees if this instance is equal to another instance of this class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Person other = (Person) obj;
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (phoneNumber == null) {
			if (other.phoneNumber != null) {
				return false;
			}
		} else if (!phoneNumber.equals(other.phoneNumber)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (streetAddress == null) {
			if (other.streetAddress != null) {
				return false;
			}
		} else if (!streetAddress.equals(other.streetAddress)) {
			return false;
		}
		if (zipCode == null) {
			if (other.zipCode != null) {
				return false;
			}
		} else if (!zipCode.equals(other.zipCode)) {
			return false;
		}
		return true;
	}
}
