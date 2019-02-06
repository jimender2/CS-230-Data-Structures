/**
 * 
 * @author Jonathan Meredith
 *
 */

public class PreferredCustomer extends Customer {

	//Declare Variables
	private double purchaseAmount;
	private int discount;


	/**
	 * 
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param customerNumber
	 * @param mailingList
	 * @param purchaseAmount
	 */
	PreferredCustomer(String name, String address, String phoneNumber,
			String customerNumber, Boolean mailingList,
			double purchaseAmount) {

		super(name, address, phoneNumber, customerNumber, mailingList);

		this.purchaseAmount = purchaseAmount;

		discount();

	}


	/**
	 * Blank Constructor
	 */
	PreferredCustomer() {
		super();

		purchaseAmount = 0;
		discount();
	}


	/**
	 * Copy Constructor
	 */
	PreferredCustomer(PreferredCustomer other) {
		super(other.getName(), other.getFullAddress(),
				other.getPhoneNumber(),	other.getCustomerNumber(),
				other.getMailingList());

		this.purchaseAmount = other.getPurchaseAmount();

		discount();
	}


	/**
	 * Calculates the discount amount from purchaseAmount
	 */
	public void discount() {

		if (purchaseAmount >= 2000) {
			discount = 10;

		} else if (purchaseAmount >= 1500) {
			discount = 7;

		} else if (purchaseAmount >= 1000) {
			discount = 6;

		} else if (purchaseAmount >= 500) {
			discount = 5;

		} else {
			discount = 0;

		}

	}


	/**
	 * getPurchaseAmount
	 * @return the amount the customer has purchased
	 */
	public double getPurchaseAmount() {

		return purchaseAmount;
	}


	/**
	 * setPurchaseAmount
	 * @param purchaseAmount Sets the amount the customer has purchased
	 */
	public void setPurchaseAmount(double purchaseAmount) {

		this.purchaseAmount = purchaseAmount;
		discount();
	}


	/**
	 * getDiscount
	 * @return the discount based on how much the user has purchased
	 */
	public int getDiscount() {

		return discount;
	}


	/**
	 * Copy method
	 * @return the address to the copied object
	 */
	public PreferredCustomer copy() {

		return new PreferredCustomer(getName(), getFullAddress(),
				getPhoneNumber(), getCustomerNumber(), getMailingList(),
				getPurchaseAmount());

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

		PreferredCustomer other = (PreferredCustomer) obj;

		if (discount != other.discount) {
			return false;
		}

		if (Double.doubleToLongBits(purchaseAmount) != Double
				.doubleToLongBits(other.purchaseAmount)) {
			return false;
		} else {
			return true;
		}
	}

}
