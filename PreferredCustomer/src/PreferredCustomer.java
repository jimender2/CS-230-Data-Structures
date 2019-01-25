
public class PreferredCustomer extends Customer {

	double purchaseAmount;
	int discount;

	PreferredCustomer(String name, String streetAddress, String city,
			String state, String zipcode, String phoneNumber,
			int customerNumber, Boolean mailingList,
			double purchaseAmount) {

		super(name, streetAddress, city, state, zipcode, phoneNumber,
				customerNumber, mailingList);

		this.purchaseAmount = purchaseAmount;

	}
	
	PreferredCustomer(String name, String address, String phoneNumber,
			int customerNumber, Boolean mailingList,
			double purchaseAmount) {

		super(name, address, phoneNumber, customerNumber, mailingList);

		this.purchaseAmount = purchaseAmount;

		if ( 500 <= this.purchaseAmount || this.purchaseAmount < 1000) {
			discount = 5;
		}
	}

}
