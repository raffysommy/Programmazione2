package magazzino;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MessageListner implements MessageListener {

	@Override
	public void onMessage(Message arg0) {
		TextMessage msg=(TextMessage) arg0;
		try {
			System.out.println(msg.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
