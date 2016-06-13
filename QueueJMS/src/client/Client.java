package client;


import java.util.Hashtable;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
public class Client {

	public static void main(String[] args) {
		Hashtable<String,String> prop=new Hashtable<String,String>();
		prop.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		prop.put("java.naming.provider.url","tcp://127.0.0.1:61616");
		prop.put("queue.test", "CodaTest");
		try {
			Context jndiContex=new InitialContext(prop);
			QueueConnectionFactory connectionfactory=(QueueConnectionFactory) jndiContex.lookup("QueueConnectionFactory");
			Queue queue=(Queue) jndiContex.lookup("test");
			QueueConnection qconn=connectionfactory.createQueueConnection();
			QueueSession qsess=qconn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueSender qsend=qsess.createSender(queue);
			TextMessage message=qsess.createTextMessage();
			message.setText("ciaone su coda");
			qsend.send(message);
			qsend.close();
			qsess.close();
			qconn.close();
			
		} catch (NamingException | JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
	