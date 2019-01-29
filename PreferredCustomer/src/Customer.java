/**
 * 
 * @author Jonathan Meredith
 *
 */

public class Customer extends Person {

	//Declare Variables
	String customerNumber;

	Boolean mailingList;


	/**
	 * 
	 * @param name
	 * @param streetAddress
	 * @param city
	 * @param state
	 * @param zipcode
	 * @param phoneNumber
	 * @param customerNumber
	 * @param mailingList
	 */
	Customer(String name, String streetAddress, String city,
			String state, String zipcode, String phoneNumber,
			String customerNumber, Boolean mailingList) {

		super(name, streetAddress, city, state, zipcode, phoneNumber);

		this.customerNumber = customerNumber;
		this.mailingList = mailingList;

	}


	/**
	 * 
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param customerNumber
	 * @param mailingList
	 */
	Customer(String name, String address, String phoneNumber,
			String customerNumber, Boolean mailingList) {
		
		super(name, address, phoneNumber);

		this.customerNumber = customerNumber;
		this.mailingList = mailingList;

	}


	/**
	 * 
	 * @return
	 */
	public String customerNumber() {

		return customerNumber + "";
	}


	/**
	 * 
	 * @return
	 */
	public Boolean mailingList() {

		return mailingList;
	}


	/**
	 * 
	 */
	@Override
	public String toString() {

		String str = "";
		str = str + " " + customerNumber + " " + mailingList;
		return str;
	}


	/**
	 * 
	 * @return
	 */
	public String getCustomerNumber() {

		return customerNumber;
	}


	/**
	 * 
	 * @param customerNumber
	 */
	public void setCustomerNumber(String customerNumber) {

		this.customerNumber = customerNumber;
	}


	/**
	 * 
	 * @return
	 */
	public Boolean getMailingList() {

		return mailingList;
	}


	/**
	 * 
	 * @param mailingList
	 */
	public void setMailingList(Boolean mailingList) {

		this.mailingList = mailingList;
	}

	



	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((customerNumber == null) ? 0 : customerNumber.hashCode());
		result = prime * result
				+ ((mailingList == null) ? 0 : mailingList.hashCode());
		return result;
	}


	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!super.equals(obj)) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		Customer other = (Customer) obj;

		if (customerNumber == null) {
			if (other.customerNumber != null) {
				return false;
			}

		} else if (!customerNumber.equals(other.customerNumber)) {
			return false;
		}

		if (mailingList == null) {
			if (other.mailingList != null) {
				return false;
			}

		} else if (!mailingList.equals(other.mailingList)) {
			return false;
		}

		return true;

	}

}
