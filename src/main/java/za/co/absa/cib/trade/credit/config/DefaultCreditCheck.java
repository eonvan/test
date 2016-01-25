package za.co.absa.cib.trade.credit.config;

import org.apache.camel.Exchange;

public class DefaultCreditCheck {

	public void execute(Exchange exchange) {
		exchange.getOut().setBody(new Boolean(false));
	}
}
