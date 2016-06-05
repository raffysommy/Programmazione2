package sender;

import java.util.Hashtable;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Sender {

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
			QueueSender sender=queueSession.createSender(queue);
			TextMessage message=queueSession.createTextMessage();
			for(int i=0;i<5;i++){
				message.setText("Hello n:"+i);
				sender.send(message);
			}
			message.setText("fine");
			sender.send(message);
			sender.close();
			queueSession.close();
			queueConn.close();
		} catch (NamingException | JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
