
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

		if ( purchaseAmount <= 2000) {
			discount = 10;
		} else if ( purchaseAmount >= 1500) {
			discount = 7;
		} else if ( purchaseAmount >= 1000) {
			discount = 6;
		} else if ( purchaseAmount >= 500) {
			discount = 5;
		} else {
			discount = 0;
		}

	}
	
	

}
