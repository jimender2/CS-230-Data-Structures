
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
	
	@Override
	public String toString() {

		String str = "";
		str = str + " " + customerNumber + " " + mailingList;
		return str;
	}

	public String getCustomerNumber() {

		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {

		this.customerNumber = customerNumber;
	}

	public Boolean getMailingList() {

		return mailingList;
	}

	public void setMailingList(Boolean mailingList) {

		this.mailingList = mailingList;
	}

	




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
		} else {
			return true;
		}
		return true;

	}

}
