package aero.sita.tools;

import org.apache.camel.Exchange;
import org.apache.camel.spi.ExchangeFormatter;

public class LogExchangeFormatter implements ExchangeFormatter {
	public String format(Exchange exchange) {
		return exchange.getIn().getBody(String.class);
	}
}
