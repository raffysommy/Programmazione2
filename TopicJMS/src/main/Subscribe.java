package main;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Subscribe {

	public static void main(String[] args) {
		Hashtable<String,String> prop=new Hashtable<String,String>();
		prop.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		prop.put("java.naming.provider.url","tcp://127.0.0.1:61616");
		prop.put("topic.test", "TopicTest");
		try {
			Context jndiCtx=new InitialContext(prop);
			TopicConnectionFactory tcfact=(TopicConnectionFactory) jndiCtx.lookup("TopicConnectionFactory");
			Topic topic=(Topic) jndiCtx.lookup("test");
			TopicConnection tconn=tcfact.createTopicConnection();
			tconn.start();
			TopicSession tsess=tconn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			TopicSubscriber tsend=tsess.createSubscriber(topic);
			//while(true){
				TextMessage tmess=(TextMessage) tsend.receive();
				System.out.println(tmess.getText());
			//}
			tsess.close();
			tconn.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
