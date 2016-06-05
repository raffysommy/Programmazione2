package receiver;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Hashtable;

public class Receiver {

	public static void main(String[] args) {
		Hashtable<String,String> prop=new Hashtable<String,String>();
		prop.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		prop.put("java.naming.provider.url", "tcp://127.0.0.1:61616");
		prop.put("queue.test", "mytestqueue");
		try {
			Context jndiContext=new InitialContext(prop);
			QueueConnectionFactory queueConnFactory=(QueueConnectionFactory)jndiContext.lookup("QueueConnectionFactory");
			Queue queue=(Queue)jndiContext.lookup("test");
			QueueConnection queueConn=queueConnFactory.createQueueConnection();
			QueueSession queueSession=queueConn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueReceiver receiver=queueSession.createReceiver(queue);
			TextMessage message=queueSession.createTextMessage();
	            
	            do{
	            	System.out.println ("In attesa di messaggi!");
	            	message = (TextMessage)receiver.receive();
	            	System.out.println ("	+ messaggio ricevuto: " + message.getText());
	            }while (message.getText().compareTo("fine") != 0); 
	              
	                       
	          receiver.close();
	          queueSession.close();
	          queueConn.close();
		} catch (NamingException | JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
