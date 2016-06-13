package main;
import java.util.Hashtable;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
public class Publish {

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
			TopicSession tsess=tconn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			TopicPublisher tsend=tsess.createPublisher(topic);
			TextMessage tmess=tsess.createTextMessage();
			tmess.setText("ciaone su topic");
			tsend.send(tmess);
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
