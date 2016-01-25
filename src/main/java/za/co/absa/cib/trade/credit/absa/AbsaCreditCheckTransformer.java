package za.co.absa.cib.trade.credit.absa;

import org.apache.camel.Exchange;

import za.co.absa.cib.trade.credit.CreditApplication;

public class AbsaCreditCheckTransformer {

	public void transform(Exchange exchange) {
		CreditApplication application = exchange.getIn().getBody(CreditApplication.class);
		
		AbsaCreditCheckPayload payload = new AbsaCreditCheckPayload(application.getRating());
		
		exchange.getOut().setBody(payload);
	}
	
	public void transformReply(Exchange exchange) {
		String reply = exchange.getIn().getBody(String.class);
		
		Boolean result = true;
		if ("DECLINED".equalsIgnoreCase(reply)) {
			result = false;
		}
		
		exchange.getOut().setBody(result);
	}
	
}
