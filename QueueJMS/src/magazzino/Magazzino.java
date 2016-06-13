package magazzino;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Magazzino {
	public static void main(String args[]){
		Hashtable<String,String> prop=new Hashtable<String,String>();
		prop.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		prop.put("java.naming.provider.url", "tcp://127.0.0.1:61616");
		prop.put("queue.test", "CodaTest");
		try {
			Context jndiCtx=new InitialContext(prop);
			QueueConnectionFactory connfact=(QueueConnectionFactory) jndiCtx.lookup("QueueConnectionFactory");
			Queue queue=(Queue) jndiCtx.lookup("test");
			QueueConnection qconn=(QueueConnection) connfact.createConnection();
			qconn.start();
			QueueSession qsess=qconn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueReceiver qrecv=qsess.createReceiver(queue);
			qrecv.setMessageListener(new MessageListner());
			//while(true)
			//System.out.println(((TextMessage)qrecv.receive()).getText());
			//qsess.close();
			//qconn.close();
	
		} catch (NamingException | JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
