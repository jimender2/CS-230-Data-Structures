
public class Address implements Comparable<Address> {

	private String fName;
	private String lName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String phoneNumber;

	public Address() {
		fName = "";
		lName = ""
				streetAddress = "";
		city = "";
		state = "";
		zip = "";
		country = "";
		phoneNumber = "";
	}

	public Address(String fName, String lName, String streetAddress,
			String city, String state, String zip, String country,
			String phoneNumber) {

		this.fName = fName;
		this.lName = lName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int compareTo(Address o) {
		int comp = this.lastName.compareTo(o.lastName);
		if(comp == 0) {
			comp = this.firstName.compareTo(o.firstName);
		}
		return 0;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		String str = "";

		str = name + " " + streetAddress + " " + city + " " + zip + " "
				+ country + " " + phoneNumber;

		return str;
	}

}
