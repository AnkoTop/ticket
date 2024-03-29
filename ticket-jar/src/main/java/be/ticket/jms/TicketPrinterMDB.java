package be.ticket.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class TicketPrinterMDB implements MessageListener {
	
	@Inject
	Logger logger;
	
	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			logger.info("Received message " + tm.getText());
		} catch (JMSException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
