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
	 * 
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
	 * 
	 * @return
	 */
	public double getPurchaseAmount() {

		return purchaseAmount;
	}


	/**
	 * 
	 * @param purchaseAmount
	 */
	public void setPurchaseAmount(double purchaseAmount) {

		this.purchaseAmount = purchaseAmount;
	}


	/**
	 * 
	 * @return
	 */
	public int getDiscount() {

		return discount;
	}


	/**
	 * 
	 * @param discount
	 */
	public void setDiscount(int discount) {

		this.discount = discount;
	}





	/**
	 * 
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + discount;
		long temp;
		temp = Double.doubleToLongBits(purchaseAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
