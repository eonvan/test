package za.co.absa.cib.trade.credit.absa;

import org.apache.camel.Exchange;

public class AbsaCreditCheck {

	public void execute(Exchange exchange) {
		AbsaCreditCheckPayload payload = exchange.getIn().getBody(AbsaCreditCheckPayload.class);
		
		if (payload.getFinancialRating() > 2.0) exchange.getOut().setBody(new Boolean(true));
		else exchange.getOut().setBody(new Boolean(false));
	}
}
