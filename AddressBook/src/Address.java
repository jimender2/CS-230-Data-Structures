
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
		lName = "";
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
		if( this.lName.compareTo(o.lName) < 0) {
			return -1;
		} else if( this.lName.compareTo( o.lName) == 0) {
			if( this.fName.compareTo( o.fName) < 0) {
				return -1;
			}
			if( this.fName.compareTo( o.fName) == 0) {
				return 0;
			} else {
				return 1;
			}

		} else {
			return 1;
		}
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
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
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
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

		str = fName + " " + lName + " " + streetAddress + " " + city + " "
				+ zip + " "	+ country + " " + phoneNumber;

		return str;
	}

}
