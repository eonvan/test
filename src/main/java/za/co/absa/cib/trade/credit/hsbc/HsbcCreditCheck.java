package za.co.absa.cib.trade.credit.hsbc;

import org.apache.camel.Exchange;

public class HsbcCreditCheck {

	public void execute(Exchange exchange) {
		HsbcCreditCheckPayload payload = exchange.getIn().getBody(HsbcCreditCheckPayload.class);
		
		if (payload.getCustomerCreditScore() > 3.0) exchange.getOut().setBody(new Boolean(true));
		else exchange.getOut().setBody(new Boolean(false));
	}

}
