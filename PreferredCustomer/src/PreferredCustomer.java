
public class PreferredCustomer extends Customer {

	double purchaseAmount;
	int discount;

	PreferredCustomer(String name, String streetAddress, String city,
			String state, String zipcode, String phoneNumber,
			String customerNumber, Boolean mailingList,
			double purchaseAmount) {

		super(name, streetAddress, city, state, zipcode, phoneNumber,
				customerNumber, mailingList);

		this.purchaseAmount = purchaseAmount;

		discount();

	}

	PreferredCustomer(String name, String address, String phoneNumber,
			String customerNumber, Boolean mailingList,
			double purchaseAmount) {

		super(name, address, phoneNumber, customerNumber, mailingList);

		this.purchaseAmount = purchaseAmount;

		discount();

	}

	public void discount() {

		if (purchaseAmount <= 2000) {
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

	public double getPurchaseAmount() {

		return purchaseAmount;
	}

	public void setPurchaseAmount(double purchaseAmount) {

		this.purchaseAmount = purchaseAmount;
	}

	public int getDiscount() {

		return discount;
	}

	public void setDiscount(int discount) {

		this.discount = discount;
	}





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
