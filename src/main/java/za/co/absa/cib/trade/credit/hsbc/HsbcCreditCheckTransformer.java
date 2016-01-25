package za.co.absa.cib.trade.credit.hsbc;

import org.apache.camel.Exchange;

import za.co.absa.cib.trade.credit.CreditApplication;

public class HsbcCreditCheckTransformer {

	public void transform(Exchange exchange) {
		CreditApplication application = exchange.getIn().getBody(CreditApplication.class);
		
		HsbcCreditCheckPayload payload = new HsbcCreditCheckPayload(application.getRating());
		
		exchange.getOut().setBody(payload);
	}


}
