package za.co.absa.cib.trade.credit.hsbc;

public class HsbcCreditCheckPayload {

	private double customerCreditScore;

	public HsbcCreditCheckPayload(double customerCreditScore) {
		super();
		this.customerCreditScore = customerCreditScore;
	}

	public double getCustomerCreditScore() {
		return customerCreditScore;
	}
	
	
}
