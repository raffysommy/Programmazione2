package client;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client {

	public static void main(String[] args) {
		Hashtable<String,String> prop=new Hashtable<String,String>();
		prop.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		prop.put("java.naming.provider.url", "tcp://127.0.0.1:61616");
		prop.put("queue.req", "REQ");
		prop.put("queue.rplm", "RPLM");
		prop.put("queue.rpls", "RPLS");
		try {
			Context jndiCtx = new InitialContext(prop);
			QueueConnectionFactory qfact=(QueueConnectionFactory) jndiCtx.lookup("QueueConnectionFactory");
			Queue req=(Queue) jndiCtx.lookup("req");
			Queue rplm=(Queue) jndiCtx.lookup("rplm");
			Queue rpls=(Queue) jndiCtx.lookup("rpls");
			QueueConnection qconn=(QueueConnection) qfact.createConnection();
			qconn.start();
			for(int i=0;i<10;i++){
				int op1=((Double)(Math.random()*100)).intValue();
				int op2=((Double)(Math.random()*100)).intValue();
				if(op1%2==0){
					System.out.println("Moltiplicazione");
					new ClientThread(qconn,req,rplm,"mult",op1,op2).start();
				}else{
					System.out.println("Somma");
					new ClientThread(qconn,req,rpls,"sum",op1,op2).start();
				}
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
