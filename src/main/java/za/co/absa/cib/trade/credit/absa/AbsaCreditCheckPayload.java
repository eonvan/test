package za.co.absa.cib.trade.credit.absa;

public class AbsaCreditCheckPayload {

	private double financialRating;

	public AbsaCreditCheckPayload(double financialRating) {
		super();
		this.financialRating = financialRating;
	}

	public double getFinancialRating() {
		return financialRating;
	}
	
	
}
