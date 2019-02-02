/**
 * 
 * @author Jonathan Meredith
 *
 */

public class Customer extends Person {

	//Declare Variables
	private String customerNumber;

	private Boolean mailingList;


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
	 * Copy Constructor
	 */
	Customer(Customer other) {

		super(other.getName(), other.getFullAddress(),
				other.getPhoneNumber());

		customerNumber = other.getCustomerNumber();
		mailingList = other.getMailingList();

	}


	/**
	 * blank constructor
	 */
	Customer() {

		super();

		customerNumber = "";
		mailingList = false;

	}


	/**
	 * Generic toString method
	 */
	@Override
	public String toString() {

		String str = "";
		str = str + " " + customerNumber + " " + mailingList;
		return str;
	}


	/**
	 * getCustomerNumber
	 * @return the number assigned to the customer
	 */
	public String getCustomerNumber() {

		return customerNumber;
	}


	/**
	 * setCustomerNumber
	 * @param customerNumber sets the number assigned to the customer
	 */
	public void setCustomerNumber(String customerNumber) {

		this.customerNumber = customerNumber;
	}


	/**
	 * getMailingList
	 * @return if the customer is in the mailing list or not
	 */
	public Boolean getMailingList() {

		return mailingList;
	}


	/**
	 * setMailingList
	 * @param mailingList sets if the customer is in the mailing list or
	 * not
	 */
	public void setMailingList(Boolean mailingList) {

		this.mailingList = mailingList;
	}


	/**
	 * Copy Method
	 * @return the address to the copied object
	 */
	public Customer copy() {

		return new Customer(getName(), getFullAddress(), getPhoneNumber(),
				getCustomerNumber(), getMailingList());

	}


	/**
	 * Sees if this instance is equal to another instance of this class
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
