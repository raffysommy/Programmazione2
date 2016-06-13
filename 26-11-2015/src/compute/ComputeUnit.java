package compute;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import client.ClientThread;

public class ComputeUnit {

	public static void main(String[] args) {
		Hashtable<String,String> prop=new Hashtable<String,String>();
		prop.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		prop.put("java.naming.provider.url", "tcp://127.0.0.1:61616");
		prop.put("queue.req", "REQ");
		prop.put("queue.rplm", "RPLM");
		prop.put("queue.rpls", "RPLS");
		Compute c=new Compute();
		try {
			Context jndiCtx = new InitialContext(prop);
			QueueConnectionFactory qfact=(QueueConnectionFactory) jndiCtx.lookup("QueueConnectionFactory");
			Queue req=(Queue) jndiCtx.lookup("req");
			//Queue rplm=(Queue) jndiCtx.lookup("rplm");
			//Queue rpls=(Queue) jndiCtx.lookup("rpls");
			QueueConnection qconn=(QueueConnection) qfact.createConnection();
			qconn.start();
			QueueSession qsess=(QueueSession) qconn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueReceiver qrecv=qsess.createReceiver(req);
			qrecv.setMessageListener(new MessageListner(qconn,c));		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
